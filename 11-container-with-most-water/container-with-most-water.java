class Solution {
    public int maxArea(int[] height) {
        int first = 0, last = height.length - 1;
        int max = 0; // No need for Integer.MIN_VALUE, as area is always non-negative

        while (first < last) {
            int minHeight = Math.min(height[first], height[last]);
            max = Math.max(max, minHeight * (last - first));

            // Move the pointer pointing to the shorter line
            if (height[first] < height[last]) {
                first++;
            } else {
                last--;
            }
        }
        return max;
    }
}
