"""
# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random
"""

class Solution:
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if not head: return head
        
        cur = head
        clones = {head: Node(head.val)}
        
        while cur:
            cur_clone = clones[cur]
            
            if cur.next:
                if cur.next not in clones.keys():
                    clones[cur.next] = Node(cur.next.val)
                cur_clone.next = clones[cur.next]
            
            if cur.random:
                if cur.random not in clones.keys():
                    clones[cur.random] = Node(cur.random.val)
                cur_clone.random = clones[cur.random]
            
            cur = cur.next

        return clones[head]
            