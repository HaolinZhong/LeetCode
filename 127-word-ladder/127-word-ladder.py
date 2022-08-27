class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        
        dow = {w : True for w in wordList}
        
        if endWord not in dow.keys(): return 0
        
        cur = [beginWord]
        ab = "abcdefghijklmnopqrstuvwxyz"
        cnt = 1
        
        
        while len(cur) > 0:
            for i in range(len(cur)):
                w = cur.pop(0)
                if w == endWord: return cnt
                wl = list(w)
                for j in range(len(wl)):
                    curChar = wl[j]
                    for alt in ab:
                        wl[j] = alt
                        newWord = "".join(wl)
                        if newWord in dow.keys():
                            del dow[newWord]
                            cur.append(newWord)
                    wl[j] = curChar
            cnt += 1
        
        return 0