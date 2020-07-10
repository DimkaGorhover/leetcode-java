class BrowserHistory:

    def __init__(self, homepage: str):
        self.history = [homepage]
        self.cursor = 0
        self.size = 1

    def visit(self, url: str) -> None:

        cursor = self.cursor + 1

        if cursor == len(self.history):
            self.history.append(url)
        else:
            self.history[cursor] = url

        self.cursor = cursor
        self.size = cursor + 1

    def back(self, steps: int) -> str:
        self.cursor = max(0, self.cursor - steps)
        return self.history[self.cursor]

    def forward(self, steps: int) -> str:
        self.cursor = min(self.cursor + steps, self.size - 1)
        return self.history[self.cursor]
