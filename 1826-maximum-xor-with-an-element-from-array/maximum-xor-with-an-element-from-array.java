class Solution {
    // Define a node structure for a trie
    static class Node {
        Node[] links = new Node[2];

        boolean containsKey(int ind) {
            return links[ind] != null;
        }

        Node get(int ind) {
            return links[ind];
        }

        void put(int ind, Node node) {
            links[ind] = node;
        }
    }

    // Trie data structure for handling binary representations of numbers
    static class Trie {
        Node root;

        Trie() {
            root = new Node();
        }

        void insert(int num) {
            Node node = root;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (!node.containsKey(bit)) {
                    node.put(bit, new Node());
                }
                node = node.get(bit);
            }
        }

        int findMax(int num) {
            Node node = root;
            int maxNum = 0;
            for (int i = 31; i >= 0; i--) {
                int bit = (num >> i) & 1;
                if (node.containsKey(1 - bit)) {
                    maxNum |= (1 << i);
                    node = node.get(1 - bit);
                } else {
                    node = node.get(bit);
                }
            }
            return maxNum;
        }
    }

    public int[] maximizeXor(int[] nums, int[][] queries) {
        // Array to store the results
        int[] ans = new int[queries.length];

        // List to store offline queries as pairs of (maxValue, (number, queryIndex))
        List<int[]> offlineQueries = new ArrayList<>();
        for (int i = 0; i < queries.length; i++) {
            offlineQueries.add(new int[]{queries[i][1], queries[i][0], i});
        }

        // Sort nums and offline queries based on their maxValue
        Arrays.sort(nums);
        offlineQueries.sort((a, b) -> Integer.compare(a[0], b[0]));

        Trie trie = new Trie();
        int idx = 0;
        int n = nums.length;

        // Process each query
        for (int[] query : offlineQueries) {
            int maxValue = query[0];
            int number = query[1];
            int queryIndex = query[2];

            // Insert elements into Trie that are ≤ maxValue
            while (idx < n && nums[idx] <= maxValue) {
                trie.insert(nums[idx]);
                idx++;
            }

            // If no numbers have been inserted, the result is -1
            if (idx == 0) {
                ans[queryIndex] = -1;
            } else {
                ans[queryIndex] = trie.findMax(number);
            }
        }

        return ans;
    }
}
