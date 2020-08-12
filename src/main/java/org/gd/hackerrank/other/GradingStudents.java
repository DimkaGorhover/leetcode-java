package org.gd.hackerrank.other;

import java.util.List;
import java.util.stream.Collectors;

/**
 * https://www.hackerrank.com/challenges/grading/
 *
 * @author Horkhover Dmytro
 * @since 2020-08-12
 */
class GradingStudents {

    private static int nextGrade(int grade) {
        int next = ((grade / 10) * 10) + 5;
        if ((grade / 5) % 2 != 0)
            next += 5;
        return next;
    }

    public static List<Integer> gradingStudents(List<Integer> grades) {
        return grades.stream()
                .map(grade -> {
                    if (grade < 38) return grade;
                    int next = nextGrade(grade);
                    if (next - grade < 3) grade = next;
                    return Math.min(grade, 100);
                })
                .collect(Collectors.toList());
    }
}
