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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head; // No insertion if the list is empty or has only one node
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            int gcdValue = gcd(current.val, current.next.val); // Calculate GCD
            ListNode gcdNode = new ListNode(gcdValue); // Create new node for GCD
            
            // Insert the GCD node between current and current.next
            gcdNode.next = current.next;
            current.next = gcdNode;
            
            // Move current to the node after the newly inserted GCD node
            current = gcdNode.next;
        }

        return head;
    }
    public int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}