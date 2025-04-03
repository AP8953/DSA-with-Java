class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        if (n < 3) return 0;

        // Maintain the prefix max array (max value before j)
        int maxBefore = nums[0];

        // Maintain the suffix max array (max value after j)
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = nums[n - 1];

        // Fill suffix max from right to left
        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], nums[i]);
        }

        long maxTripletValue = 0;

        // Iterate over middle element (j), compute best (i, k) pair
        for (int j = 1; j < n - 1; j++) {
            if (maxBefore > nums[j]) { // Ensure nums[i] > nums[j]
                maxTripletValue = Math.max(maxTripletValue, (long) (maxBefore - nums[j]) * suffixMax[j + 1]);
            }
            maxBefore = Math.max(maxBefore, nums[j]); // Update maxBefore for next j
        }

        return maxTripletValue;
    }

}