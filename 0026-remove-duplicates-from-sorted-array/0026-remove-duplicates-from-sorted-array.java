class Solution {
    public int removeDuplicates(int[] nums) {
        int s = 0; int f = 0;
        while (f < nums.length) {
            while (f < nums.length && nums[s] == nums[f]) f++;
            if (f < nums.length) {
                s++;
                nums[s] = nums[f];
            }
        }
        
        return s + 1;
    }
}