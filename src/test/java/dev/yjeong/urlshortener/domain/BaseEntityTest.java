package dev.yjeong.urlshortener.domain;

import dev.yjeong.urlshortener.domain.url.Url;
import dev.yjeong.urlshortener.domain.url.UrlRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class BaseEntityTest {

    @Autowired
    private UrlRepository urlRepository;

    @Test
    @DisplayName("BaseEntity 저장 테스트")
    public void saveBaseEntityTest() {
        // given
        LocalDateTime now = LocalDateTime.of(2021, 11, 4, 0, 0, 0);
        Url url = Url.builder()
                .originalUrl("originalUrl")
                .shortenedUrl("shortenedUrl")
                .build();

        // when
        Url savedUrl = urlRepository.save(url);

        // then
        assertThat(savedUrl.getCreatedAt()).isAfter(now);
        assertEquals(savedUrl.getCreatedAt(), savedUrl.getUpdatedAt());
    }

}
