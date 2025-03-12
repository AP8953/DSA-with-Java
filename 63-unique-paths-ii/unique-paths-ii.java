class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n=obstacleGrid.length;
        int m=obstacleGrid[0].length;
        int dp[][] = new int[n][m];
        
        // Initialize the dp array with -1
        for (int row[] : dp)
            Arrays.fill(row, -1);
        
        // If the starting cell has an obstacle, return 0 immediately
        if (obstacleGrid[0][0] == 1) return 0;

        // Call the helper function starting from the bottom-right cell
        return mazeObstaclesUtil(n - 1, m - 1, obstacleGrid, dp);
    }

     // Helper function to calculate the number of paths through the maze
    static int mazeObstaclesUtil(int i, int j, int[][] obstacleGrid, int[][] dp) {
        // If we're out of bounds, return 0
        if (i < 0 || j < 0)
            return 0;
        
        // If there's an obstacle at this cell, return 0
        if (obstacleGrid[i][j] == 1) return 0;
        
        // If we've reached the start cell, there's one valid path
        if (i == 0 && j == 0)
            return 1;
        
        // If we've already calculated this cell, return the stored result
        if (dp[i][j] != -1)
            return dp[i][j];

        // Calculate the number of paths by moving up and left
        int up = mazeObstaclesUtil(i - 1, j, obstacleGrid, dp);
        int left = mazeObstaclesUtil(i, j - 1, obstacleGrid, dp);

        // Store the result and return it
        return dp[i][j] = up + left;
    }

}