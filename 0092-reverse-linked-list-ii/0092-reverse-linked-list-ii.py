# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    
    
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        self.successor = None
        
        def reverseN(head, n):
            if n == 1:
                self.successor = head.next
                return head
            
            last = reverseN(head.next, n-1)
            
            head.next.next = head
            head.next = self.successor
            
            return last
        
        if left == 1: return reverseN(head, right - left + 1)
        
        head.next = self.reverseBetween(head.next, left - 1, right - 1)
        
        return head