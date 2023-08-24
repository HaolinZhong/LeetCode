class Solution {
    public int longestSubarray(int[] nums) {
        int start = 0, end = 0;
        int delete = 1;
        int max = 0;
        while (end < nums.length) {
            while (end < nums.length && delete >= 0) {
                if (nums[end++] == 0) {
                    delete--;
                }
            }
            
            if (start < end && delete < 0 && nums[start++] == 0) {
                delete++;
            }
            
            max = Math.max(max, end - start - 1);
        }
        
        return max;
    }
}