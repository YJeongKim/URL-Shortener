package dev.yjeong.urlshortener.controller.url;

import dev.yjeong.urlshortener.dto.url.UrlRequestDto;
import dev.yjeong.urlshortener.dto.url.UrlResponseDto;
import dev.yjeong.urlshortener.service.url.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/api/urls")
    public ResponseEntity<UrlResponseDto> shortenUrl(@RequestBody UrlRequestDto urlRequestDto) {
        UrlResponseDto urlResponseDto = urlService.shortenUrl(urlRequestDto);
        return ResponseEntity.ok().body(urlResponseDto);
    }

}
