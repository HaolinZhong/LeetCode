class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i-1]) continue;
            int j = i + 1; int k = nums.length - 1;
            while (j < k) {
                int s = nums[i] + nums[j] + nums[k];
                if (s > 0) {
                    k--;
                } else if (s < 0) {
                    j++;
                } else {
                    ans.add(List.of(nums[i], nums[j++], nums[k--]));
                    while (j < k && nums[j] == nums[j-1]) j++;
                }
            }
        }
        
        return ans;
    }
}