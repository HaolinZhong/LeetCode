class Solution:
    def findAnagrams(self, s: str, p: str) -> List[int]:
        cnt = defaultdict(int)
        window = defaultdict(int)
        for c in p: cnt[c] += 1
        
        ans = []
        l, r = 0, 0
        valid = 0
        
        # 我们维持长度为len(p)的滑动窗口, 并记录窗口内的字符情况以便判断是否满足要求
        # 我们的区间是左闭右开的[l, r), 元素数量为r - l
        while r < len(s):
            c = s[r]
            r += 1
            
            # 仅在当前元素是目标字符之一时才处理记录
            if c in cnt.keys():
                window[c] += 1
                if window[c] == cnt[c]:
                    valid += 1
        
            # 当窗口大小达到len(p)后, 移除最左侧元素
            while r - l >= len(p):
                if valid == len(cnt): ans.append(l)
                d = s[l]
                l += 1
                
                # 仅在当前移除元素是目标元素之一时才需要处理记录
                if d in cnt.keys():
                    if cnt[d] == window[d]:
                        valid -= 1
                    window[d] -= 1
                
        
        return ans