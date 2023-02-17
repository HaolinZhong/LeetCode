class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        Queue<int[]> pq = new PriorityQueue<>((p1, p2) -> p1[1] - p2[1]);
        
        for (int key : map.keySet()) {
            pq.add(new int[]{key, map.get(key)});
            if (pq.size() > k) pq.poll();
        }
        
        return pq.stream().mapToInt(p -> p[0]).toArray();
    }
}