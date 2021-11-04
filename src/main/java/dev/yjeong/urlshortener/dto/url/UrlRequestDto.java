package dev.yjeong.urlshortener.dto.url;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UrlRequestDto {

    private String url;

    @Builder
    public UrlRequestDto(String url) {
        this.url = url;
    }

}
