class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        
        dfs(graph, new ArrayList<Integer>(), new boolean[graph.length], 0, ans);
        
        return ans;
    }
    
    private void dfs(int[][] graph, List<Integer> cur, 
                     boolean[] onPath, int root,
                     List<List<Integer>> ans) {
        if (onPath[root]) return;
        if (root == graph.length - 1) {
            cur.add(root);
            ans.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        
        cur.add(root);
        onPath[root] = true;
        for (int n : graph[root]) {
            dfs(graph, cur, onPath, n, ans);
        }
        cur.remove(cur.size() - 1);
        onPath[root] = false;
        return;
    }
}