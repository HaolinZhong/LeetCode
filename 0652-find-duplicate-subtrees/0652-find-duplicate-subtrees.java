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
    
    public Map<String, Integer> map;
    public List<TreeNode> ans;
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        map = new HashMap<>();
        ans = new ArrayList<>();
        serializeNode(root);
        return ans;
    }
    
    public String serializeNode(TreeNode root) {
        if (root == null) return "#";
        StringBuilder sb = new StringBuilder();
        sb.append(root.val);
        String ls = serializeNode(root.left);
        String rs = serializeNode(root.right);
        
        // helper(root.left, ls);
        // helper(root.right, rs);
        sb.append(",");
        sb.append(ls);
        sb.append(",");
        sb.append(rs);
        String res = sb.toString();
        helper(root, res);
        // System.out.println(res);
        return res;
    }
    
    public void helper(TreeNode node, String s) {
        if (!s.equals("#") && map.containsKey(s) && map.get(s) == 0) {
            ans.add(node);
            map.put(s, 1);
        } 
        
        if (!map.containsKey(s)) map.put(s, 0);
    }
    
}