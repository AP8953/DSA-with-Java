import java.util.Arrays;
import java.util.Comparator;

class Node {
    Node link[] = new Node[2];

    boolean containsKey(int index) {
        return link[index] != null;
    }

    Node get(int index) {
        return link[index];
    }

    void put(int index, Node node) {
        link[index] = node;
    }
}

class Trie {
    private Node root;

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
        int max = 0;
        for (int i = 31; i >= 0; i--) {
            int bit = (num >> i) & 1;
            if (node.containsKey(1 - bit)) {
                max = max | (1 << i);
                node = node.get(1 - bit);
            } else {
                node = node.get(bit);
            }
        }
        return max;
    }
}

class Solution {
    public int[] maximizeXor(int[] nums, int[][] queries) {
        // Sort nums for processing in ascending order
        Arrays.sort(nums);

        // Append original indices to queries to handle results correctly
        int[][] extendedQueries = new int[queries.length][3];
        for (int i = 0; i < queries.length; i++) {
            extendedQueries[i][0] = queries[i][0];
            extendedQueries[i][1] = queries[i][1];
            extendedQueries[i][2] = i; // Store the original index
        }

        // Sort queries by the second value (mi)
        Arrays.sort(extendedQueries, Comparator.comparingInt(a -> a[1]));

        // Result array
        int[] result = new int[queries.length];
        Trie trie = new Trie();
        int index = 0;

        // Process queries
        for (int[] query : extendedQueries) {
            int x = query[0];
            int m = query[1];
            int originalIndex = query[2];

            // Insert all numbers <= m into the Trie
            while (index < nums.length && nums[index] <= m) {
                trie.insert(nums[index]);
                index++;
            }

            // If no valid numbers were added to the Trie
            if (index == 0) {
                result[originalIndex] = -1;
            } else {
                result[originalIndex] = trie.getMax(x);
            }
        }

        return result;
    }
}
