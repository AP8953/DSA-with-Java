import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = Arrays.stream(nums).sum();

        // Generate all subset sums for the first half
        List<List<Integer>> leftSums = generateSubsetSums(nums, 0, n);
        // Generate all subset sums for the second half
        List<List<Integer>> rightSums = generateSubsetSums(nums, n, 2 * n);

        int minDiff = Math.abs(totalSum - 2 * leftSums.get(n).get(0)); // Edge case: picking all elements from one side

        // Iterate over the possible subset sizes
        for (int size = 0; size <= n; size++) {
            List<Integer> left = leftSums.get(size);
            List<Integer> right = rightSums.get(n - size);
            Collections.sort(right); // Sort for binary search

            // Check for minimum difference using binary search
            for (int leftSum : left) {
                int target = totalSum / 2 - leftSum;
                int idx = Collections.binarySearch(right, target);
                if (idx < 0) idx = -idx - 1; // If not found, find the closest larger element

                // Compare with closest values
                if (idx < right.size()) {
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (leftSum + right.get(idx))));
                }
                if (idx > 0) {
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2 * (leftSum + right.get(idx - 1))));
                }
            }
        }
        return minDiff;
    }

    // Generates all subset sums for a given range
    private List<List<Integer>> generateSubsetSums(int[] nums, int start, int end) {
        int size = end - start;
        List<List<Integer>> subsets = new ArrayList<>();
        for (int i = 0; i <= size; i++) subsets.add(new ArrayList<>());

        // Generate all subsets using bitmasking
        for (int mask = 0; mask < (1 << size); mask++) {
            int sum = 0, count = 0;
            for (int j = 0; j < size; j++) {
                if ((mask & (1 << j)) != 0) {
                    sum += nums[start + j];
                    count++;
                }
            }
            subsets.get(count).add(sum);
        }
        return subsets;
    }
}
