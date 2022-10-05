class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        dp = [-1] * (amount+1)
        dp[0] = 0
        
        coins.sort()
        
        for i in range(1, amount+1):
            cur_min = sys.maxsize
            for n in coins:
                if i < n: break
                if dp[i-n] == -1: continue
                cur_min = min(cur_min, dp[i-n] + 1)
            if cur_min == sys.maxsize:
                dp[i] = -1
            else:
                dp[i] = cur_min

        return dp[-1]
        