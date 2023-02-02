class Trie {

    private Map<Character, Map> map;
    private Set<String> words;
    
    public Trie() {
        this.map = new HashMap<>();
        this.words = new HashSet<>();
    }
    
    public void insert(String word) {
        this.words.add(word);
        Map<Character, Map> curMap = this.map;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (!curMap.containsKey(c)) {
                curMap.put(c, new HashMap<Character, Map>());
            }
            curMap = curMap.get(c);
        }
    }
    
    public boolean search(String word) {
        return this.words.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        Map<Character, Map> curMap = this.map;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (!curMap.containsKey(c)) {
                return false;
            }
            curMap = curMap.get(c);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */