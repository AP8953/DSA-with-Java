class Solution {
    // Define the TrieNode class
    static class TrieNode {
        TrieNode[] children = new TrieNode[2]; // Each node can have 0 or 1 as a child
    }

    public int findMaximumXOR(int[] nums) {
        TrieNode root = new TrieNode();
        
        // Function to insert a number into the Trie
        for (int num : nums) {
            TrieNode node = root;
            for (int i = 31; i >= 0; i--) { // Process the number bit by bit from the MSB to LSB
                int bit = (num >> i) & 1; // Extract the i-th bit
                if (node.children[bit] == null) {
                    node.children[bit] = new TrieNode();
                }
                node = node.children[bit];
            }
        }
        
        int max = 0;
        
        // Function to calculate the maximum XOR for each number
        for (int num : nums) {
            TrieNode node = root;
            int currXOR = 0;
            for (int i = 31; i >= 0; i--) { // Process the number bit by bit from the MSB to LSB
                int bit = (num >> i) & 1;
                int oppositeBit = 1 - bit; // Opposite bit of the current bit
                if (node.children[oppositeBit] != null) {
                    currXOR = (currXOR << 1) | 1; // Add 1 to the XOR result
                    node = node.children[oppositeBit];
                } else {
                    currXOR = (currXOR << 1); // Add 0 to the XOR result
                    node = node.children[bit];
                }
            }
            max = Math.max(max, currXOR);
        }
        
        return max;
    }
}
