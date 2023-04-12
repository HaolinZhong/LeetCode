class Solution {
    public String simplifyPath(String path) {
        String[] addr = path.split("/");
        Deque<String> s = new LinkedList<>();
        s.add("");
        for (String a : addr) {
            if (a.equals(".") || a.length() == 0) continue;
            if (a.equals("..")) {
                if (s.size() > 1) {
                    s.removeLast();
                }
                continue;
            }
            s.add(a);
        }
        if (s.size() == 1) s.add("");
        return s.stream().collect(Collectors.joining("/"));
    }
}