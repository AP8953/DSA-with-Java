//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[str.length];
            for (int i = 0; i < str.length; i++) {
                a[i] = Integer.parseInt(str[i]);
            }
            String[] nk = br.readLine().trim().split(" ");
            int k = Integer.parseInt(nk[0]);
            Solution sln = new Solution();
            int ans = sln.countPartitions(a, k);

            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends



class Solution {

    public int countPartitions(int[] arr, int d) {
        int totalSum = 0;
        for (int num : arr) totalSum += num;

        if (totalSum < d || (totalSum - d) % 2 != 0) return 0;
        int target = (totalSum - d) / 2;
        return perfectSum(arr, target);
        }
    private int perfectSum(int[] arr, int target){
        int n = arr.length;
        
        int[][] dp = new int[n + 1][target + 1];

        // Base case: 1 way to achieve sum 0 (empty subset)
        for (int i = 0; i <= n; i++) dp[i][0] = 1;

        // DP table filling
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                dp[i][j] = dp[i - 1][j]; // Exclude current element
                if (arr[i - 1] <= j) dp[i][j] += dp[i - 1][j - arr[i - 1]]; // Include current element
            }
        }
        return dp[n][target];
    
    }
}

