import java.util.*;

class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMostK(nums, k) - atMostK(nums, k - 1);
    }

    private int atMostK(int[] nums, int k) {
        if (k < 0) return 0;

        int left = 0, right = 0, total = 0;
        int[] count = new int[nums.length + 1]; // Frequency array
        int distinct = 0;

        while (right < nums.length) {
            if (count[nums[right]] == 0) distinct++; // New distinct element
            count[nums[right]]++;
            right++;

            while (distinct > k) { // Shrink window if too many distinct elements
                count[nums[left]]--;
                if (count[nums[left]] == 0) distinct--; // Remove distinct element
                left++;
            }

            total += (right - left); // Count all valid subarrays ending at `right - 1`
        }

        return total;
    }
}
