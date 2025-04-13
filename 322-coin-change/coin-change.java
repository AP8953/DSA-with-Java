class Solution {
    public int coinChange(int[] coins, int amount) {
        int[][] dp=new int[coins.length][amount+1];
        for(int[] row:dp) Arrays.fill(row,-1);

        int result= func(coins, amount,coins.length-1,dp);
        return result==(int)1e9?-1:result;
    }
    
    private int func(int[] coins, int amount, int i, int[][] dp){
        if(i==0){
            if(amount%coins[0]==0) return amount/coins[0];
            else return (int)1e9;
        }

        //if(amount==0) return count;
        //if(i==0) return (coins[i]==amount)?count:-1;
        if(dp[i][amount]!=-1) return dp[i][amount];
        int notTaken=func(coins, amount, i-1, dp);
        int taken=(coins[i]<=amount)?1+func(coins,amount-coins[i],i,dp):(int)1e9;
        return dp[i][amount]=Math.min(notTaken,taken);
    } 
}