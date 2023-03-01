class Solution {
    public int[] sortArray(int[] nums) {
        shuffle(nums);
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }
    
    public void quickSort(int[] nums, int lo, int hi) {
        if (lo >= hi) return;
        int pivot = nums[lo];
        int i = lo + 1, j = hi;
        while (i <= j) {
            while (i < hi && nums[i] <= pivot) i++;
            while (j > lo && nums[j] > pivot) j--;
            if (i >= j) break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        quickSort(nums, lo, j-1);
        quickSort(nums, j+1, hi);
    }
    
    public void shuffle(int[] nums) {
        Random rand = new Random();
        int n = nums.length;
        for (int i = 0 ; i < n; i++) {
            int r = i + rand.nextInt(n - i);
            swap(nums, i, r);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}