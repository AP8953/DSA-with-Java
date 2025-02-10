class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[1], b[1]));
        List<int[]> ans=new ArrayList<>();
        ans.add(intervals[0]);
        int count=1;
        int lastEnd=ans.get(0)[1];
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=lastEnd){
                count++;
                lastEnd=intervals[i][1];
            }
        }
        return intervals.length-count;
    }
}