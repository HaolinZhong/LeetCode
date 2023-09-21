class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> s = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (s.containsKey(n)) return new int[]{i, s.get(n)};
            s.put(target - n, i);
        }
        
        return new int[]{0};
        
    }
}