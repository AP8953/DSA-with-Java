class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
    int m = obstacleGrid.length, n = obstacleGrid[0].length;
    int[] prev = new int[n]; // Optimized DP array to store previous row results
    
    for (int i = 0; i < m; i++) {
        int[] curr = new int[n]; // Current row DP array
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[i][j] == 1) {
                curr[j] = 0; // No path possible if there's an obstacle
            } else if (i == 0 && j == 0) {
                curr[j] = 1; // Start point has only one way
            } else {
                int up = (i > 0) ? prev[j] : 0; // Paths from above
                int left = (j > 0) ? curr[j - 1] : 0; // Paths from left
                
                curr[j] = up + left; // Total paths to current cell
            }
        }
        prev = curr; // Update previous row for next iteration
    }
    
    return prev[n - 1]; // Return paths count to the destination cell
}


}