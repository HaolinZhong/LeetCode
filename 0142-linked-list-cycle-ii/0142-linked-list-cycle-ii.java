/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // slow: a + b
        // fast: a + c + b
        // a + c + b = 2a + 2b
        // c - b = a
        if (head == null) return head;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && slow != fast) {
            slow = slow.next;
            fast = fast.next == null ? null : fast.next.next;
        }
        
        if (fast == null) return null;
        
        ListNode p = head;
        slow = slow.next;
        while (p != slow) {
            p = p.next;
            slow = slow.next;
        }
        
        return p;
    }
}