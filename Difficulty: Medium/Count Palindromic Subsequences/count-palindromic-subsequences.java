//{ Driver Code Starts
import java.util.*;

class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        while (t > 0) {
            String str = sc.nextLine();
            // System.out.println(str.length());
            Solution ob = new Solution();
            System.out.println(ob.countPS(str));
            t--;

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


/*You are required to complete below method */

class Solution {
    int countPS(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];

        // Base case: Single character substrings are palindromic
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }

        // Fill the DP table for substrings of length 2 to n
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] + 1;
                } else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j - 1] - dp[i + 1][j - 1];
                }
            }
        }

        // Result is stored in dp[0][n-1]
        return dp[0][n - 1];
    }
}
