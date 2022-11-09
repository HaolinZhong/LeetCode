class Solution:
    def removeDuplicates(self, nums: List[int]) -> int:
        l, r = -1, 0
        visit = defaultdict(bool)
        
        while r < len(nums):
            if not visit[nums[r]]:
                l += 1
                nums[l] = nums[r]
                visit[nums[r]] = True
            r += 1
        
        return l + 1