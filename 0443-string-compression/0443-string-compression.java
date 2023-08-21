class Solution {
    public int compress(char[] chars) {
        char prev = '#';
        int cnt = 0;
        int i = 0; int j = 0;
        while (j < chars.length) {
            char c = chars[j];
            cnt = 0;
            while (j < chars.length && chars[j] == c) {
                cnt++;
                j++;
            }
            chars[i++] = c;
            if (cnt == 1) continue;
            for (char a : Integer.toString(cnt).toCharArray()) {
                chars[i++] = a;
            }
        }
        return i;
    }
}