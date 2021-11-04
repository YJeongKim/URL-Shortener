package dev.yjeong.urlshortener.common.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UrlManager {

    private final String protocol = "http";

    @Value("${server.host}")
    private String host;

    @Value("${server.port}")
    private String port;

    public String getUrl(String path) {
        return protocol + "://" + host + ":" + port + "/" + path;
    }

    public String getPath(String url) {
        String regex = protocol + "://" + host + ":" + port + "/";
        return url.replace(regex, "");
    }

}
