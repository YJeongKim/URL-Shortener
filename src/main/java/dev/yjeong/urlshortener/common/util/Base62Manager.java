package dev.yjeong.urlshortener.common.util;

import org.springframework.stereotype.Service;

@Service
public class Base62Manager {

    private final long LENGTH = 10000000;
    private final int BASE62_LENGTH = 62;
    private final String BASE62 = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public String encode(Long value) {
        StringBuilder result = new StringBuilder();
        value += LENGTH;

        while (value > 0) {
            result.append(BASE62.charAt((int) (value % BASE62_LENGTH)));
            value /= BASE62_LENGTH;
        }
        return result.reverse().toString();
    }

    public Long decode(String value) {
        long result = 0;

        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);

            if ('a' <= ch && ch <= 'z') {
                result = result * BASE62_LENGTH + ch - 'a';
            } else if ('A' <= ch && ch <= 'Z') {
                result = result * BASE62_LENGTH + ch - 'A' + 36;
            } else if ('0' <= ch && ch <= '9') {
                result = result * BASE62_LENGTH + ch - '0' + 26;
            }
        }
        result -= LENGTH;
        return result;
    }

}
