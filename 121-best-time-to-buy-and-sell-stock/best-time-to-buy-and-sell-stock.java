class Solution {
    public int maxProfit(int[] prices) {
        int min=prices[0];
        int maxP=Integer.MIN_VALUE;
        for(int i=0;i<prices.length;i++){
            maxP=Math.max(maxP,prices[i]-min);
            min=Math.min(min, prices[i]);
        }
        return maxP;
    }
}