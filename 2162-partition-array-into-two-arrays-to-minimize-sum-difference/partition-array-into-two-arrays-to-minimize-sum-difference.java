import java.util.*;

class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        List<List<Integer>> left = new ArrayList<>(n+1);
        List<List<Integer>> right = new ArrayList<>(n+1);
        for(int i=0; i<=n; i++) {
            left.add(new ArrayList<>());
            right.add(new ArrayList<>());
        }

        generateSubsets(nums, 0, n, left);
        generateSubsets(nums, n, 2*n, right);

        int minDiff = Integer.MAX_VALUE;
        for(int k=0; k<=n; k++) {
            List<Integer> rightSubsets = right.get(n-k);
            Collections.sort(rightSubsets);
            
            for(int leftSum : left.get(k)) {
                int target = (totalSum - 2*leftSum)/2; // Optimized target calculation
                int idx = Collections.binarySearch(rightSubsets, target);
                
                if(idx >= 0) {
                    minDiff = Math.min(minDiff, Math.abs(totalSum - 2*(leftSum + rightSubsets.get(idx))));
                } else {
                    idx = -idx - 1;
                    if(idx < rightSubsets.size()) {
                        minDiff = Math.min(minDiff, Math.abs(totalSum - 2*(leftSum + rightSubsets.get(idx))));
                    }
                    if(idx > 0) {
                        minDiff = Math.min(minDiff, Math.abs(totalSum - 2*(leftSum + rightSubsets.get(idx-1))));
                    }
                }
            }
        }
        return minDiff;
    }

    private void generateSubsets(int[] nums, int start, int end, List<List<Integer>> subsets) {
        int size = end - start;
        for(int mask=0; mask<(1<<size); mask++) {
            int sum = 0, count = 0;
            for(int i=0; i<size; i++) {
                if((mask & (1<<i)) != 0) {
                    sum += nums[start+i];
                    count++;
                }
            }
            subsets.get(count).add(sum);
        }
    }
}
