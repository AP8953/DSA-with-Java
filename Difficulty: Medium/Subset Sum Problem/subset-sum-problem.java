//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String input_line[] = read.readLine().trim().split("\\s+");
            int N = input_line.length;
            int arr[] = new int[N];
            for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if (ob.isSubsetSum(arr, sum))
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


class Solution {

    static Boolean isSubsetSum(int arr[], int sum) {
        Boolean[][] dp = new Boolean[arr.length][sum + 1];
        return func(arr, sum, arr.length - 1, dp);
    }

    private static boolean func(int[] arr, int sum, int i, Boolean[][] dp) {
        if (sum == 0) return true;
        if (i == 0) return arr[0] == sum;
        if (dp[i][sum] != null) return dp[i][sum];

        boolean notTaken = func(arr, sum, i - 1, dp);
        boolean taken = false;
        if (arr[i] <= sum) taken = func(arr, sum - arr[i], i - 1, dp);

        return dp[i][sum] = notTaken || taken;
    }
}