class Solution {
    // Rabin-Karp implementation to check if s2 is a substring of s1
    public boolean rabinKarp(String s1, String s2) {
        long p = 31; // Prime number for hashing
        long mod = 1000000007; // Large prime for modulo operation
        long pow = 1;
        long bHash = 0; // Hash of the string s2

        // Calculate the hash for s2
        for (int i = 0; i < s2.length(); i++) {
            bHash = (bHash + (s2.charAt(i) - 'a' + 1) * pow) % mod;
            pow = (pow * p) % mod;
        }

        // Generate prefix hashes and powers for s1
        long[] prefixHash = new long[s1.length()];
        long[] prefixPower = new long[s1.length()];

        prefixHash[0] = s1.charAt(0) - 'a' + 1;
        prefixPower[0] = 1;
        pow = p;

        for (int i = 1; i < s1.length(); i++) {
            prefixHash[i] = (prefixHash[i - 1] + (s1.charAt(i) - 'a' + 1) * pow) % mod;
            prefixPower[i] = pow;
            pow = (pow * p) % mod;
        }

        // Sliding window to find a substring in s1 that matches the hash of s2
        int start = 0;
        int end = s2.length() - 1;

        while (end < s1.length()) {
            long currentHash = prefixHash[end];

            if (start > 0) {
                currentHash = (currentHash - prefixHash[start - 1] + mod) % mod;
            }

            if ((bHash * prefixPower[start]) % mod == currentHash) {
                return true; // Found s2 in s1
            }

            start++;
            end++;
        }

        return false; // s2 is not a substring of s1
    }

    public int repeatedStringMatch(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int count = 0;

        // Repeat `a` until its length exceeds or equals `b`
        while (sb.length() < b.length()) {
            sb.append(a);
            count++;
        }

        // Check if `b` is a substring of the repeated `a`
        if (rabinKarp(sb.toString(), b)) {
            return count;
        }
        // Check if one more repetition of `a` makes `b` a substring
        else if (rabinKarp(sb.toString() + a, b)) {
            return count + 1;
        }

        // `b` cannot be a substring of any repetition of `a`
        return -1;
    }
}
