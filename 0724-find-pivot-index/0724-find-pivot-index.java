class Solution {
    public int pivotIndex(int[] nums) {
        int[] pfSum = new int[nums.length];
        pfSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            pfSum[i] = pfSum[i-1] + nums[i];
        }
        
        int s = pfSum[nums.length-1];
        for (int i = 0; i < nums.length; i++) {
            if (pfSum[i] - nums[i] == s - pfSum[i]) return i;
        }
        
        return -1;
    }
}