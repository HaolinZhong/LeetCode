class Solution:
    def findMin(self, nums: List[int]) -> int:
        l, r = 0, len(nums) - 1
        
        while l < r:
            m = (l + r) // 2
            
            if nums[m] > nums[r]:
                l = m + 1
            elif nums[l] > nums[m]:
                r = m
            else:
                r -= 1
        
        return nums[l]