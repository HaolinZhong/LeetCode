class Solution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) return 0;
        int s = 0; int f = 0;
        while (f < nums.length) {
            while (f < nums.length && nums[f] == val) {
                f++;
            }
            if (f < nums.length) {
                nums[s] = nums[f];
                s++;
                f++;
            }
        }
        
        return s;
    }
}