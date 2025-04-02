class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int totalSum=0;
        for(int num:nums) totalSum+=num;
        if(totalSum<target || (totalSum-target)%2!=0) return 0;
        target=(totalSum-target)/2;
        return perfectSum(nums, target);
    }
    private int perfectSum(int[] arr, int target){
        int n = arr.length;
        
        int[][] dp = new int[n + 1][target + 1];

        // Base case: 1 way to achieve sum 0 (empty subset)
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        // DP table filling
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // Exclude current element
                if (arr[i - 1] <= j) dp[i][j] += dp[i - 1][j - arr[i - 1]]; // Include current element
            }
        }
        return dp[n][target];
    
    }
}