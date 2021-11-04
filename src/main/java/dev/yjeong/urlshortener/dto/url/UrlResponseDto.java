package dev.yjeong.urlshortener.dto.url;

import dev.yjeong.urlshortener.domain.url.Url;
import lombok.Builder;
import lombok.Getter;

@Getter
public class UrlResponseDto {

    private String originalUrl;
    private String shortenedUrl;
    private Integer redirectCount;

    @Builder
    public UrlResponseDto(String originalUrl, String shortenedUrl, Integer redirectCount) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
        this.redirectCount = redirectCount;
    }

    public static UrlResponseDto of(Url url) {
        return UrlResponseDto.builder()
                .originalUrl(url.getOriginalUrl())
                .shortenedUrl(url.getShortenedUrl())
                .redirectCount(url.getRedirectCount())
                .build();
    }

}
