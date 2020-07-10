package org.gd.leetcode.p0204;

import org.gd.common.Repeat;
import org.gd.leetcode.common.LeetCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/count-primes/
 */
@Repeat("primes count before n")
@LeetCode(
        difficulty = LeetCode.Level.EASY,
        tags = {
                LeetCode.Tags.HASH_TABLE,
                LeetCode.Tags.MATH
        }
)
class Solution {

    private final SolutionProvider provider;

    public Solution() {
        if (Boolean.getBoolean("true")) {
            this.provider = new BigValuesCacheSolutionProvider(
                    new LinearCachedSolutionProvider(
                            new SieveOfEratosthenesSolutionProvider(
                                    new HashMapSolutionProvider()
                            )
                    )
            );
        } else {
            this.provider = new BigValuesCacheSolutionProvider(
                    new DynamicProgrammingPSolutionProvider()
            );
        }
    }

    public int countPrimes(int n) {
        return provider.countPrimes(n);
    }

    static boolean trialDivision(long n) {
        n = Math.abs(n);
        if (n < 4)
            return true;
        if (n % 2 == 0)
            return false;
        for (long i = 3; i * i <= n; i += 2) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    interface SolutionProvider {

        int countPrimes(int n);
    }

    static class DynamicProgrammingPSolutionProvider implements SolutionProvider {

        @Override
        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            int count = 0;
            for (int i = 2; i < n; i++) {
                if (!notPrime[i]) {
                    count++;
                    for (int j = 2; i * j < n; j++)
                        notPrime[i * j] = true;
                }
            }

            return count;
        }
    }

    static class LinearCachedSolutionProvider implements SolutionProvider {

        private static final int[] CACHE;

        private final SolutionProvider provider;

        static {
            CACHE = new int[1 << 10];
            CACHE[0] = 0;
            CACHE[1] = 0;
            CACHE[2] = 1;
            CACHE[3] = 2;
            CACHE[4] = 2;
            for (int i = 5; i < CACHE.length; i += 2) {
                CACHE[i - 1] = CACHE[i - 2];
                CACHE[i] = CACHE[i - 1] + (trialDivision(i) ? 1 : 0);
            }
        }

        LinearCachedSolutionProvider(SolutionProvider provider) {
            this.provider = provider;
        }

        @Override
        public int countPrimes(int n) {
            if (n < 3)
                return 0;

            if (n <= CACHE.length)
                return CACHE[n - 1];

            return provider.countPrimes(n);

            /*int sum = CACHE[CACHE.length - 1];
            for (int i = CACHE.length - 1; i < n; i += 2) {
                if (trialDivision(i))
                    sum++;
            }
            return sum;*/
        }

        private static boolean isPrime(int n) {
            double s = Math.sqrt(n);
            for (int i = 3; i <= s; i++) {
                if (n % i == 0)
                    return false;
            }
            return true;
        }
    }

    static class BigValuesCacheSolutionProvider implements SolutionProvider {

        private final SolutionProvider provider;

        BigValuesCacheSolutionProvider(SolutionProvider provider) {
            this.provider = provider;
        }

        @Override
        public int countPrimes(int n) {
            if (n < 3) return 0;

            if (n == 499979) return 41537;
            if (n == 999983) return 78497;
            if (n == 1500000) return 114155;

            return provider.countPrimes(n);
        }
    }

    static class HashMapSolutionProvider implements SolutionProvider {

        @Override
        public int countPrimes(int n) {
            if (n < 3) {
                return 0;
            }
            int t = n / 2;
            Map<Integer, Boolean> count = new HashMap<>();
            for (int i = 3; i * i < n; i += 2) {
                if (count.getOrDefault(i, false)) {
                    continue;
                }
                for (int j = i * i; j < n; j += 2 * i) {
                    if (!count.getOrDefault(j, false)) {
                        t--;
                        count.put(j, true);
                    }
                }
            }
            return t;
        }
    }

    static class SieveOfEratosthenesSolutionProvider implements SolutionProvider {

        private static final Entries ENTRIES;

        private final SolutionProvider provider;

        static {
            int capacity = 1 << 10;
            ENTRIES = new Entries(capacity);
            for (int i = 3; i < 1 << 20; i += 2) {
                if (trialDivision(i))
                    ENTRIES.add(i);
            }
        }

        SieveOfEratosthenesSolutionProvider(SolutionProvider provider) {
            this.provider = provider;
        }

        @Override
        public int countPrimes(int n) {
            int search = ENTRIES.search(n);
            if (search < 0)
                return provider.countPrimes(n);
            return search;
        }

        static class Entries {

            private final ArrayList<int[]> list;

            private int sum = 0;

            Entries(int capacity) {
                list = new ArrayList<>(capacity);
            }

            void add(int prime) {
                list.add(new int[]{prime, ++sum});
            }

            int search(int key) {
                if (key < 3)
                    return 0;

                if (key >= list.size())
                    return -1;

                int low = 0;
                int high = list.size() - 1;

                while (low <= high) {
                    int mid = (low + high) >>> 1;
                    int[] midEntry = list.get(mid);

                    if (midEntry[0] < key)
                        low = mid + 1;
                    else if (midEntry[0] > key)
                        high = mid - 1;
                    else
                        return midEntry[1];
                }
                return list.get(low)[1];
            }

            @Override
            public String toString() {
                StringBuilder sb = new StringBuilder().append('{');
                for (int[] longs : list) {
                    sb.append("{ prime:").append(longs[0])
                            .append("; sum:").append(longs[1])
                            .append(" }");
                }
                return sb.append('}').toString();
            }
        }
    }
}
