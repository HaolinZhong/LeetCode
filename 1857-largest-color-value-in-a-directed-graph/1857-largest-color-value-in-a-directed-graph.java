class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        Map<Integer, List<Integer>> adj = new HashMap<>();
        int[] indegree = new int[n];
        
        // outgoing neighbor
        for (int[] edge: edges) {
            adj.computeIfAbsent(edge[0], a -> new ArrayList<Integer>()).add(edge[1]);
            indegree[edge[1]]++;
        }
        
        // 每个node记录26个值, 代表来到这个node的所有路径上, 各个颜色的最大color value
        int[][] count = new int[n][26];
        Queue<Integer> q = new LinkedList<>();
        
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) q.offer(i);
        }
        
        int ans = 1, nodeSeen = 0;
        while (!q.isEmpty()) {
            int node = q.poll();
            ans = Math.max(ans, ++count[node][colors.charAt(node) - 'a']);
            nodeSeen++;
            
            // 孤立点无需update (不在edge中出现, 也就不在adj中出现)
            if (!adj.containsKey(node)) continue;
            
            // update outgoing neighbors' freq
            for (int neighbor : adj.get(node)) {
                // node已经算上了自身颜色, 这里把值传给outgoing neighbor
                for (int i = 0; i < 26; i++) {
                    count[neighbor][i] = Math.max(count[neighbor][i], count[node][i]);
                }
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }
        
        return nodeSeen < n ? -1 : ans;
    }
}