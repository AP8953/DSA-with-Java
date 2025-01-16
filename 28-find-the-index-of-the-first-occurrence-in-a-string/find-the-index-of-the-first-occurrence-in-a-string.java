class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is empty
        if (needle.isEmpty()) return 0;

        // Concatenate needle + '$' + haystack
        String combined = needle + "$" + haystack;
        int n = combined.length();
        int m = needle.length();

        // Compute the Z-array
        int[] Z = computeZArray(combined);

        // Check for the first occurrence of needle in haystack
        for (int i = m + 1; i < n; i++) {
            if (Z[i] == m) {
                return i - m - 1; // Adjust the index for haystack
            }
        }

        // Return -1 if needle is not found in haystack
        return -1;
    }

    private int[] computeZArray(String s) {
        int n = s.length();
        int[] Z = new int[n];
        int l = 0, r = 0;

        for (int i = 1; i < n; i++) {
            if (i <= r) {
                Z[i] = Math.min(r - i + 1, Z[i - l]);
            }
            while (i + Z[i] < n && s.charAt(Z[i]) == s.charAt(i + Z[i])) {
                Z[i]++;
            }
            if (i + Z[i] - 1 > r) {
                l = i;
                r = i + Z[i] - 1;
            }
        }

        return Z;
    }
}
