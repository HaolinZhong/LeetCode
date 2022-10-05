class Solution:
    def ways(self, pizza: List[str], k: int) -> int:
        m, n, MOD = len(pizza), len(pizza[0]), 10 ** 9 + 7
        presum = [[0] * (n + 1) for _ in range(m+1)]
        for i in range(m-1, -1, -1):
            for j in range(n-1, -1, -1):
                presum[i][j] = presum[i+1][j] + presum[i][j+1] - presum[i+1][j+1] + (pizza[i][j] == 'A')
        
        @lru_cache(None)
        def dp(i, j, k):
            if presum[i][j] == 0: return 0
            if k == 0: return 1
            ans = 0
            for nr in range(i+1, m):
                if presum[i][j] > presum[nr][j]:
                    ans = (ans + dp(nr, j, k-1)) % MOD
            for nc in range(j+1, n):
                if presum[i][j] > presum[i][nc]:
                    ans = (ans + dp(i, nc, k-1)) % MOD
            
            return ans
        
        return dp(0, 0, k-1)