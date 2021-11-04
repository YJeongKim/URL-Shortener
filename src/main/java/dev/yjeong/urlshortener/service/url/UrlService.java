package dev.yjeong.urlshortener.service.url;

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

@RequiredArgsConstructor
@Service
public class UrlService {

    private final UrlRepository urlRepository;
    private final Base62Manager base62Manager;
    private final UrlManager urlManager;

    @Transactional
    public UrlResponseDto shortenUrl(UrlRequestDto urlRequestDto) {
        Url url;

        if (!isValidUrl(urlRequestDto.getUrl())) throw new IllegalArgumentException();

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

    private boolean isValidUrl(String url) {
        UrlValidator urlValidator = new UrlValidator();
        return urlValidator.isValid(url);
    }

}
