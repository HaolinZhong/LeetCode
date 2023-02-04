class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        
        Map<Integer, Integer> fnMap = new HashMap<>();
        
        for (int n : coins) {
            fnMap.put(n, 1);   
        }
        
        int curMin;
        for (int i = 1; i < amount+1; i++) {
            if (fnMap.containsKey(i)) continue;
            
            curMin = Integer.MAX_VALUE;
            
            for (int n : coins) {
                if (fnMap.containsKey(i-n)) {
                    curMin = Math.min(fnMap.get(i-n) + 1, curMin);
                }
            }

            
            
            if (curMin != Integer.MAX_VALUE) {
                fnMap.put(i, curMin);
            }
        }
        
        if (!fnMap.containsKey(amount)) return -1;
        
        return fnMap.get(amount);
    }
}