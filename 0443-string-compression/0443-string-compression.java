class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder();
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
            int[] cLen = new int[]{-1, -1, -1, -1};
            int k = 3;
            while (cnt > 0) {
                cLen[k--] = cnt % 10;
                cnt /= 10;
            }
            for (int x = 0; x < 4; x++) {
                if (cLen[x] == -1) continue;
                chars[i++] = (char) (cLen[x] + '0');
            }
        }
        return i;
    }
}