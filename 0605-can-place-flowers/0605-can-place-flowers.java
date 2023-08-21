class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        if (n == 0) return true;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 1) continue;
            if (i > 0 && flowerbed[i-1] == 1) continue;
            if (i < flowerbed.length - 1 && flowerbed[i+1] == 1) continue;
            flowerbed[i] = 1;
            if (0 == --n) return true;
        }
        
        return n == 0;
    }
}