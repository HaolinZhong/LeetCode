class Solution:
    def lengthOfLongestSubstring(self, s: str) -> int:
        
        if len(s) == 0: return 0
        
        d = {}
        max_len = 1
        l, r = 0, 0
        
        while r < len(s):
            # 移动右指针的条件: 当前右指针字符未出现过, 或出现位置已在左指针之前
            while r < len(s) and (s[r] not in d.keys() or d[s[r]] < l):
                d[s[r]] = r
                r += 1
            
            # 当右指针无法再移动时, 要么达到了最右侧, 要么出现了重复
            
            max_len = max(max_len, r - l)
            if r == len(s): break
                
            # 出现重复时, 左指针直接跳到最后一次出现的位置之后一位, 使其不再重复
            l = d[s[r]] + 1
            
            # 此时元素最新出现的位置即为右指针位置
            d[s[r]] = r
            r += 1
        
        return max_len