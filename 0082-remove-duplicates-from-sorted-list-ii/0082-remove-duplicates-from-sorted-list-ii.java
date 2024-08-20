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
        ListNode temp = new ListNode(0,head);
        ListNode curr=head;
        ListNode prev=temp;

        while(curr != null){
            if(curr.next != null && curr.val==curr.next.val){
                while(curr.next != null && curr.val==curr.next.val){
                    curr=curr.next;
                }
                prev.next=curr.next; // will skip all the duplicates
            }else{
                prev=prev.next;
            }
            curr=curr.next;
        }
        return temp.next;
    }
}