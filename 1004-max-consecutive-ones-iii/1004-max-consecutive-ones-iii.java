class Solution {
    public int longestOnes(int[] nums, int k) {
        
        int start = 0, end = 0;
        int max = 0;
        while (end < nums.length) {
            while (end < nums.length && k >= 0) {
                if (nums[end] == 0) {
                    k--;
                }
                end++;
            }
            
            if (start < end && k < 0 && nums[start++] == 0) {
                k++;
            }
            
            max = Math.max(max, end - start);
        }
        
        return max;
    }
}