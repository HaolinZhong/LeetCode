class Solution {
    public String removeStars(String s) {
        List<Character> ss = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                ss.add(c);
                continue;
            }
            ss.remove(ss.size() - 1);
        }
        return ss.stream().map(c -> c.toString()).collect(Collectors.joining(""));
    }
}