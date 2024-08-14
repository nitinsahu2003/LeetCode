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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode currNode=new ListNode(0);;
        currNode.next=head;
        ListNode start = currNode;
        ListNode end = currNode;

        // Move first ahead by n+1 steps to maintain the gap
        for (int i = 1; i <= n + 1; i++) {
            start = start.next;
        }

        // Move first to the end, maintaining the gap
        while (start != null) {
            start = start.next;
            end = end.next;
        }

        // Skip the desired node
        end.next = end.next.next;

        return currNode.next;
    }
}