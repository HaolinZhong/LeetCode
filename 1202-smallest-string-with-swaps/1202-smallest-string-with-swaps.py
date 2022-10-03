class Solution:
    
    # Union-Find算法
    # 将多个元素分配到不同group中, 每个group用统一的parent元素标识
    
    # union: 合并两个元素及其所在的group
    
    def union(self, a, b):
        self.parent[self.find(a)] = self.find(b)  #a的parent的parent设为b的parent
    
    # find: 找到元素所在组的parent
    
    def find(self, a):
        if self.parent[a] != a:    # 如果不等于自身, 则说明在一个有多个元素的组中
            self.parent[a] = self.find(self.parent[a])   # 找到当前parent的parent, 递归得到组的parent
        return self.parent[a]
    
    def smallestStringWithSwaps(self, s: str, pairs: List[List[int]]) -> str:
        
        # 1. union
        self.parent = list(range(len(s)))   # parent用1个list来存储即可
        for a, b in pairs:
            self.union(a, b)
        
        # 2. group: 存储每个group中的index和对应的char
        group = defaultdict(lambda: ([], []))
        
        for i, ch in enumerate(s):
            parent = self.find(i)
            group[parent][0].append(i)
            group[parent][1].append(ch)
        
        # 3. sort: 对每个group, sort其index与char, 并将结果一一对应的存到长度为s的空list中
        # 这样就构建了smallest string
        
        ans = ['']*len(s)
        
        for inds, chars in group.values():
            inds.sort()
            chars.sort()
            for i, ch in zip(inds, chars):
                ans[i] = ch
        
        return ''.join(ans)