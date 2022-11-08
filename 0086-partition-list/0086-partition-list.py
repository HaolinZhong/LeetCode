# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def partition(self, head: Optional[ListNode], x: int) -> Optional[ListNode]:
        d1, d2 = ListNode(), ListNode()
        p1, p2 = d1, d2
        
        while head != None:
            if head.val >= x:
                p2.next = head
                p2 = p2.next
            else:
                p1.next = head
                p1 = p1.next
            head = head.next
        
        p1.next, p2.next = d2.next, None
        
        return d1.next