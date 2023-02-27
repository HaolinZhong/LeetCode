/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    
    private int[][] gd;
    
    public Node construct(int[][] grid) {
        gd = grid;
        return dfs(0, 0, grid.length);
    }
    
    private Node dfs(int i0, int j0, int n) {
        if (n == 1) return new Node(gd[i0][j0] == 1, true);
        Node tl = dfs(i0, j0, n/2);
        Node tr = dfs(i0, j0 + n/2, n/2);
        Node bl = dfs(i0 + n/2, j0, n/2);
        Node br = dfs(i0 + n/2, j0 + n/2, n/2);
        if (tl.val == tr.val && tr.val == bl.val && bl.val == br.val && 
           tl.isLeaf && tr.isLeaf && bl.isLeaf && br.isLeaf) {
            return new Node(tl.val, true);
        }
        
        return new Node(true, false, tl, tr, bl, br);
    }
    
    // private boolean checkSame(int i0, int j0, int n) {
    //     int init = gd[i0][j0];
    //     for (int i = i0; i < i0 + n; i++) {
    //         for (int j = j0; j < j0 + n; j++) {
    //             if 
    //         }
    //     }
    // }
    
}