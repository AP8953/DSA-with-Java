class Solution {
    public int climbStairs(int n) {
        if(n<3) return n;
        else{
            int prev=2;
            int prev2=1;
            for(int i=3;i<=n;i++){
                int temp=prev+prev2;
                prev2=prev;
                prev=temp;
            }
            return prev;
        }
    }
}