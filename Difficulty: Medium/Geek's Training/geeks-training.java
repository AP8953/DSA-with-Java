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
        int n = arr.length;
        
        // Initialize dp values for the first row
        int prev0 = arr[0][0];
        int prev1 = arr[0][1];
        int prev2 = arr[0][2];

        // Iterating over remaining rows
        for (int i = 1; i < n; i++) {
            int curr0 = arr[i][0] + Math.max(prev1, prev2);
            int curr1 = arr[i][1] + Math.max(prev0, prev2);
            int curr2 = arr[i][2] + Math.max(prev0, prev1);

            // Move current row values to previous row variables
            prev0 = curr0;
            prev1 = curr1;
            prev2 = curr2;
        }

        // Final maximum of last row
        return Math.max(prev0, Math.max(prev1, prev2));
    }
}
