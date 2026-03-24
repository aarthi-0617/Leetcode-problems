class Solution {
    public int removeDuplicates(int[] nums) {
        // 'k' tracks the position where the next valid element should be placed
        int k = 0;
        
        for (int x : nums) {
            // A number is valid if:
            // 1. We have placed fewer than 2 elements total (always valid)
            // 2. The current number 'x' is different from the element 2 positions back
            if (k < 2 || x != nums[k - 2]) {
                nums[k] = x;
                k++;
            }
        }
        
        return k;
    }
}
