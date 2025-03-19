class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        int[][] dp=new int[n][n];
        int[] prev=new int[n];
        for(int j=0;j<n;j++){
            dp[n-1][j]=triangle.get(n-1).get(j);
            prev[j]=triangle.get(n-1).get(j);
        }
        for(int i=n-2;i>=0;i--){
            int curr[]=new int[n];
            for(int j=i;j>=0;j--){
                //int down=triangle.get(i).get(j)+dp[i+1][j];
                int down=triangle.get(i).get(j)+prev[j];
                //int downRight=triangle.get(i).get(j)+dp[i+1][j+1];
                int downRight=triangle.get(i).get(j)+prev[j+1];
                curr[j]=Math.min(down,downRight);
                
            }prev=curr;
        }
        return prev[0];
    }
}