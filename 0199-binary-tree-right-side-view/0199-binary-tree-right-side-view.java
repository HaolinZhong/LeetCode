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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ans.add(root.val);
        List<Integer> rans = rightSideView(root.right);
        List<Integer> lans = rightSideView(root.left);
        ans.addAll(rans);
        if (lans.size() > rans.size()) {
            for (int i = rans.size(); i < lans.size(); i++) {
                ans.add(lans.get(i));
            }
        }
        return ans;
    }
    
    
}