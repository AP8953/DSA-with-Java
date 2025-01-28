class Solution {
    public int[] productExceptSelf(int[] nums) {
        int product = 1;
        int zeroCount = 0;
        int n = nums.length;
        int[] result = new int[n];

        // Step 1: Calculate product of all non-zero elements and count zeros
        for (int num : nums) {
            if (num == 0) zeroCount++;
            else product *= num;
        }

        // Step 2: Handle the cases based on zero count
        if (zeroCount > 1) return result; // More than one zero, all elements will be zero
        if (zeroCount == 1) {
            // If there's exactly one zero, the product of all other elements is placed in that position
            for (int i = 0; i < n; i++) {
                if (nums[i] == 0) result[i] = product;
            }
        } else {
            // If there are no zeros, divide the total product by each element
            for (int i = 0; i < n; i++) {
                result[i] = product / nums[i];
            }
        }

        return result;
    }
}