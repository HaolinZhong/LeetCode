class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int l = 1; int r = (int) Math.pow(10, 9);
        
        while (l < r) {
            int m = (l + (r - l) / 2);
            if (canEat(piles, m, h)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return l;
    }
    
    public boolean canEat(int[] piles, int k, int h) {
        int i = 0; int t = 0;
        while (i < piles.length && h > 0) {
            if (piles[i] % k == 0) {
                h -= piles[i] / k;
            } else {
                h -= piles[i] / k + 1;
            }
            if (h < 0) break;
            i ++;
        }
        return i == piles.length;
    }
}