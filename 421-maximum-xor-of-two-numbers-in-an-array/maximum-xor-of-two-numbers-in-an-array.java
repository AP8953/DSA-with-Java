class Solution {
    public int findMaximumXOR(int[] nums) {
        int max = 0;
        int mask = 0;
        
        // Traverse from the most significant bit (31st bit) to the least significant bit (0th bit)
        for (int i = 31; i >= 0; i--) {
            mask |= (1 << i); // Create a mask that includes the first i bits
            HashSet<Integer> prefixes = new HashSet<>();
            
            // Add all the prefixes of the current numbers
            for (int num : nums) {
                prefixes.add(num & mask);
            }
            
            // Try to find the maximum XOR for the current bit
            int candidate = max | (1 << i); // Set the current bit in the candidate result
            for (int prefix : prefixes) {
                // Check if there exists a prefix that can give the candidate XOR
                if (prefixes.contains(prefix ^ candidate)) {
                    max = candidate; // Update max if a better candidate is found
                    break;
                }
            }
        }
        
        return max;
    }
}
