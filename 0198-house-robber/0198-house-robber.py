class Solution:
    def rob(self, nums: List[int]) -> int:
        
        if len(nums) == 1: return nums[0]
        
        value = [0, nums[0]]
        
        for i in range(1, len(nums)):
            v1 = max(value)
            v2 = nums[i] + value[0]
            value[0], value[1] = v1, v2
        
        return max(value)
            