class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            ans[i] = nums[i-1] * ans[i-1];
        }
        
        int rp = 1;
        for (int i = nums.length-1; i > -1; i--) {
            ans[i] *= rp;
            rp *= nums[i];
        }
        
        return ans;
    }
}