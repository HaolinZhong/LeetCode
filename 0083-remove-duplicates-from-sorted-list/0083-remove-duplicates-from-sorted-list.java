/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode s = head; ListNode f = head;
        
        while (f != null) {
            while (f != null && s.val == f.val) f = f.next;
            if (f != null) {
                s = s.next;
                s.val = f.val;
            }
        }
        
        s.next = null;
        return head;
    }
}