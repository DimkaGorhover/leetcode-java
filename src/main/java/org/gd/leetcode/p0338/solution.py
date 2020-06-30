class Solution:

    def countBits(self, num: int) -> List[int]:

        arr = [0]
        if num == 0:
            return arr

        i = 1
        while i <= num:
            arr.append(arr[i >> 1] + (i & 1))
            i += 1
        return arr

    # def countBits(self, num: int) -> List[int]:
    #     res = [0]
    #     while len(res) <= num:
    #         res += [i + 1 for i in res]
    #     return res[:num + 1]

