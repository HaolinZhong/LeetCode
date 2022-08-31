class Solution:
    def search(self, nums: List[int], target: int) -> bool:
        
        l, r = 0, len(nums) - 1
        
        while l < r:
            m = (l + r) // 2
            
            if nums[m] == target or nums[r] == target: return True
            
            if nums[m] > nums[r]:
                if nums[l] <= target < nums[m]: 
                    r = m
                else:
                    l = m + 1
            elif nums[l] > nums[m]:
                if nums[m] < target <= nums[r]:
                    l = m + 1
                else:
                    r = m
            else:
                r -= 1
        
        return nums[l] == target