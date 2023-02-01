/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Integer, Node> map = new HashMap<>();
        Set<Integer> cloned = new HashSet<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node n = q.poll();
                
                if (cloned.contains(n.val)) continue;
                
                Node cloneN;
                if (map.containsKey(n.val)) {
                    cloneN = map.get(n.val);
                } else {
                    cloneN = new Node(n.val);
                    map.put(n.val, cloneN);
                }
                for (Node nn : n.neighbors) {
                    if (!map.containsKey(nn.val)) {
                        map.put(nn.val, new Node(nn.val));
                    } 
                    cloneN.neighbors.add(map.get(nn.val));
                    if (!cloned.contains(nn.val)) {
                        q.add(nn);
                    }
                }
                cloned.add(n.val);
            }
        }
        
        return map.get(node.val);
    }
}