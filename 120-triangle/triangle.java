class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int dp[][] = new int[n][n];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        return countSum(triangle, 0,0,dp);

    }
    private int countSum(List<List<Integer>> triangle, int i, int j, int[][] dp){
        if (dp[i][j] != -1)
            return dp[i][j];
        int m=triangle.size();
        if(i==m-1) return triangle.get(m-1).get(j);
        int down=triangle.get(i).get(j)+countSum(triangle, i+1, j, dp);
        int downRight=triangle.get(i).get(j)+countSum(triangle,i+1,j+1, dp);
        dp[i][j] = Math.min(down, downRight);  // Store the result in dp
        return dp[i][j];
    }
    
}