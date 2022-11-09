# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        visit = defaultdict(bool)
        l, r = ListNode(), head
        l.next = head
        while r != None:
            if not visit[r.val]:
                l = l.next
                l.val = r.val
                visit[r.val] = True
            r = r.next
        
        l.next = None
        
        return head