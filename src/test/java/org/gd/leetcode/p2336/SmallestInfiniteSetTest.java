package org.gd.leetcode.p2336;

import lombok.SneakyThrows;
import lombok.val;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static java.util.Objects.requireNonNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Test for {@link org.gd.leetcode.p2336.SmallestInfiniteSet}.
 *
 * @author Horkhover Dmytro
 * @see SmallestInfiniteSet
 * @since 2022-09-23
 */
@DisplayName("LeetCode #2336: Smallest Number in Infinite Set")
class SmallestInfiniteSetTest {

    @Test
    @SneakyThrows
    void test_001() {
        val set = new SmallestInfiniteSet();

        assertEquals(1, set.popSmallest());
        assertEquals(2, set.popSmallest());

        set.addBack(3);

        assertEquals(3, set.popSmallest());

        set.addBack(2);

        assertEquals(2, set.popSmallest());
        assertEquals(4, set.popSmallest());
    }

    @Test
    @SneakyThrows
    void test_002() {
        val set = new SmallestInfiniteSet();

        assertEquals(1, set.popSmallest());

        set.addBack(1);

        assertEquals(1, set.popSmallest());
        assertEquals(2, set.popSmallest());
        assertEquals(3, set.popSmallest());

        set.addBack(2);
        set.addBack(3);

        assertEquals(2, set.popSmallest());
        assertEquals(3, set.popSmallest());
    }

    @Test
    @SneakyThrows
    void test_003() {

        val lines = asd();

        int length = lines.get(0).length;

        val set = new SmallestInfiniteSet();

        for (int i = 0; i < length; i++) {
            val operation = lines.get(0)[i];
            switch (operation) {
                case "addBack":
                    int num = Integer.parseInt(lines.get(1)[i]);
                    System.out.printf("%s.addBack(%d)\n", set, num);
                    set.addBack(num);
                    break;
                case "popSmallest":
                    int expected = Integer.parseInt(lines.get(2)[i]);
                    int actual = set.popSmallest();
                    System.out.printf("%s.popSmallest() == %d; expected = %d\n", set, actual, expected);
                    assertEquals(expected, actual);
            }
        }
    }

    @SneakyThrows
    private static List<String[]> asd() {
        try (val resource = SmallestInfiniteSetTest.class.getResourceAsStream("test_case_003.txt")) {
            requireNonNull(resource, "\"resource\" cannot be null");
            val lines = new BufferedReader(new InputStreamReader(resource)).lines()
                    .map(line -> {
                        String[] split = line.substring(1, line.length() - 1).split(",");
                        for (int i = 0; i < split.length; i++) {
                            if (Objects.equals(split[i], "null")) {
                                split[i] = null;
                                continue;
                            }
                            String s = split[i];
                            if (s.startsWith("\"") || s.startsWith("[")) {
                                s = s.substring(1);
                            }
                            if (s.endsWith("\"") || s.endsWith("]")) {
                                s = s.substring(0, s.length() - 1);
                            }
                            split[i] = s;
                        }
                        return split;
                    })
                    .collect(Collectors.toList());

            assertEquals(3, lines.size());
            for (int i = 1; i < 3; i++) {
                assertEquals(lines.get(0).length, lines.get(i).length);
            }

            return lines;
        }
    }
}
