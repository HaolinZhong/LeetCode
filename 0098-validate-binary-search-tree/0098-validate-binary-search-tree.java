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
    public boolean isValidBST(TreeNode root) {
        return isValid(root, null, null);
    }
    
    private boolean isValid(TreeNode root, Integer upp, Integer low) {
        if (root == null) return true;
        if ((upp!=null && root.val >= upp) || (low!=null && root.val <= low)) return false;
        boolean l = isValid(root.left, root.val, low);
        boolean r = isValid(root.right, upp, root.val);
        return l && r;
    }
}