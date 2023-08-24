class Solution {
    public int longestOnes(int[] nums, int k) {
        int start = 0, end = 0;
        int max = 0;
        while (end < nums.length) {
            while (end < nums.length && k > 0) {
                if (nums[end] == 0) {
                    k--;
                }
                end++;
            }
            
            while (end < nums.length && nums[end] == 1) end++;
            
            max = Math.max(max, end - start);
            
            if (nums[start++] == 0 && start <= end) {
                k++;
            }
            
            if (end < start) end = start;
        }
        
        return max;
    }
}