class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, (int)1e9);
        dp[0] = 0; // base case: 0 coins needed to make amount 0

        for (int coin : coins) {
            for (int amt = coin; amt <= amount; amt++) {
                dp[amt] = Math.min(dp[amt], 1 + dp[amt - coin]);
            }
        }

        return dp[amount] == (int)1e9 ? -1 : dp[amount];
    }

}