class Solution {
    public int minOperations(int[] nums, int k) {
        int minVal = Integer.MAX_VALUE;
        Set<Integer> unique = new TreeSet<>((a, b) -> b - a); // descending

        for (int num : nums) {
            if (num < k) return -1; // impossible if any value is less than k
            if (num > k) unique.add(num); // only values > k matter
            minVal = Math.min(minVal, num);
        }

        if (minVal == k && unique.isEmpty()) return 0; // already all k
        return unique.size();
    }
}