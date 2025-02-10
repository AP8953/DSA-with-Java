class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Sort intervals based on end time (greedy approach)
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        
        int count = 0;
        int lastEnd = Integer.MIN_VALUE;  // Track the last included interval's end time
        
        for (int[] interval : intervals) {
            if (interval[0] >= lastEnd) {
                // No overlap, update lastEnd
                lastEnd = interval[1];
            } else {
                // Overlapping interval, must be removed
                count++;
            }
        }
        
        return count;
    }
}
