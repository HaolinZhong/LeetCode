class Solution {
    public String simplifyPath(String path) {
        String[] addr = path.split("/");
        Deque<String> s = new LinkedList<>();
        for (String a : addr) {
            if (a.equals(".") || a.length() == 0) continue;
            if (a.equals("..")) {
                if (s.size() > 0) {
                    s.removeLast();
                }
                continue;
            }
            s.add(a);
        }
        return "/" + s.stream().collect(Collectors.joining("/"));
    }
}