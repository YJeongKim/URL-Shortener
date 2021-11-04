package dev.yjeong.urlshortener.service.url;

import dev.yjeong.urlshortener.common.exception.BadRequestException;
import dev.yjeong.urlshortener.common.exception.ExceptionType;
import dev.yjeong.urlshortener.common.exception.NotFoundException;
import dev.yjeong.urlshortener.common.util.Base62Manager;
import dev.yjeong.urlshortener.common.util.UrlManager;
import dev.yjeong.urlshortener.domain.url.Url;
import dev.yjeong.urlshortener.domain.url.UrlRepository;
import dev.yjeong.urlshortener.dto.url.UrlRequestDto;
import dev.yjeong.urlshortener.dto.url.UrlResponseDto;
import lombok.RequiredArgsConstructor;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final Base62Manager base62Manager;
    private final UrlManager urlManager;

    @Transactional
    public UrlResponseDto shortenUrl(UrlRequestDto urlRequestDto) {
        Url url;

        if (!isValidUrl(urlRequestDto.getUrl())) throw new BadRequestException(ExceptionType.INVALID_URL_FORMAT);

        if (urlRepository.existsByOriginalUrl(urlRequestDto.getUrl())) {
            url = urlRepository.findByOriginalUrl(urlRequestDto.getUrl());
        } else {
            url = urlRepository.save(Url.builder()
                    .originalUrl(urlRequestDto.getUrl())
                    .shortenedUrl("")
                    .build());

            String shortenedUrl = urlManager.getUrl(base62Manager.encode(url.getId()));
            url.setShortenedUrl(shortenedUrl);
        }
        return UrlResponseDto.of(url);
    }

    public String getOriginalUrl(String path) {
        long urlId = base62Manager.decode(path);
        Url url = urlRepository.findById(urlId)
                .orElseThrow(() -> new NotFoundException(ExceptionType.NOT_FOUNT_URL));

        url.increaseRedirectCount();
        return url.getOriginalUrl();
    }

    private boolean isValidUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(url);
    }

}
