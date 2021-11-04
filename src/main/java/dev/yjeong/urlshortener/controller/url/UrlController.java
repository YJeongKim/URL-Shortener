package dev.yjeong.urlshortener.controller.url;

import dev.yjeong.urlshortener.dto.url.UrlRequestDto;
import dev.yjeong.urlshortener.dto.url.UrlResponseDto;
import dev.yjeong.urlshortener.service.url.UrlService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
@RestController
public class UrlController {

    private final UrlService urlService;

    @PostMapping("/api/urls")
    public ResponseEntity<UrlResponseDto> shortenUrl(@RequestBody UrlRequestDto urlRequestDto) {
        UrlResponseDto urlResponseDto = urlService.shortenUrl(urlRequestDto);
        return ResponseEntity.ok().body(urlResponseDto);
    }

    @GetMapping("/{path}")
    public void redirectUrl(@PathVariable String path,
                            HttpServletResponse httpServletResponse) throws IOException {
        String originalUrl = urlService.getOriginalUrl(path);
        httpServletResponse.sendRedirect(originalUrl);
    }

}
