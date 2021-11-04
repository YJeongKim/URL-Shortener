package dev.yjeong.urlshortener.domain.url;

import dev.yjeong.urlshortener.domain.BaseEntity;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "urls")
@Entity
public class Url extends BaseEntity {

    @Column(nullable = false, columnDefinition = "TEXT")
    private String originalUrl;

    @Column(nullable = false)
    private String shortenedUrl;

    @Column(nullable = false)
    private Integer redirectCount;

    @Builder
    public Url(String originalUrl, String shortenedUrl) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
        this.redirectCount = 0;
    }

    public void setShortenedUrl(String shortenedUrl) {
        this.shortenedUrl = shortenedUrl;
    }

    public void increaseRedirectCount() {
        this.redirectCount++;
    }

}
