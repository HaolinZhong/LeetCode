class TimeMap:

    def __init__(self):
        self.D = {}

    def set(self, key: str, value: str, timestamp: int) -> None:
        if key not in self.D.keys(): self.D[key] = []
        self.D[key].append([timestamp, value])

    def get(self, key: str, timestamp: int) -> str:
        
        if key not in self.D.keys(): return ""
        
        L = self.D[key]
        
        l, r = 0, len(L)
        while l < r:
            m = (l + r) // 2
            if L[m][0] <= timestamp: l = m + 1
            else: r = m
        
        if l == 0: return ""
        
        return L[l-1][1]


# Your TimeMap object will be instantiated and called as such:
# obj = TimeMap()
# obj.set(key,value,timestamp)
# param_2 = obj.get(key,timestamp)