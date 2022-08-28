class Solution:
    def searchRange(self, nums: List[int], target: int) -> List[int]:
        
        
        l, r = 0, len(nums)
        
        while l < r:
            m = (l + r) // 2
            if nums[m] < target:
                l = m + 1
            else:
                r = m
        
        f = l if l < len(nums) and nums[l] == target else -1
        
        l, r = 0, len(nums)
        
        while l < r:
            m = (l + r) // 2
            if nums[m] <= target:
                l = m + 1
            else:
                r = m
        
        e = l - 1 if l > 0 and nums[l-1] == target else -1
        
        return [f, e]
         