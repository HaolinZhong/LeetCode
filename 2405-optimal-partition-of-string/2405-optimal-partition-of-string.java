class Solution {
    public int partitionString(String s) {
        char[] cnt = new char[26];
        int num = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cnt[c - 'a'] == 0) {
                cnt[c - 'a'] = 1;
                continue;
            }    
            
            num++;
            resetCnt(cnt);
            cnt[c - 'a'] = 1;
        }
        return num;
    }
    
    private void resetCnt(char[] cnt) {
        for (int i = 0; i < 26; i++) cnt[i] = 0;
    }
}