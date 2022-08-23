# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        ans = ListNode()
        p = ans
        cur = 0
        while l1 != None and l2 != None:
            cur += l1.val + l2.val
            p.next = ListNode(cur % 10)
            cur = cur // 10
            p = p.next
            l1 = l1.next
            l2 = l2.next
            
        if l1 == None: l1 = l2
        
        while l1 != None:
            cur += l1.val
            p.next = ListNode(cur % 10)
            cur = cur // 10
            p = p.next
            l1 = l1.next
        
        while cur > 0:
            p.next = ListNode(cur % 10)
            cur = cur // 10
            p = p.next
        
        return ans.next
            