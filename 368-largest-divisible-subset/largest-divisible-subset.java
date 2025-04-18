class Solution {
    

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];  // dp[i] = size of largest subset ending at i
        int[] prev = new int[n]; // prev[i] = previous index in the subset
        Arrays.fill(dp, 1);
        Arrays.fill(prev, -1);
        
        int maxSize = 1, maxIndex = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            if (dp[i] > maxSize) {
                maxSize = dp[i];
                maxIndex = i;
            }
        }

        List<Integer> res = new ArrayList<>();
        while (maxIndex >= 0) {
            res.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(res);
        return res;
    }


    
}