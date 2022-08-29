class Solution:
    def search(self, nums: List[int], target: int) -> int:
        l, r = 0, len(nums) - 1
        
        while l < r:
            m = (l + r) // 2
            if nums[l] < nums[m] < nums[r]: break
            if nums[m] > nums[r]: 
                l = m + 1
            else:
                r = m
        
        r = len(nums) + l
        while l < r:
            m = (l + r) // 2
            if nums[m % len(nums)] < target: l = m + 1
            else: r = m
        
        if nums[l % len(nums)] == target: return l % len(nums)
        return -1