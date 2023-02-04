class Solution {
    public int search(int[] nums, int target) {
        
        int l = 0; int r = nums.length-1;
        
        while (l < r) {
            int m = l + (r - l) / 2;
            if (nums[m] > nums[r]) {
                if (target <= nums[m] && target >= nums[l]) {
                    r = m;
                } else {
                    l = m + 1;
                }
            } else {
                if (target <= nums[r] && target > nums[m]) {
                    l = m + 1;
                } else {
                    r = m;
                }
            }
        }
        
        
        return nums[l] == target ? l : -1;
    }
}