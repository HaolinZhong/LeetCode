class Solution {
    public int[][] kClosest(int[][] points, int k) {
        Queue<int[]> q = new PriorityQueue<>(new Comparator<int[]> (){
            public int compare(int[] p1, int[] p2) {
                int d1 = calcDis(p1);
                int d2 = calcDis(p2);
                if (d1 == d2) return 0;
                return d1 > d2? -1 : 1;
            }
            
            private int calcDis(int[] p) {
                return p[0]*p[0] + p[1]*p[1];
            }
        });
            
        for (int[] p : points) {
            q.add(p);
            if (q.size() > k) {
                q.poll();
            }
        }
        
        return q.toArray(new int[k][2]);
    }
}
