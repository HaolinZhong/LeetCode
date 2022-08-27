class TrieNode:
    def __init__(self):
        self.next = [None for x in range(26)]
        self.word = None
        

class Solution:
    def findWords(self, board: List[List[str]], words: List[str]) -> List[str]:
        
        def buildTrie():
            root = TrieNode()
            for w in words:
                p = root
                for c in w:
                    ind = ord(c) - ord('a')
                    if p.next[ind] == None: p.next[ind] = TrieNode()
                    p = p.next[ind]
                p.word = w
            
            return root
        
        root = buildTrie()
        ans = []
        
        def dfs(i, j, p):
            
            if i < 0 or i >= len(board) or j < 0 or j >= len(board[0]): return
            
            cur = board[i][j]
            if cur == " " or p.next[ord(cur) - ord('a')] == None: return
            
            p = p.next[ord(cur) - ord('a')]
            
            if (p.word != None): 
                ans.append(p.word)
                p.word = None
            
            board[i][j] = " "
            dfs(i-1, j, p); dfs(i+1, j, p); dfs(i, j+1, p); dfs(i, j-1, p)
            board[i][j] = cur
            
        
        for i, j in product(range(len(board)), range(len(board[0]))):
            dfs(i, j, root)
            
        return ans