class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int nc : candies) {
            maxCandies = Math.max(maxCandies, nc);
        }
        
        List<Boolean> result = new ArrayList<>();
        
        for (int nc : candies) {
            if (nc + extraCandies >= maxCandies) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}