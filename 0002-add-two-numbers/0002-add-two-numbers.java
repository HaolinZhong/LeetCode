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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int rem = 0;
        ListNode p = l1, head = l1;
        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + rem;
            l1.val = sum % 10;
            p = l1;
            rem = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        if (l2 != null) {
            p.next = l2;
            l1 = l2;
        }

        while (l1 != null) {
            int sum = l1.val + rem;
            l1.val = sum % 10;
            p = l1;
            l1 = l1.next;
            rem = sum / 10;
        }

        while (rem != 0) {
            p.next = new ListNode(rem % 10);
            p = p.next;
            rem /= 10;
        }

        return head;
    }
}