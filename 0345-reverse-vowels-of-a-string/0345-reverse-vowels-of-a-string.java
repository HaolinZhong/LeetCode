class Solution {
    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] sca = s.toCharArray();
        while (i < j) {
            while (i < j && !isVowel(sca[i])) i++;
            while (i < j && !isVowel(sca[j])) j--;
            System.out.println(i);
            System.out.println(j);
            if (i != j) {
                char ichar = sca[i];
                sca[i] = sca[j];
                sca[j] = ichar;
                i++;
                j--;
            }
        }
        
        return String.valueOf(sca);
    }
    
    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'; 
    }
}