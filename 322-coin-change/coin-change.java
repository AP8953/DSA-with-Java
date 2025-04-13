class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) dp[0][i]=i/coins[0];
            else dp[0][i]=(int)1e9;
        }
        
        for(int i=1;i<coins.length;i++){
            for(int target=0;target<=amount;target++){
                int notTaken=dp[i-1][target];
                int taken=(coins[i]<=target)?1+dp[i][target-coins[i]]:(int)1e9;
                dp[i][target]=Math.min(notTaken,taken);
            }
        }
        int result=dp[coins.length-1][amount];
        return result>=(int)1e9?-1:result;
        
    }
    
    
}