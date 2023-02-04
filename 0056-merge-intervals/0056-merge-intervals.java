class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (t1, t2) -> t1[0] - t2[0]);
        int curs = intervals[0][0]; int cure = intervals[0][1];
        // System.out.println(curs);
        // System.out.println(cure);
        List<int[]> ans = new ArrayList<>();
        
        for (int[] t : intervals) {
            int s = t[0];
            int e = t[1];
            if (s <= cure) {
                curs = Math.min(s, curs);
                cure = Math.max(e, cure);
            } else {
                ans.add(new int[]{curs, cure});
                curs = s;
                cure = e;
            }
        }
        
        ans.add(new int[]{curs, cure});
        
        return ans.toArray(new int[ans.size()][]);
    }
}