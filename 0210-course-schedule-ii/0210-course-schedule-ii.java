class Solution {
    
    private boolean hasCycle;
    private boolean[] onPath;
    private boolean[] visited;
    private List<Integer> seq;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] al = new ArrayList[numCourses];
        seq = new ArrayList<>();
        onPath = new boolean[numCourses];
        visited = new boolean[numCourses];
        
        for (int i = 0; i < al.length; i++) {
            al[i] = new ArrayList<>();
        }
        
        for (int[] req : prerequisites) {
            int a = req[0]; int b = req[1];
            al[a].add(b);
        }
        
        for (int i = 0; i<numCourses; i++) {
            dfs(al, i);
        }
        
        if (hasCycle) return new int[]{};
        
        return seq.stream().mapToInt(i->i).toArray();
    }
    
    private void dfs(List<Integer>[] al, int i) {
        if (onPath[i]) {
            hasCycle = true;
        }
        if (visited[i] || hasCycle) return;

        visited[i] = true;
        onPath[i] = true;
        for (int n : al[i]) {
            dfs(al, n);
        }
        seq.add(i);
        onPath[i] = false;
    }
}