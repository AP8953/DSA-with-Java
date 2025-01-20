class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        int j = 0; // Pointer for prefix

        // Compute the LPS array
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(j)) {
                j++;
                lps[i] = j;
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // Fall back to the previous LPS
                    i--; // Stay at the current character for the next comparison
                } else {
                    lps[i] = 0; // No prefix-suffix match
                }
            }
        }

        // Length of the longest happy prefix
        int prefixLength = lps[n - 1];

        // Return the substring if a happy prefix exists, else return ""
        return prefixLength > 0 ? s.substring(0, prefixLength) : "";
    }
}
