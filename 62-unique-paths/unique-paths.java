class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        
        // Initialize the DP array with -1 to indicate uncomputed values
        for (int[] row : dp)
            Arrays.fill(row, -1);

        // Start the recursive calculation from the bottom-right cell (m-1, n-1)
        return countWaysUtil(m - 1, n - 1, dp);
    }
    static int countWaysUtil(int i, int j, int[][] dp) {
        // If we reach the starting cell (0, 0), there's one way to reach it.
        if (i == 0 && j == 0)
            return 1;
        
        // If we go out of bounds, there's no way to reach the cell.
        if (i < 0 || j < 0)
            return 0;

        // If the value for this cell is already computed, return it.
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of ways by moving up and moving left.
        int up = countWaysUtil(i - 1, j, dp);
        int left = countWaysUtil(i, j - 1, dp);

        // Store the result in the DP array and return it.
        return dp[i][j] = up + left;
    }
}