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
        if(head==null||head.next==null){
            return null;
        }
         int len=1,i=2;
         ListNode start=head;
         ListNode end=head;
        while(end.next != null){
            len++;
            end=end.next;
        }
        int middle=len/2+1;
        while(i<middle){
            start=start.next;
            i++;
        }
        start.next=start.next.next;
        return head;
    }
}