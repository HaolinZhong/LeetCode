class Solution {
    public String gcdOfStrings(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        for (int k = len; k > 0; k--) {
            if (valid(str1, str2, k)) return str1.substring(0, k);
        }
        return "";
    }
    
    private boolean valid(String s1, String s2, int i) {
        if (s1.length() % i == 0 && s2.length() % i == 0) {
            String base = s1.substring(0, i);
            return s1.replaceAll(base, "").isEmpty() && s2.replaceAll(base, "").isEmpty();
        }
        
        return false;
    }
}