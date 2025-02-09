class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans=new ArrayList<>();
        ans.add(intervals[0]);
        for(int i=1;i<intervals.length;i++){
            int first=intervals[i][0];
            int check=ans.get(ans.size()-1)[1];
            if(first<=check){
                ans.get(ans.size()-1)[1]=Math.max(intervals[i][1],ans.get(ans.size()-1)[1]);

            }
            else{
                ans.add(intervals[i]);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }
}