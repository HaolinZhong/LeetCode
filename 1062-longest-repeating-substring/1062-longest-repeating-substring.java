class Solution {
    public int longestRepeatingSubstring(String s) {
        Set<String> sset = new HashSet<>();
        int ans = 0;
        for (int l = s.length() - 2; l > -1; l--) {
            for (int i = 0; i < s.length() - l; i++) {
                String cur = s.substring(i, i+l+1);
                if (sset.contains(cur)) {
                    return cur.length();
                }
                sset.add(cur);
            }
            sset.clear();
        }
        return ans;
    }
}