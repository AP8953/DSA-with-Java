import java.util.Arrays;
import java.util.Comparator;

class Node {
    Node[] links = new Node[2];

    boolean containsKey(int index) {
        return links[index] != null;
    }

    Node get(int index) {
        return links[index];
    }

    void put(int index, Node node) {
        links[index] = node;
    }
}

class Trie {
    private static Node root;

    Trie() {
        root = new Node();
    }

    public void insert(int num) {
        Node node = root;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (!node.containsKey(bit)) {
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    public int getMax(int num) {
        Node node = root;
        if (node == null) return -1;

        int max = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                max |= (1 << i);
                node = node.get(1 - bit);
            } else if (node.containsKey(bit)) {
                node = node.get(bit);
            } else {
                return -1;
            }
        }
        return max;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        Arrays.sort(nums); // Sort nums for controlled trie insertion

        // Include query indices for reordering after sorting
        int[][] queriesWithIndex = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            queriesWithIndex[i][0] = queries[i][0];
            queriesWithIndex[i][1] = queries[i][1];
            queriesWithIndex[i][2] = i; // Store original index
        }

        // Sort queries by `mi` (second element in each query)
        Arrays.sort(queriesWithIndex, Comparator.comparingInt(a -> a[1]));

        Trie trie = new Trie();
        int[] result = new int[queries.length];
        int numIndex = 0;

        // Process each query
        for (int[] query : queriesWithIndex) {
            int xi = query[0];
            int mi = query[1];
            int queryIndex = query[2];

            // Insert all nums less than or equal to mi into the trie
            while (numIndex < nums.length && nums[numIndex] <= mi) {
                trie.insert(nums[numIndex]);
                numIndex++;
            }

            // Get the max XOR for xi if there are valid numbers in the trie
            if (numIndex == 0) {
                result[queryIndex] = -1; // No valid numbers
            } else {
                result[queryIndex] = trie.getMax(xi);
            }
        }

        return result;
    }
}
