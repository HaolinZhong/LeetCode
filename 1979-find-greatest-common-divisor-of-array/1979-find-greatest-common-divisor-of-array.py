class Solution:
    def findGCD(self, nums: List[int]) -> int:
        s, l = 1000, 0
        for n in nums:
            s = min(s, n)
            l = max(l, n)
        return math.gcd(s, l)