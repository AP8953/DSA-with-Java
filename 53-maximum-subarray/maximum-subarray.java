class Solution {
    public int maxSubArray(int[] nums) {
        int ans=nums[0];
        int temp=0;
        for(int i=0;i<nums.length;i++){
            temp+=nums[i];
            ans=Math.max(temp,ans);
            if(temp<0)temp=0;
        }
        return ans;
    }
}