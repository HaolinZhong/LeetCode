class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> s = new HashSet<>(nums.length);
        for (int n : nums) {
            if (s.contains(n)) {
                return true;
            }
            s.add(n);
        }
        return false;
    }
}