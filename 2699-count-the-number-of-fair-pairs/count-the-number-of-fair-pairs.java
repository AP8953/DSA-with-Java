import java.util.Arrays;

class Solution {
    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            int low = lower - nums[i];
            int high = upper - nums[i];
            // Use binary search to find how many j > i satisfy: low <= nums[j] <= high
            int left = lowerBound(nums, i + 1, nums.length - 1, low);
            int right = upperBound(nums, i + 1, nums.length - 1, high);
            count += (right - left + 1);
        }
        return count;
    }

    private int lowerBound(int[] nums, int left, int right, int target) {
        int ans = right + 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return ans;
    }

    private int upperBound(int[] nums, int left, int right, int target) {
        int ans = left - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }
}
