from typing import List


class Solution:

    def longestCommonPrefix(self, strs: List[str]) -> str:

        if not str or len(strs) == 0:
            return ""

        __prefix: str = strs[0]
        if len(strs) == 1 or len(__prefix) == 0:
            return __prefix

        def prefix(str0: str, str1: str) -> str:
            l0 = len(str0)
            l1 = len(str1)
            i0 = 0
            i1 = 0
            while i0 < l0 and i1 < l1:
                if str0[i0] != str1[i1]:
                    break
                i0 += 1
                i1 += 1

            if i0 == l0:
                return str0
            if i1 == l1:
                return str1

            return str[:i0]

        i = 1
        n = len(strs)
        while i < n:
            __prefix = prefix(__prefix, strs[i])
            if len(__prefix) == 0:
                return ""
            i += 1

        return __prefix

