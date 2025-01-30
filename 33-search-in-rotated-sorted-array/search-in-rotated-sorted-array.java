class Solution {
    public int search(int[] nums, int target) {
        int pivot = findPivot(nums);

        // If target is found at pivot
        if (nums[pivot] == target) return pivot;

        int n = nums.length;
        
        // If array is not rotated, do normal binary search
        if (pivot == 0) {
            return binarySearch(nums, 0, n - 1, target);
        }

        // Binary search in left or right part
        if (target >= nums[0]) {
            return binarySearch(nums, 0, pivot - 1, target);
        } else {
            return binarySearch(nums, pivot, n - 1, target);
        }
    }

    // Function to find the index of the smallest element (pivot)
    private int findPivot(int[] nums) {
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] > nums[high]) {
                low = mid + 1;  // Pivot is in the right half
            } else {
                high = mid;  // Pivot is in the left half
            }
        }
        return low;
    }

    // Standard Binary Search
    private int binarySearch(int[] nums, int low, int high, int target) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
