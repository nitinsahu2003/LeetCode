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
    public ListNode deleteMiddle(ListNode head) {
        if(head==null || head.next==null){
            return null;
        }
        ListNode hare=head;
        ListNode turtle=head;
        hare=head.next.next;
        while(hare!=null && hare.next!=null){
            hare=hare.next.next;
            turtle=turtle.next;
        }
        if(turtle.next!=null){
            turtle.next=turtle.next.next;
        }
        return head;
    }
}