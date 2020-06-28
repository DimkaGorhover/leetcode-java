class Solution:

    def __init__(self):
        super().__init__()
        self.sb: str = ""

    def decodeString(self, s: str) -> str:
        if not s:
            return s

        self.sb: str = ""

        def find_last(start: int, end: int) -> int:
            i: int = start
            open_count: int = 1
            while i < end:
                if s[i] == '[':
                    open_count += 1
                elif s[i] == ']':
                    open_count -= 1
                if open_count == 0:
                    return i
                i += 1

            return -1

        def decode_string(start: int, end: int):
            i: int = start
            d: int = 0
            while i < end:
                c = s[i]
                if c == ']':
                    continue
                if c.isdigit():
                    d = d * 10 + int(c)
                elif c == '[':
                    last = find_last(i + 1, end)
                    while d > 0:
                        decode_string(i + 1, last)
                        d -= 1
                    i = last
                else:
                    self.sb += c

                i += 1

        decode_string(0, len(s))

        return self.sb

