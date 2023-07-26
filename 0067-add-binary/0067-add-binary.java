class Solution {
    public String addBinary(String a, String b) {
        LinkedList<Character> ans = new LinkedList<>();
        
        int i = a.length() - 1; int j = b.length() - 1;
        
        int all = 0;
        while (i > -1 && j > -1) {
            int cur_a = Character.getNumericValue(a.charAt(i));
            int cur_b = Character.getNumericValue(b.charAt(j));
            all /= 2; 
            all += cur_a;
            all += cur_b;
            ans.addFirst((char) (all % 2 + '0'));
            i--;
            j--;
        }

        while (i > -1) {
            int cur_a = Character.getNumericValue(a.charAt(i));
            all /= 2;
            all += cur_a;
            ans.addFirst((char) (all % 2 + '0'));
            i--;
        }
        
        while (j > -1) {
            int cur_b = Character.getNumericValue(b.charAt(j));
            all /= 2;
            all += cur_b;
            ans.addFirst((char) (all % 2 + '0'));
            j--;
        }
        
        while (all > 0) {
            all /= 2;
            if (all > 0) ans.addFirst((char) (all % 2 + '0'));
        }
        
        
        return ans.stream().map(String::valueOf).collect(Collectors.joining(""));
    }
}