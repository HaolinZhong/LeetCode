class Solution {
    public int evalRPN(String[] tokens) {
        int prev;
        int next;
        String token;
        Stack<Integer> s = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            token = tokens[i];
            if (isOpr(token)) {
                next = s.pop();
                prev = s.pop();
                if (token.equals("+")) {
                    s.push(next + prev);
                } else if (token.equals("-")) {
                    s.push(prev - next);
                } else if (token.equals("*")) {
                    s.push(prev * next);
                } else if (token.equals("/")) {
                    s.push(prev / next);
                }
            } else {
                s.push(Integer.parseInt(token));
            }
        }
        return s.pop();
    }
    
    private boolean isOpr(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
}