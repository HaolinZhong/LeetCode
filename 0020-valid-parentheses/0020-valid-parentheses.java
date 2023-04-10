class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                st.push(c);
            } else {
                if (st.isEmpty()) return false;
                char pre = st.pop();
                boolean a = c == ')' && pre == '(';
                boolean b = c == ']' && pre == '[';
                boolean d = c == '}' && pre == '{';
                if (!(a || b || d)) return false;
            }
        }
        return st.isEmpty();
    }
}