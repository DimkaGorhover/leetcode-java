package org.gd.leetcode.p0208;

import lombok.NonNull;

enum TestCaseOperation {

    CONSTRUCTOR {
        @Override
        public TestAssertion createTestAssertion(@NonNull RawTestCaseEntry entry) {
            return NothingTestAssertion.INSTANCE;
        }
    },
    INSERT {
        @Override
        public TestAssertion createTestAssertion(@NonNull RawTestCaseEntry entry) {
            return InsertTestAssertion.of(entry.getValue());
        }
    },
    START_WITH {
        @Override
        public TestAssertion createTestAssertion(@NonNull RawTestCaseEntry entry) {
            return new StartsWithTestAssertion(entry.getValue(), Boolean.parseBoolean(entry.getResult()));
        }
    },
    SEARCH {
        @Override
        public TestAssertion createTestAssertion(@NonNull RawTestCaseEntry entry) {
            return new SearchTestAssertion(entry.getValue(), Boolean.parseBoolean(entry.getResult()));
        }
    };

    public abstract TestAssertion createTestAssertion(@NonNull RawTestCaseEntry entry);

    public static TestCaseOperation of(@NonNull String name) {
        switch (name) {
            case "Trie": return CONSTRUCTOR;
            case "insert": return INSERT;
            case "startsWith": return START_WITH;
            case "search": return SEARCH;
        }
        throw new UnsupportedOperationException(String.format("Operation \"%s\" is not supported", name));
    }
}
