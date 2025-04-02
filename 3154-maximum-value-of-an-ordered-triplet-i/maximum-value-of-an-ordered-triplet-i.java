class Solution {
    public long maximumTripletValue(int[] nums) {
        long max=Integer.MIN_VALUE;
        for(int i=0;i<nums.length-2;i++){
            for(int j=i+1;j<nums.length-1;j++){
                for(int k=j+1;k<nums.length;k++){
                    long temp=(long)(nums[i] - nums[j]) * (long)nums[k];
                    max=Math.max(max, temp);
                }
            }
        }
        return max<0? 0:max;
    }

}