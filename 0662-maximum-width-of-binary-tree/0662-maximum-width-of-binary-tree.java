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
    public int widthOfBinaryTree(TreeNode root) {
        List<Integer> starts = new ArrayList<>();
        return getMaxWidth(root, 0, 0, starts);
    }
    private int getMaxWidth(TreeNode node, int level, int index, List<Integer> starts) {
    // Base case: if the node is null, return 0
    if (node == null) {
      return 0;
    }

    // If we're at a new level, record the starting index
    if (level == starts.size()) {
      starts.add(index);
    }

    // Current width is the difference between current index and starting index at this level
    int curWidth = index - starts.get(level) + 1;

    // Recur for left and right children with their respective indices
    int leftWidth = getMaxWidth(node.left, level + 1, 2 * index + 1, starts);
    int rightWidth = getMaxWidth(node.right, level + 1, 2 * index + 2, starts);

    // Return the maximum width found at this level or below
    return Math.max(curWidth, Math.max(leftWidth, rightWidth));
  }
}