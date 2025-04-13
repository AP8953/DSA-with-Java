class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] prev=new int[amount+1];
        
        for(int i=0;i<=amount;i++){
            if(i%coins[0]==0) prev[i]=i/coins[0];
            else prev[i]=(int)1e9;
        }
        
        for(int i=1;i<coins.length;i++){
            int[] curr=new int[amount+1];
            curr[0]=(int)1e9;
            for(int target=0;target<=amount;target++){
                int notTaken=prev[target];
                int taken=(coins[i]<=target)?1+curr[target-coins[i]]:(int)1e9;
                curr[target]=Math.min(notTaken,taken);
            }
            prev=curr;
        }
        int result=prev[amount];
        return result>=(int)1e9?-1:result;
        
    }
    
    
}