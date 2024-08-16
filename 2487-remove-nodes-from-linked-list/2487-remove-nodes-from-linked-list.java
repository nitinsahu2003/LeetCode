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
    public ListNode removeNodes(ListNode head) {
        //reverse the list
        ListNode prev=null;
        ListNode curr=head;

        while(curr != null){
            ListNode next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        //create a new list
        ListNode newHead=new ListNode(prev.val);
        int max=newHead.val;
        curr=prev.next;

        while(curr != null){
            if(curr.val>=max){
                ListNode node=new ListNode(curr.val);
                node.next=newHead;
                newHead=node;
                max=node.val;
            }
            curr=curr.next;
        }
        return newHead;
    }
}