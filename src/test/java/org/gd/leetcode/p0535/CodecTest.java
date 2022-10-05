package org.gd.leetcode.p0535;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test for {@link  org.gd.leetcode.p0535.Codec}.
 *
 * @author Horkhover Dmytro
 * @see Codec
 * @since 2022-10-05
 */
@DisplayName("LeetCode #535: Encode and Decode TinyURL")
@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
class CodecTest {

    @SuppressWarnings("HttpUrlsUsage")
    @Test
    @SneakyThrows
    void test_001() {
        val url = "https://leetcode.com/problems/design-tinyurl";
        val obj = new Codec();
        val tiny = obj.encode(url);
        assertThat(tiny).startsWith("http://tinyurl.com/");
        assertThat(obj.decode(tiny)).isEqualTo(url);
    }
}