class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long sum=0, max=0, min=0;
        for(int n:differences){
            sum+=n;
            max=Math.max(max, sum);
            min=Math.min(min,sum);
        }
        return (int) Math.max(0, (upper - max) - (lower - min) + 1);
    }
}