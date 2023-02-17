class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> from = new HashSet<>();
        Set<String> to = new HashSet<>();
        
        for (List<String> path : paths) {
            from.add(path.get(0));
            if (to.contains(path.get(0))) to.remove(path.get(0));
            if (!from.contains(path.get(1))) to.add(path.get(1));
        }
        
        return to.iterator().next();
    }
}