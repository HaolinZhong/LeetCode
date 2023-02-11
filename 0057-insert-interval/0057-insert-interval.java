class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int curs = newInterval[0]; int cure = newInterval[1];
        boolean add = false;
        for (int[] t : intervals) {
            int s = t[0]; int e = t[1];
            if (e < curs) {
                ans.add(t);
                continue;
            }
            if (s > cure) {
                if (!add) {
                    ans.add(new int[]{curs, cure});
                    add = true;
                }
                ans.add(t);
                continue;
            }
            if (s < curs) curs = s;
            if (e > cure) cure = e;
        }
        
        if (!add) ans.add(new int[]{curs, cure});
        
        return ans.toArray(new int[ans.size()][]);
}
}