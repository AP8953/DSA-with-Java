class Solution {
    public int countLargestGroup(int n) {
        int[] set=new int[37];
        for(int i=1;i<=n;i++){
            set[countDigitsSum(i)]++;
        }
        int max = 0, count = 0;
        for (int freq : set) {
            if (freq > max) {
                max = freq;
                count = 1;
            } else if (freq == max) {
                count++;
            }
        }
        return count;
    }
    private int countDigitsSum(int n){
        int sum=0;
        while(n>0){
            sum+=n%10;
            n=n/10;
        }
        return sum;
    }
}