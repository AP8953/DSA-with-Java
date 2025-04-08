class Solution {
    public int minimumOperations(int[] nums) {
        int n = nums.length;
        for (int op = 0; op * 3 <= n; op++) {
            Set<Integer> seen = new HashSet<>();
            boolean isDistinct = true;

            for (int i = op * 3; i < n; i++) {
                if (!seen.add(nums[i])) {
                    isDistinct = false;
                    break;
                }
            }

            if (isDistinct) return op;
        }

        // All elements need to be removed
        return (n + 2) / 3;
    }
}