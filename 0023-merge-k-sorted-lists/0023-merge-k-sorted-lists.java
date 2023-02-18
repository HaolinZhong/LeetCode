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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode();
        PriorityQueue<ListNode> pq = new PriorityQueue<>((n1, n2) -> n1.val - n2.val);
        for (ListNode n : lists) {
            if (n != null) pq.add(n);
        }
        
        ListNode p = dummy;
        while (!pq.isEmpty()) {
            ListNode cur = pq.poll();
            p.next = cur;
            p = p.next;
            if (cur.next != null) pq.add(cur.next);
        }
        
        return dummy.next;
    }
}