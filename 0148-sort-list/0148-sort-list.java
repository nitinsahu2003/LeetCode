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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        
        ListNode hare=head;
        ListNode turtle=head;
        ListNode temp=null;
        while(hare!=null && hare.next!=null){
            temp=turtle;
            turtle=turtle.next;
            hare=hare.next.next;
        }
        temp.next=null;
        //divide the list into two parts

        ListNode leftSide=sortList(head);
        ListNode rightSide=sortList(turtle);

        return mergeList(leftSide,rightSide);


    }
    private ListNode mergeList(ListNode l1, ListNode l2){
        ListNode newNode=new ListNode(0);
        ListNode temp=newNode;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                temp.next=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1!=null){
            temp.next=l1;
            l1=l1.next;
        }
        if(l2!=null){
            temp.next=l2;
            l2=l2.next;
        }
        return newNode.next;
    }
}