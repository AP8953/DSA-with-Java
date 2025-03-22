class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n = matrix.length;
        //int[][] dp = new int[n][n];
        int[] prev=new int[n];
        // for (int j = 0; j < n; j++) {
        //     dp[0][j] = matrix[0][j];
        // }
        for (int j = 0; j < n; j++) {
            prev[j] = matrix[0][j];
        }
        for(int i=1;i<n;i++){
            int[] curr=new int[n];
            for(int j=0;j<n;j++){
                int up = prev[j];  
                int leftDiagonal = (j > 0) ? prev[j-1] : Integer.MAX_VALUE;
                int rightDiagonal = (j < n-1) ? prev[j+1] : Integer.MAX_VALUE;

                curr[j] = matrix[i][j] + Math.min(up, Math.min(leftDiagonal, rightDiagonal));
            }
            prev=curr;
        }
        int mini = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            mini = Math.min(mini, prev[j]);
        }

        return mini;
    }

    
}
