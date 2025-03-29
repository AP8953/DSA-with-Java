class Solution {
    public int mySqrt(int x) {
        int i=0;
        while((Math.pow(i,2))<=x){
            i++;
        }
        return i-1;
    }
}