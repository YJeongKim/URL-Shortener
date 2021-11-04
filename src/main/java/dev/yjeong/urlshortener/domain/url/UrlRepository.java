package dev.yjeong.urlshortener.domain.url;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {

    boolean existsByOriginalUrl(String originalUrl);
    Url findByOriginalUrl(String originalUrl);

}
