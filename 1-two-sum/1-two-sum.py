class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        
        # O(n) solution with HashMap
        diff_dic = {}
        
        # In map, store the complement number as key, cur index as value 
        for i in range(len(nums)):
            diff_dic[target - nums[i]] = i
        
        # check whether cur element is in map key; 
        # if so, get the complement element index & return
        for i in range(len(nums)):
            # avoid: add a element with itself
            if nums[i] in diff_dic.keys() and i != diff_dic[nums[i]]:
                return [i, diff_dic[nums[i]]]
        
        return None