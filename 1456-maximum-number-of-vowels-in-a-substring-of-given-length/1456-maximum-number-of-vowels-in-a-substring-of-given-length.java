class Solution {
    public int maxVowels(String s, int k) {
        int cnt = 0;
        
        for (int i = 0; i < k; i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                cnt++;
            }
        }
        
        int max = cnt;
        
        for (int i = 1; i + k - 1 < s.length(); i++) {
            char prevStart = s.charAt(i - 1);
            char newEnd = s.charAt(i + k - 1);
            if (isVowel(prevStart)) cnt--;
            if (isVowel(newEnd)) cnt++;
            max = Math.max(max, cnt);
        }
        
        return max;
    }
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}