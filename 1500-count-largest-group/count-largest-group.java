class Solution {
    public int countLargestGroup(int n) {
        int[] set=new int[10000];
        for(int i=1;i<=n;i++){
            set[countDigitsSum(i)]++;
        }
        int max=0;
        for(int i=0;i<10000;i++){
            max=Math.max(max, set[i]);
        }
        int count=0;
        for(int i=0;i<10000;i++){
            if(set[i]==max) count++;
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