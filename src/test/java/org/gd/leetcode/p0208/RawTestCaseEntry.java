package org.gd.leetcode.p0208;

import lombok.Value;

@Value
@lombok.Builder(builderClassName = "Builder", toBuilder = true)
class RawTestCaseEntry {

    int id;
    TestCaseOperation operation;
    String value, result;
}
