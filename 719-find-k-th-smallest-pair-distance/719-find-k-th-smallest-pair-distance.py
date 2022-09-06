class Solution(object):
    def smallestDistancePair(self, nums, k):
        """
        :type nums: List[int]
        :type k: int
        :rtype: int
        """
        nums.sort()
        
        def getSmallerPairN(x):
            j = 0
            cnt = 0
            for i in range(len(nums)):
                while j < len(nums) and nums[j] - nums[i] <= x: j += 1
                cnt += j - i - 1
            return cnt
        
        l, r = 0, nums[-1] - nums[0]
        
        while l < r:
            m = (l + r) // 2
            if getSmallerPairN(m) < k:
                l = m + 1
            else:
                r = m
        
        return l