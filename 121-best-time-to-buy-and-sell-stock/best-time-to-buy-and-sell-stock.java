class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int maxP=0;
        for(int i=1;i<prices.length;i++){
            maxP=Math.max(maxP,prices[i]-min);
            min=Math.min(min, prices[i]);
        }
        return maxP;
    }
}