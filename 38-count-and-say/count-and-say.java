class Solution {
    public String countAndSay(int n) {
        // Base case: the first element of the sequence is "1"
        String result = "1";
        
        // Generate the sequence from 2 to n
        for (int i = 2; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            int length = result.length();
            
            // Process the current string to generate the next string
            for (int j = 0; j < length; j++) {
                int count = 1;
                // Count how many times the current character repeats
                while (j + 1 < length && result.charAt(j) == result.charAt(j + 1)) {
                    count++;
                    j++;
                }
                // Append the count and the character
                sb.append(count).append(result.charAt(j));
            }
            
            // Update result with the new string
            result = sb.toString();
        }
        
        return result;
    }
}
