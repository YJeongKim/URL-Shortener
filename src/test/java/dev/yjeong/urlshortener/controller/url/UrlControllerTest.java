package dev.yjeong.urlshortener.controller.url;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import dev.yjeong.urlshortener.common.util.Base62Manager;
import dev.yjeong.urlshortener.common.util.UrlManager;
import dev.yjeong.urlshortener.dto.url.UrlRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
public class UrlControllerTest {

    @Autowired
    UrlController urlController;

    @Autowired
    Base62Manager base62Manager;

    @Autowired
    UrlManager urlManager;

    @Autowired
    MockMvc mockMvc;

    @Test
    @DisplayName("URL 단축 API 테스트")
    void shortenUrlTest() throws Exception {
        // given
        String url = "https://www.google.com/";
        UrlRequestDto urlRequestDto = UrlRequestDto.builder()
                .url(url)
                .build();
        String jsonData = new Gson().toJson(urlRequestDto);

        // when
        MvcResult mvcResult = mockMvc.perform(post("/api/urls")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonData))
                .andExpect(status().isOk())
                .andReturn();


        // then
        String result = mvcResult.getResponse().getContentAsString();
        JsonObject jsonObject = JsonParser.parseString(result).getAsJsonObject();

        String originalUrl = jsonObject.get("originalUrl").getAsString();
        String shortenedUrl = jsonObject.get("shortenedUrl").getAsString();
        long urlId = base62Manager.decode(urlManager.getPath(shortenedUrl));

        assertEquals(url, originalUrl);
        assertEquals(urlId, 1);
    }

}
