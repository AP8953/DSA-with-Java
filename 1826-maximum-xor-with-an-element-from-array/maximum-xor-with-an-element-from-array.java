class Solution {
    // Define the Trie Node structure
    static class Node {
        Node[] links = new Node[2]; // Binary Trie has two possible children: 0 and 1

        boolean containsKey(int bit) {
            return links[bit] != null; // Check if a specific bit branch exists
        }

        Node get(int bit) {
            return links[bit]; // Get the child node for a specific bit
        }

        void put(int bit, Node node) {
            links[bit] = node; // Create a new branch for the bit
        }
    }

    // Trie structure for storing binary representations of numbers
    static class Trie {
        private final Node root;

        Trie() {
            root = new Node(); // Initialize root node
        }

        void insert(int num) {
            Node node = root;
            // Iterate over the 32 bits of the number from most significant to least significant
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1; // Extract the i-th bit
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node()); // Create a branch for the bit if it doesn't exist
                }
                node = node.get(bit); // Move to the next node
            }
        }

        int findMaxXor(int num) {
            Node node = root;
            int maxXor = 0;

            // Try to build the number that maximizes XOR
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1; // Extract the i-th bit
                int oppositeBit = 1 - bit; // XOR is maximized by taking the opposite bit

                if (node.containsKey(oppositeBit)) {
                    maxXor |= (1 << i); // Update the result with the i-th bit set
                    node = node.get(oppositeBit);
                } else {
                    node = node.get(bit); // Follow the same bit branch if opposite doesn't exist
                }
            }
            return maxXor;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        int[] result = new int[queries.length];
        List<int[]> sortedQueries = new ArrayList<>();

        // Pair each query with its index and sort by the maxValue
        for (int i = 0; i < queries.length; i++) {
            sortedQueries.add(new int[]{queries[i][1], queries[i][0], i});
        }

        // Sort nums and queries
        Arrays.sort(nums);
        sortedQueries.sort((a, b) -> Integer.compare(a[0], b[0]));

        Trie trie = new Trie();
        int index = 0;

        for (int[] query : sortedQueries) {
            int maxValue = query[0];
            int num = query[1];
            int queryIndex = query[2];

            // Insert numbers into the Trie that are ≤ maxValue
            while (index < nums.length && nums[index] <= maxValue) {
                trie.insert(nums[index]);
                index++;
            }

            // If no numbers are eligible, return -1 for this query
            if (index == 0) {
                result[queryIndex] = -1;
            } else {
                result[queryIndex] = trie.findMaxXor(num);
            }
        }

        return result;
    }
}
