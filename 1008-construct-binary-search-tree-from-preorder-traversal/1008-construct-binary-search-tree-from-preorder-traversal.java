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
    private int idx=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return buildBST(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private TreeNode buildBST(int[] preorder, int lB, int uB){
        if(idx>=preorder.length || preorder[idx]>uB || preorder[idx]<lB) return null;
        int val=preorder[idx];
        idx++;
        TreeNode root=new TreeNode(val);
        root.left=buildBST(preorder,lB,val);
        root.right=buildBST(preorder,val,uB);
        return root;
    }
}