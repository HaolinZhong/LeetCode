class Solution {
    public int longestPalindrome(String s) {
        int[] chcnt = new int['z' - 'A' + 1];
        for (char c : s.toCharArray()) {
            chcnt[c - 'A'] += 1;
        }

        boolean hasOdd = false;
        int sumEven = 0;
        for (int i = 0; i < chcnt.length; i++) {
            if (chcnt[i] % 2 == 0) {
                sumEven += chcnt[i];
                continue;
            }
            hasOdd = true;
            sumEven += chcnt[i] - 1;
        }

        return hasOdd ? sumEven + 1 : sumEven;


    }
}