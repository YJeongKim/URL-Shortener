package dev.yjeong.urlshortener.domain.url;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class UrlRepositoryTest {

    @Autowired
    private UrlRepository urlRepository;

    @Test
    @DisplayName("url 저장 테스트")
    void saveUrl() {
        // given
        String originalUrl = "http://localhost:8080/url-shortener";
        String shortenedUrl = "http://localhost:8080/abc";
        Url url = Url.builder()
                .originalUrl(originalUrl)
                .shortenedUrl(shortenedUrl)
                .build();

        // when
        Url savedUrl = urlRepository.save(url);

        // then
        assertEquals(originalUrl, savedUrl.getOriginalUrl());
        assertEquals(shortenedUrl, savedUrl.getShortenedUrl());
        assertEquals(0, savedUrl.getRedirectCount());
    }

}
