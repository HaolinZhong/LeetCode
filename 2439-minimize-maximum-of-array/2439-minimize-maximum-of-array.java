class Solution {
    public int minimizeArrayValue(int[] nums) {
        int max = nums[0], cnt = 1;
        long emp = 0;
        for (int i = 1; i < nums.length; i++) {
            cnt += 1;
            if (nums[i] <= max) {
                emp += max - nums[i];
                continue;
            }
            
            if (emp + max >= nums[i]) {
                emp -= nums[i] - max;
                continue;
            }
            
            long diff = nums[i] - max - emp;
            
            long add = diff / cnt;
            if (diff % cnt != 0) {
                add += 1;
            }
            emp = add * cnt - diff;
            max += add;
        }
        
        return max;
    }
}