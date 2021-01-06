package org.gd.leetcode.p1117;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.gd.common.SafeRunnable;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

@RequiredArgsConstructor
enum Molecule {

    HYDROGEN('H') {
        @NonNull
        @Override
        protected SafeRunnable createRunnable0(@NonNull H2O solution,
                                               @NonNull Runnable appendRunnable) {
            return () -> solution.hydrogen(appendRunnable);
        }
    },
    OXYGEN('O') {
        @NonNull
        @Override
        protected SafeRunnable createRunnable0(@NonNull H2O solution,
                                               @NonNull Runnable appendRunnable) {
            return () -> solution.oxygen(appendRunnable);
        }
    };

    final char c;

    private int count(String input) {
        assertThat(input).matches("^([OH]*)$");
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            if (c == input.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    @NonNull
    static Stream<Thread> createThreads(@NonNull String input,
                                        @NonNull H2O solution,
                                        @NonNull StringBuffer sb) {
        return Arrays.stream(values())
                .flatMap(molecule -> molecule.createThreads0(input, solution, sb));
    }

    @NonNull
    private Stream<Thread> createThreads0(@NonNull String input,
                                          @NonNull H2O solution,
                                          @NonNull StringBuffer sb) {
        SafeRunnable runnable = createRunnable0(solution, () -> sb.append(c));
        return IntStream.range(0, count(input))
                .mapToObj(index -> {
                    Thread thread = new Thread(runnable);
                    thread.setName(String.format("%s_%d", name(), index));
                    return thread;
                });
    }

    @NonNull
    protected abstract SafeRunnable createRunnable0(@NonNull H2O solution,
                                                    @NonNull Runnable appendRunnable);
}
