class Solution {
    public boolean canPartition(int[] nums) {
        int sum=Arrays.stream(nums).sum();
        if(sum%2!=0) return false;
        int target=sum/2;
        boolean[] prev=new boolean[target+1];
        prev[0]=true;
        if(nums[0]<=target) prev[nums[0]]=true;
        for(int i=1;i<nums.length;i++){
            // boolean[] curr=new boolean[target+1];
            // curr[0]=true;
            // for(int j=1;j<=target;j++){
            //     boolean notTaken=prev[j];
            //     boolean taken=(nums[i]<=j) ? prev[j-nums[i]]:false;
            //     curr[target]=notTaken|| taken;
            // }
            // prev=curr;
            for(int j=target;j>=nums[i];j--){
                prev[j]=prev[j] || prev[j-nums[i]];
            }
        }
        return prev[target];
    }
}