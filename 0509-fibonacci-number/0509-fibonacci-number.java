class Solution {
    public int fib(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        int[] mem = new int[]{0, 1};
        for (int i = 1; i < n; i++) {
            int cur = mem[0] + mem[1];
            mem[0] = mem[1];
            mem[1] = cur;
        }
        
        return mem[1];
    }
}