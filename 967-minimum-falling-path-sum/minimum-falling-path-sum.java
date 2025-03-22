class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        int[][] dp = new int[n][n];
        // for (int[] row : dp) {
        //     Arrays.fill(row, -1);
        // }

        // int mini = Integer.MAX_VALUE;
        // for (int j = 0; j < n; j++) {
        //     int ans = minFallPathSum(0, j, matrix, n, dp); // Start from row 0, not n-1
        //     mini = Math.min(mini, ans);
        // }
        // return mini;
        for (int j = 0; j < n; j++) {
            dp[0][j] = matrix[0][j];
        }
        for(int i=1;i<n;i++){
            for(int j=0;j<n;j++){
                int up = dp[i-1][j];  // Coming from top
                int leftDiagonal = (j > 0) ? dp[i-1][j-1] : Integer.MAX_VALUE;
                int rightDiagonal = (j < n-1) ? dp[i-1][j+1] : Integer.MAX_VALUE;

                dp[i][j] = matrix[i][j] + Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            mini = Math.min(mini, dp[n-1][j]);
        }

        return mini;
    }

    private int minFallPathSum(int i, int j, int[][] matrix, int n, int[][] dp) {
        if (j < 0 || j >= n) return (int) Math.pow(10, 9);
        if (i == n - 1) return matrix[i][j]; // Base case: last row
        
        if (dp[i][j] != -1) return dp[i][j];

        int down = minFallPathSum(i + 1, j, matrix, n, dp);
        int leftDown = minFallPathSum(i + 1, j - 1, matrix, n, dp);
        int rightDown = minFallPathSum(i + 1, j + 1, matrix, n, dp);

        return dp[i][j] = matrix[i][j] + Math.min(down, Math.min(leftDown, rightDown));
    }
}
