class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> smap = new HashMap<>();
        Map<Character, Character> tmap = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i); char tc = t.charAt(i);
            if (!smap.containsKey(sc) && !tmap.containsKey(tc)) {
                smap.put(sc, tc);
                tmap.put(tc, sc);
                continue;
            }
            if (tmap.containsKey(tc) && tmap.get(tc) != sc) return false;
            if (smap.get(sc) != tc) return false;
        }
        
        return true;
    }
}