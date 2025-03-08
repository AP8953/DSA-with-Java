//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int[][] arr = new int[N][3];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < 3; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            Solution obj = new Solution();
            int res = obj.maximumPoints(arr);
            System.out.println(res);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int maximumPoints(int arr[][]) {
        int n = arr.length;  // Get the number of days
        
        // dp[i][j] will store the maximum points till day i with last activity j
        int[][] dp = new int[n][3];
        
        // Initialize the dp array for the first day
        for (int j = 0; j < 3; j++) {
            dp[0][j] = arr[0][j];
        }
        
        // Fill the dp array for subsequent days
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                // We need to choose the best activity for the current day
                // Avoid the activity that was chosen the previous day (activity j)
                dp[i][j] = arr[i][j] + Math.max(dp[i - 1][(j + 1) % 3], dp[i - 1][(j + 2) % 3]);
            }
        }
        
        // The answer will be the maximum of the last day's activities
        return Math.max(dp[n - 1][0], Math.max(dp[n - 1][1], dp[n - 1][2]));
    }
}