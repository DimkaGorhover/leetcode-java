package org.gd.leetcode.p0307;

import org.gd.common.SegmentTree;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Stream;

/**
 * Test for {@link NumArray}
 *
 * @since 2019-09-18
 */
@Disabled
@DisplayName("LeetCode #307: range sum query mutable")
class NumArrayTest {

    private static Stream<Arguments> args() {

        return Stream.of(
                TestCase.of(new int[]{5, 18, 13},
                        List.of(
                                SumSubCases.of(0, 2, 36),
                                UpdateSubCases.of(1, -1),
                                UpdateSubCases.of(2, 3),
                                UpdateSubCases.of(0, 5),
                                UpdateSubCases.of(0, -4),
                                SumSubCases.of(0, 2, -2)
                        )),
                TestCase.of(
                        new int[]{1, 2, 3, 4},
                        List.of(
                                SumSubCases.of(0, 2, 6),
                                UpdateSubCases.of(0, 3),
                                SumSubCases.of(0, 2, 8)
                        ))
        );
    }

    @ParameterizedTest
    @MethodSource("args")
    @DisplayName("SumRange")
    void test_SumRange(TestCase testCase) {

        System.out.println(
                read("test_case_003.txt")
        );

        SegmentTree st = new SegmentTree(testCase.nums());
        NumArray numArray = new NumArray(testCase.nums());

        try {
            for (SubCase subCase : testCase) {

                System.out.println(subCase);

                subCase.doAssert(st);
                System.out.printf("SegmentTree: %n%s", st);

                subCase.doAssert(numArray);
                System.out.printf("NumArray: %n%s", numArray);

                System.out.println("-".repeat(80));
            }
        } catch (Throwable e) {

            throw e;
        }
    }

    private static String readLine(BufferedReader reader) throws IOException {
        String line = reader.readLine();
        return line.substring(1, line.length() - 1);
    }

    private static Object read(String fileName) {
        try (var resource = NumArrayTest.class.getResourceAsStream(fileName);
             var reader = new BufferedReader(new InputStreamReader(resource))) {

            String[] names = readLine(reader).split(",");
            String valueLine = readLine(reader);
            String expectationsLine = readLine(reader);

            int[] arr = null;

            List<SubCase> subCases = new ArrayList<>();

            int i = 0;
            for (String name : names) {
                switch (name.substring(1, name.length() - 1)) {
                    case "NumArray":
                        ParseRes<int[]> res = array(i, valueLine);
                        arr = res.res;
                        valueLine = valueLine.substring((i = res.nextIndex) + 3);
                        break;
                    case "sumRange":
                        System.out.println();
                        break;
                    case "update":
                        System.out.println();
                        break;
                }
            }

            return arr;

        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    private static ParseRes<int[]> array(int index, String str) {
        List<Integer> list = new ArrayList<>();
        int num = 0;
        int count = 0;
        for (; index < str.length(); index++) {
            char c = str.charAt(index);
            if (Character.isDigit(c)) {
                num = num * 10 + Character.digit(c, 10);
                count++;
            } else if (c == ']') {
                break;
            } else if (c == ',' && count > 0) {
                list.add(num);
                count = 0;
                num = 0;
            }
        }
        return new ParseRes<>(
                index,
                list.stream()
                        .mapToInt(Integer::intValue)
                        .toArray());
    }

}