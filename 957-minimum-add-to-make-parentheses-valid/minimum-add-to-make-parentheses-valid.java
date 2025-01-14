class Solution {
    public int minAddToMakeValid(String s) {
        int balance = 0; // Tracks unmatched opening parentheses '('
        int count = 0;   // Tracks unmatched closing parentheses ')'

        for (char c : s.toCharArray()) {
            if (c == '(') {
                balance++; // Increment for an opening parenthesis
            } else {
                if (balance > 0) {
                    balance--; // Match with an opening parenthesis
                } else {
                    count++; // Unmatched closing parenthesis
                }
            }
        }

        return count + balance; // Total unmatched '(' + unmatched ')'
    }
}
