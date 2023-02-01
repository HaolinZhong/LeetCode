class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] g = new ArrayList[numCourses];
        Map<Integer, Integer> deg = new HashMap<>();
        
        for (int i = 0; i < numCourses; i++) {
            g[i] = new ArrayList<>();
            deg.put(i, 0);
        }
        
        for (int[] rel : prerequisites) {
            int b = rel[1]; int a = rel[0];
            g[b].add(a);
            deg.put(a, deg.get(a) + 1);
        }
        
        
        Queue<Integer> q = new LinkedList<>();
        int inQueue = 0;
        for (int node : deg.keySet()) {
            if (deg.get(node) == 0) {
                q.offer(node);
                inQueue += 1;
            }
        }
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int curNode = q.poll();
                List<Integer> subs = g[curNode];
                for (int j = 0; j < subs.size(); j++) {
                    int subNode = subs.get(j);
                    deg.put(subNode, deg.get(subNode) - 1);
                    if (deg.get(subNode) == 0) {
                        q.offer(subNode);
                        inQueue += 1;
                    }
                }
            }
        }
        
        return inQueue == numCourses;
        
    }
    
}