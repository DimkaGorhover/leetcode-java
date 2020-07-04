class Solution:
    def isSubsequence(self, sub_seq: str, seq: str) -> bool:

        sub_seq_len: int = len(sub_seq)
        i: int = 0

        seq_len = len(seq)
        j: int = 0

        while i < sub_seq_len and j < seq_len:
            if sub_seq[i] == seq[j]:
                i += 1
            j += 1

        return i == sub_seq_len
