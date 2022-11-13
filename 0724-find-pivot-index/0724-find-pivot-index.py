class Solution:
    def pivotIndex(self, nums: List[int]) -> int:
        for i in range(1, len(nums)):
            nums[i] += nums[i-1]
        
        for i in range(len(nums)):
            l = 0 if i == 0 else nums[i-1]
            r = nums[-1] - nums[i]
            if l == r: 
                return i
        
        return -1