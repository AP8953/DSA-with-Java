class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        // [[1, 3], [5, 6]], [7, 8]
        // [[1, 3], [5, 6], [7, 8]]

        List<int[]> result = new ArrayList<>();
        // intervals ends before the newInterval starts
        int i = 0;
        while(i < intervals.length) {
            if(intervals[i][1] >= newInterval[0]) {
                break;
            }
            result.add(intervals[i]);
            i += 1;
        }
        // intervals (starts before the newInterval starts and) ends after the newInterval starts
        // merge required
        while(
            i < intervals.length &&
            intervals[i][0] <= newInterval[1] &&
            intervals[i][1] >= newInterval[0]
        ) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i += 1;
        }
        result.add(newInterval);

        // intervals starts after the newInterval ends
        while(i < intervals.length) {
            result.add(intervals[i]);
            i += 1;
        }

        int[][] ans = new int[result.size()][2];
        for(int j = 0; j < ans.length; j++) {
            ans[j] = result.get(j);
        }
        return ans;
    }
}