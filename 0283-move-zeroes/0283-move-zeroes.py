class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        l, r = -1, 0
        while r < len(nums):
            if nums[r] != 0:
                l += 1
                nums[l] = nums[r]
            r += 1
        
        for i in range(l+1, len(nums)):
            nums[i] = 0
        
        return nums