class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        List<int[]> edges = new ArrayList<>();
        
        // 计算距离, 放置三元组
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                edges.add(new int[]{
                    i, j, Math.abs(xi - xj) + Math.abs(yi - yj)
                });
            }
        }
        
        // 对边排序
        Collections.sort(edges, (a, b) -> {
            return a[2] - b[2];
        });
            
        int mst = 0;
        UF uf = new UF(n);
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int weight = edge[2];
            
            if (uf.connected(u, v)) continue;
            mst += weight;
            uf.union(u, v);
        }
        return mst;
    }
}

class UF {
    private int count;
    private int[] parent;
    private int[] size;
    
    public UF(int n) {
        this.count = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }
    }
    
    public void union(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        if (rootP == rootQ) return;
        
        if (size[rootP] > size[rootQ]) {
            parent[rootQ] = rootP;
            size[rootP] += size[rootQ];
        } else {
            parent[rootP] = rootQ;
            size[rootQ] += size[rootP];
        }
        count--;
    }
    
    public boolean connected(int p, int q) {
        int rootP = find(p), rootQ = find(q);
        return rootP == rootQ;
    }
    
    private int find(int x) {
        while (parent[x] != x) {
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    
    public int count() {
        return count;
    }
    
}