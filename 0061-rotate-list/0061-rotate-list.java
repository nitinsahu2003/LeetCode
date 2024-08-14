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
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null || k==0){
            return head;
        }
        ListNode currNode=head;
        int count=1;

        while(currNode.next != null){
            count++;
            currNode=currNode.next;
        } 
        currNode.next=head;
        
        int t=count-k%count;

        for(int i=0;i<t;i++){
            currNode=currNode.next;
        }

        ListNode newHead=currNode.next;
        currNode.next=null;

        return newHead;
    }
    
}