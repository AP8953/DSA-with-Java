class Solution {

    public int minPathSum(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int dp[][] =new int[m][n];
        // for(int[] row:dp){
        //     Arrays.fill(row,-1);

        // }
        // return countSum(m-1,n-1,dp, grid);
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0 && j==0) dp[i][j]= grid[i][j];
                else if(i<0 || j<0) dp[i][j]=Integer.MAX_VALUE;
                else {
                    int up = (i > 0) ? countSum(i - 1, j, dp, grid) : Integer.MAX_VALUE;
                    int left = (j > 0) ? countSum(i, j - 1, dp, grid) : Integer.MAX_VALUE;

                    dp[i][j] = grid[i][j] + Math.min(up, left);
                }
            }
        }
        return dp[m-1][n-1];
    }
    private int countSum(int i, int j, int[][] dp, int[][] grid){
        if(i==0 && j==0) return grid[i][j];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j]; // Memoization check

        int up = (i > 0) ? countSum(i - 1, j, dp, grid) : Integer.MAX_VALUE;
        int left = (j > 0) ? countSum(i, j - 1, dp, grid) : Integer.MAX_VALUE;

        return dp[i][j] = grid[i][j] + Math.min(up, left);
    }
}