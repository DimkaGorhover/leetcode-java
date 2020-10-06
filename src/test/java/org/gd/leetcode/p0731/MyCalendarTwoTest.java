package org.gd.leetcode.p0731;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.function.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test for {@link MyCalendarTwo}
 *
 * @author Horkhover Dmytro
 * @see org.gd.leetcode.p0729.MyCalendarTest
 * @since 2020-10-02
 */
@SuppressWarnings("JavadocReference")
@DisplayName("Test for org.gd.leetcode.p0731.MyCalendarTwo")
class MyCalendarTwoTest {

    private static Stream<Arguments> args() {
        return Stream.of(
                ((Supplier<Arguments>) () -> {

                    String valuesString = "" +
                            "[47,50],[1,10],[27,36],[40,47],[20,27],[15,23],[10,18],[27,36],[17,25],[8,17],[24,33]," +
                            "[23,28],[21,27],[47,50],[14,21],[26,32],[16,21],[2,7],[24,33],[6,13],[44,50],[33,39]," +
                            "[30,36],[6,15],[21,27],[49,50],[38,45],[4,12],[46,50],[13,21]";

                    List<int[]> values = Arrays
                            .stream(valuesString
                                    .substring(1, valuesString.length() - 1)
                                    .split("\\],\\["))
                            .map(s -> {
                                String[] split = s.split(",");
                                return new int[]{Integer.parseInt(split[0]), Integer.parseInt(split[1])};
                            })
                            .collect(Collectors.toList());

                    List<Boolean> results = Arrays
                            .stream("true,true,true,true,true,true,true,true,false,false,false,false,false,true,false,false,false,true,false,false,false,false,false,false,false,false,true,false,false,false".split(","))
                            .map(s -> Boolean.parseBoolean(s.trim().toLowerCase()))
                            .collect(Collectors.toList());

                    var factory = new MyCalendarExecutableFactory();

                    List<Executable> executables = new ArrayList<>(results.size());

                    for (int i = 0; i < values.size(); i++) {

                        executables.add(factory.create(values.get(i)[0], values.get(i)[1], results.get(i)));
                    }

                    return Arguments.of(executables);

                }).get()
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("asdad")
    @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_asdad(List<Executable> executables) throws Throwable {

        for (Executable executable : executables) {
            executable.execute();
        }
    }





/*
["MyCalendarTwo","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book","book"]
[[],]
*/

    //[null,]

    @Test
    @DisplayName("Book")
    //@Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
    void test_Book() {

        var calendar = new MyCalendarTwo();

        assertTrue(calendar.book(20, 30));
        assertTrue(calendar.book(0, 10));
        assertTrue(calendar.book(10, 20));
        assertTrue(calendar.book(20, 30));

        System.out.println(calendar);

        assertTrue(calendar.book(-5, 11));

        assertFalse(calendar.book(13, 21));
        assertTrue(calendar.book(13, 17));
        assertFalse(calendar.book(29, 30));
        assertFalse(calendar.book(29, 31));
    }
}
