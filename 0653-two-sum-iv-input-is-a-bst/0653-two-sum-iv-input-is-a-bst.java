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
    ArrayList<Integer> ans=new ArrayList<>();
    public boolean findTarget(TreeNode root, int k) {
        inorder(root);
        int first=0,last=ans.size()-1; 
        while(first<last){
            if(ans.get(first)+ans.get(last)==k) return true;
            else if(ans.get(first)+ans.get(last)>k) last--;
            else first++;
        }
        return false;
    }
    private void inorder(TreeNode root){
        if(root==null) return;
        inorder(root.left);
        ans.add(root.val);
        inorder(root.right);
    }
}