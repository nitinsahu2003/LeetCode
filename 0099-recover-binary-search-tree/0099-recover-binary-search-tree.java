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
    private TreeNode first; // First node that's out of order (larger node)
    private TreeNode middle; // Middle node (smaller node, adjacent to first)
    private TreeNode last; // Last node that's out of order (if the swapped nodes are far apart)
    private TreeNode prev; // The previous node in the in-order traversal
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left); // Traverse the left subtree
        if(prev != null &&(root.val<prev.val)){
            // First time we find an issue
            if(first==null){
                first=prev; // Store the previous node (larger one)
                middle=root; // Store the current node (smaller one)
            }else{
                // Second time we find an issue, store the last node
                last=root; 
            }
        }
        prev=root; // Move prev pointer to current node for next comparison
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first=middle=last=null;
        prev=new TreeNode(Integer.MIN_VALUE);  // prev starts with the smallest possible value
        inorder(root); // Do the in-order traversal and find the two misplaced nodes
        // Case 1: If the swapped nodes are adjacent in the traversal (first and middle)
        if(first != null && middle != null && last==null){
            int temp=first.val;
            first.val=middle.val;
            middle.val=temp;
        // Case 2: If the swapped nodes are not adjacent (first and last)
        }else if(first != null && last != null){
            int temp=first.val;
            first.val=last.val;
            last.val=temp;
        }
    }
}