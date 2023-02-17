class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        Queue<Integer> pq = new PriorityQueue<>((p1, p2) -> map.get(p1) - map.get(p2));
        
        for (int key : map.keySet()) {
            pq.add(key);
            if (pq.size() > k) pq.poll();
        }
        
        return pq.stream().mapToInt(i->i).toArray();
    }
}