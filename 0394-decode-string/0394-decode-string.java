class Solution {
    
    private int i;
    
    public String decodeString(String s) {
        return decodePart(s);
    }
    
    private String decodePart(String s) {
        StringBuilder sb = new StringBuilder();
        while (i < s.length() && s.charAt(i) != ']') {
            char c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else if (Character.isDigit(c)) {
                int rp = 0;
                while (i < s.length() && s.charAt(i) != '[') {
                    rp = rp * 10 + s.charAt(i) - '0';
                    i++;
                }
                i+= 1;
                String curs = decodePart(s);
                sb.append(curs.repeat(rp));
            }
            
            i++;
        }
        
        return sb.toString();
    }
}