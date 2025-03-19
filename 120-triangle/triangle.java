class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        int[][] grid = new int[m][m];
        
        // Convert the triangle into an m x m grid.
        // Fill positions beyond the triangle's length in each row with Integer.MAX_VALUE.
        for (int i = 0; i < m; i++) {
            int rowSize = triangle.get(i).size();
            for (int j = 0; j < m; j++) {
                if (j >= rowSize) {
                    grid[i][j] = Integer.MAX_VALUE;
                } else {
                    grid[i][j] = triangle.get(i).get(j);
                }
            }
        }
        return minPathSum(grid, m);
    }
    
    private int minPathSum(int[][] grid, int m) {
        // Since the grid was built from a triangle,
        // in row i only indices 0 through i are valid.
        int[] prev = new int[m];
        
        for (int i = 0; i < m; i++) {
            int[] curr = new int[m];
            for (int j = 0; j <= i; j++) {
                if (i == 0 && j == 0) {
                    curr[j] = grid[i][j];
                } else if (j == 0) {
                    // First element in the row can only come from directly above.
                    curr[j] = grid[i][j] + prev[j];
                } else if (j == i) {
                    // Last element in the row can only come from the element
                    // just above-left (since row i-1 has i elements).
                    curr[j] = grid[i][j] + prev[j - 1];
                } else {
                    curr[j] = grid[i][j] + Math.min(prev[j - 1], prev[j]);
                }
            }
            prev = curr;
        }
        
        // The answer is the minimum value in the last row.
        int minTotal = Integer.MAX_VALUE;
        for (int j = 0; j < m; j++) {
            minTotal = Math.min(minTotal, prev[j]);
        }
        return minTotal;
    }
}
