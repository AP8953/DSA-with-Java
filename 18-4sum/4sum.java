import java.util.*;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 4) return ans;

        for (int i = 0; i < nums.length - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;  // Skip duplicate i

            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;  // Skip duplicate j

                long newTarget = (long) target - nums[i] - nums[j];  // Fix: Prevent overflow
                int first = j + 1, last = nums.length - 1;

                while (first < last) {
                    long sum = (long) nums[first] + nums[last];  // Ensure correct sum computation

                    if (sum == newTarget) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[first], nums[last]));

                        // Skip duplicates for first and last
                        while (first < last && nums[first] == nums[first + 1]) first++;
                        while (first < last && nums[last] == nums[last - 1]) last--;

                        first++;
                        last--;
                    } else if (sum > newTarget) {
                        last--;
                    } else {
                        first++;
                    }
                }
            }
        }
        return ans;
    }
}
