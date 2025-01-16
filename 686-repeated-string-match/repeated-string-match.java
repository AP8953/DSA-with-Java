class Solution {
    public int repeatedStringMatch(String a, String b) {
        int m = a.length(), n = b.length();

        // Minimum repetitions to ensure b's length is covered
        int minRepeats = (n + m - 1) / m; // Equivalent to ceil(n / m)

        // Build the repeated string for minRepeats
        StringBuilder repeatedA = new StringBuilder();
        for (int i = 0; i < minRepeats; i++) {
            repeatedA.append(a);
        }

        // Check if b is a substring with minRepeats
        if (repeatedA.toString().contains(b)) {
            return minRepeats;
        }

        // Add one more repetition to account for overlaps
        repeatedA.append(a);
        if (repeatedA.toString().contains(b)) {
            return minRepeats + 1;
        }

        // If b is still not a substring, return -1
        return -1;
    }

    private boolean rabinKarp(String text, String pattern) {
        int d = 256; // Number of characters in the input alphabet
        int q = 101; // A prime number to reduce hash collisions
        int m = pattern.length();
        int n = text.length();
        int pHash = 0; // Hash value for the pattern
        int tHash = 0; // Hash value for the text
        int h = 1; // Value of d^(m-1) % q

        // Compute h = d^(m-1) % q
        for (int i = 0; i < m - 1; i++) {
            h = (h * d) % q;
        }

        // Compute initial hash values for pattern and first window of text
        for (int i = 0; i < m; i++) {
            pHash = (d * pHash + pattern.charAt(i)) % q;
            tHash = (d * tHash + text.charAt(i)) % q;
        }

        // Slide the pattern over text one character at a time
        for (int i = 0; i <= n - m; i++) {
            // Check if the hash values match
            if (pHash == tHash) {
                // Perform a character-by-character check
                boolean match = true;
                for (int j = 0; j < m; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }

            // Compute hash value for next window of text
            if (i < n - m) {
                tHash = (d * (tHash - text.charAt(i) * h) + text.charAt(i + m)) % q;
                if (tHash < 0) {
                    tHash += q; // Make sure hash value is positive
                }
            }
        }

        return false;
    }
}
