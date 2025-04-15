class Solution {
  
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;

        // Map values to their indices in nums2
        int[] posInNums2 = new int[n];
        for (int i = 0; i < n; i++) {
            posInNums2[nums2[i]] = i;
        }

        // Transform nums1 into positions in nums2
        int[] transformed = new int[n];
        for (int i = 0; i < n; i++) {
            transformed[i] = posInNums2[nums1[i]];
        }

        // Initialize Fenwick Trees
        FenwickTree leftTree = new FenwickTree(n);
        FenwickTree rightTree = new FenwickTree(n);

        // Fill rightTree with frequencies of transformed values
        for (int val : transformed) {
            rightTree.update(val, 1);
        }

        long count = 0;
        for (int i = 0; i < n; i++) {
            int current = transformed[i];
            // Remove current from right tree (we're at this index now)
            rightTree.update(current, -1);

            long leftCount = leftTree.query(current - 1);         // elements < current to the left
            long rightCount = rightTree.query(n - 1) - rightTree.query(current);  // elements > current to the right

            count += leftCount * rightCount;

            // Add current to left tree
            leftTree.update(current, 1);
        }

        return count;
    }

    // Fenwick Tree (Binary Indexed Tree)
    static class FenwickTree {
        int[] tree;
        int size;

        FenwickTree(int n) {
            size = n;
            tree = new int[n + 1];
        }

        void update(int index, int delta) {
            index++;  // 1-based index
            while (index <= size) {
                tree[index] += delta;
                index += index & -index;
            }
        }

        int query(int index) {
            index++;  // 1-based index
            int sum = 0;
            while (index > 0) {
                sum += tree[index];
                index -= index & -index;
            }
            return sum;
        }
    }
}

