public class Solution {
    public int subsetXORSum(int[] nums) {
        return dfs(nums, 0, 0); // Start from index 0 with XOR = 0
    }

    private int dfs(int[] nums, int i, int currXor) {
        if (i == nums.length) return currXor;

        // Case 1: include nums[i]
        int include = dfs(nums, i + 1, currXor ^ nums[i]);

        // Case 2: exclude nums[i]
        int exclude = dfs(nums, i + 1, currXor);

        return include + exclude;
    }
}
