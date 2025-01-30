import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicate elements for i
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int target = -nums[i];
            int first = i + 1, last = nums.length - 1;

            while (first < last) {
                int sum = nums[first] + nums[last];

                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[first], nums[last]));

                    // Skip duplicate elements for first and last
                    while (first < last && nums[first] == nums[first + 1]) first++;
                    while (first < last && nums[last] == nums[last - 1]) last--;

                    first++;
                    last--;
                } else if (sum > target) {
                    last--;
                } else {
                    first++;
                }
            }
        }
        return ans;
    }
}
