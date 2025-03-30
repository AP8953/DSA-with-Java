class Solution {
    public boolean canPartition(int[] nums) {
        
        int sum=0;
        for(int num: nums){
            sum+=num;
        }
        if(sum%2!=0) return false; 
        Boolean[][] dp=new Boolean[nums.length][(sum/2)+1];
        return func(nums, sum/2, nums.length-1, dp );
    }
    private boolean func(int[] nums, int target, int i, Boolean[][] dp){
        if(target==0) return true;
        if(i==0) return nums[0]==target;
        if(dp[i][target]!=null) return dp[i][target];
        boolean notTaken =func(nums, target, i-1, dp);
        boolean taken=false;
        if(nums[i]<=target) taken=func(nums, target-nums[i], i-1, dp);
        return dp[i][target]=taken || notTaken;
    }
}