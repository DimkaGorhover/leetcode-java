from typing import List


class ListNode:

    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

    def __str__(self):
        __str = F"({self.val})"
        if self.next:
            __str = F"{__str}->{self.next}"
        return __str

    @staticmethod
    def of(arr: List[int]):
        __tmp = ListNode(-1)
        __tail = __tmp
        i = 0
        while i < len(arr):
            __node = ListNode(arr[i])
            __tail.next = __node
            __tail = __node
            i += 1

        return __tmp.next


class Solution:
    def addTwoNumbers(self, l1: ListNode, l2: ListNode) -> ListNode:

        if not l1: return l2
        if not l2: return l1

        __head: ListNode = ListNode(-1)
        __tail: ListNode = __head
        __sum: int = 0

        def get_val(node: ListNode) -> int:
            return node.val if node else 0

        def swap_node(node: ListNode, val: int) -> ListNode:
            __node = ListNode(val)
            node.next = __node
            return __node

        def next_node(node: ListNode) -> ListNode:
            return node.next if node else None

        while l1 or l2:
            __sum += get_val(l1)
            __sum += get_val(l2)

            __tail = swap_node(__tail, int(__sum % 10))
            __sum = int(__sum / 10)

            l1 = next_node(l1)
            l2 = next_node(l2)

        if __sum > 0:
            __tail = swap_node(__tail, __sum)

        return __head.next


s = Solution().addTwoNumbers(ListNode.of([9, 2, 9]), ListNode.of([9, 9]))

print(s)
