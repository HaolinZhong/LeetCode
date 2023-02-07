class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) return ans;
        
        int[] ref = new int[26];
        for (int i = 0; i < p.length(); i++) {
            ref[p.charAt(i) - 'a'] += 1;
        }
        
        int[] cur = new int[26];
        
        int i = 0;
        int j = 0;
        
        while (j < p.length()) {
            cur[s.charAt(j) - 'a'] += 1;
            j++;
        }
        
        while (j < s.length()) {
            if (Arrays.equals(ref, cur)) ans.add(i);
            cur[s.charAt(i)-'a'] -= 1;
            cur[s.charAt(j)-'a'] += 1;
            i++;
            j++;
        }
        
        if (Arrays.equals(ref, cur)) ans.add(i);
        
        return ans;
    }
}