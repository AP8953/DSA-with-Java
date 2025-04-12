import java.util.*;

class Solution {
    public long countGoodIntegers(int n, int k) {
        Set<String> seen = new HashSet<>();
        int half = (n + 1) / 2;
        int start = (int) Math.pow(10, half - 1);
        int end = (int) Math.pow(10, half);
        long result = 0;

        for (int i = start; i < end; i++) {
            String left = Integer.toString(i);
            String right = new StringBuilder(left.substring(0, n / 2)).reverse().toString();
            String palindromeStr = left + right;
            long palindrome = Long.parseLong(palindromeStr);
            if (palindrome % k == 0) {
                char[] arr = palindromeStr.toCharArray();
                Arrays.sort(arr);
                String key = new String(arr);
                if (!seen.contains(key)) {
                    seen.add(key);
                    result += countPermutations(arr);
                }
            }
        }
        return result;
    }

    private long countPermutations(char[] sortedDigits) {
        Map<Character, Integer> freq = new HashMap<>();
        for (char c : sortedDigits)
            freq.put(c, freq.getOrDefault(c, 0) + 1);

        long total = factorial(sortedDigits.length);
        for (int val : freq.values())
            total /= factorial(val);

        // remove those with leading 0
        if (freq.containsKey('0')) {
            long invalid = 0;
            freq.put('0', freq.get('0') - 1);
            int len = sortedDigits.length - 1;
            long denom = 1;
            for (int val : freq.values())
                denom *= factorial(val);
            invalid = factorial(len) / denom;
            freq.put('0', freq.get('0') + 1);
            return total - invalid;
        }
        return total;
    }

    private long factorial(int n) {
        long res = 1;
        for (int i = 2; i <= n; i++)
            res *= i;
        return res;
    }
}
