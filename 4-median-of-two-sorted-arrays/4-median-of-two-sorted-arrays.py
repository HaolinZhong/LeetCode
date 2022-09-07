class Solution(object):
    def findMedianSortedArrays(self, nums1, nums2):
        """
        :type nums1: List[int]
        :type nums2: List[int]
        :rtype: float
        """
        
        if (len(nums1) > len(nums2)):
            _ = nums1
            nums1 = nums2
            nums2 = _
        
        
        n1, n2 = len(nums1), len(nums2)
        
        k = (n1 + n2 + 1) // 2
        
        l, r = 0, n1
        while l < r:
            m = (l + r) // 2
            if nums1[m] < nums2[k - m - 1]:
                l = m + 1
            else:
                r = m
        
        m1 = l
        m2 = k - l
        
        vk1 = max(float("-inf") if m1 == 0 else nums1[m1 - 1],
                 float("-inf") if m2 == 0 else nums2[m2 - 1])
        
        if (n1 + n2) % 2 == 1: return vk1
        
        vk2 = min(float("inf") if m1 == n1 else nums1[m1],
                 float("inf") if m2 == n2 else nums2[m2])
        
        return (vk1 + vk2) * 0.5
        
        
        