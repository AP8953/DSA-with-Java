class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) {
            return s; // Base case: Single character or empty string is already a palindrome
        }

        // Reverse the string
        String reversed = new StringBuilder(s).reverse().toString();

        // Concatenate s + '#' + reverse(s)
        String combined = s + "#" + reversed;

        // Compute the LPS array for the combined string
        int[] lps = computeLPS(combined);

        // Length of the longest palindromic prefix
        int palindromeLength = lps[combined.length() - 1];

        // Find the suffix to be added to make the string a palindrome
        String suffix = s.substring(palindromeLength);

        // Add the reversed suffix in front of s
        return new StringBuilder(suffix).reverse().toString() + s;
    }

    private int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int j = 0; // Length of the previous longest prefix suffix

        for (int i = 1; i < n; i++) {
            if (str.charAt(i) == str.charAt(j)) {
                j++;
                lps[i] = j;
            } else {
                if (j != 0) {
                    j = lps[j - 1]; // Fall back to the previous prefix suffix
                    i--; // Stay at the same character for the next comparison
                } else {
                    lps[i] = 0; // No prefix suffix match
                }
            }
        }

        return lps;
    }
}
