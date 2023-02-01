class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Boolean> m = new HashMap<>();
        int l = 0; int r = 0;
        int maxLen = 0;
        
        while (r < s.length()) {
            while (l <= r && m.containsKey(s.charAt(r))) {
                m.remove(s.charAt(l));
                l++;
            }
            
            m.put(s.charAt(r), true);
            maxLen = Math.max(maxLen, r-l+1);
            r++;
        }
        
        return maxLen;
    }
}