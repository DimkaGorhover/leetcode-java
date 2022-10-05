package org.gd.leetcode.p0535;

import org.gd.leetcode.common.LeetCode;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.com/problems/encode-and-decode-tinyurl/">LeetCode #535: Encode and Decode TinyURL</a>
 *
 * @author Horkhover Dmytro
 * @since 2022-10-05
 */
@LeetCode(
        name = "Encode and Decode TinyURL",
        difficulty = LeetCode.Level.MEDIUM,
        state = LeetCode.State.DONE,
        tags = {
                LeetCode.Tags.DESIGN,
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.STRING,
                LeetCode.Tags.HASH_FUNCTION
        }
)
@SuppressWarnings("HttpUrlsUsage")
class Codec {

    private static final String PREFIX = "http://tinyurl.com/";
    private static final int HASH_LENGTH = 6;

    private final Map<String, String> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String hash = hash(longUrl);
        map.put(hash, longUrl);
        return PREFIX + hash;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        String hash = shortUrl.substring(PREFIX.length());
        return map.get(hash);
    }

    private String hash(String text) {
        char[] chars = new char[6];
        int hash = 1;
        for (int i = 0, j = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            hash = c + (hash << 6) + (hash << 16) - hash;
            chars[j % chars.length] = (char) hash;
        }
        return new String(chars);
    }
}
