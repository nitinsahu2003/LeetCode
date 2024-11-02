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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head==null) return null;
        ListNode mid=findMiddle(head);
        TreeNode root=new TreeNode(mid.val);
        if(head==mid) return root;
        root.left=sortedListToBST(head);
        root.right=sortedListToBST(mid.next);
        return root;
    }
    private ListNode findMiddle(ListNode head){
        ListNode prev=null;
        ListNode turtle=head;
        ListNode hare=head;
        while(hare!=null && hare.next!=null){
            prev=turtle;
            turtle=turtle.next;
            hare=hare.next.next;
        }
        if(prev!=null) prev.next=null;
        return turtle;
    }
}