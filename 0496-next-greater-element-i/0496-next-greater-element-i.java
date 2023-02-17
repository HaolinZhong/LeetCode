class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!s.isEmpty() && s.peek() < nums2[i]) {
                map.put(s.pop(), nums2[i]);
            }
            s.push(nums2[i]);
        }
        
        int[] ans = new int[nums1.length];
        
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.containsKey(nums1[i]) ? map.get(nums1[i]) : -1;
        }
        
        return ans;
    }
}