class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 2; i > -1; i--) {
            int cur = nums2[i];
            int ng = nums2[i+1];
            while (ng < cur && map.containsKey(ng)) {
                ng = map.get(ng);
            }
            if (ng > cur) map.put(cur, ng);
        }
        
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            if (!map.containsKey(nums1[i])) {
                ans[i] = -1;
                continue;
            }
            
            ans[i] = map.get(nums1[i]);
        }
        
        return ans;
    }
}