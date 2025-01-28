class Solution {
    public int maxProduct(int[] nums) {
        int ans=Integer.MIN_VALUE;
        int prefixprod=1;
        int suffixprod=1;
        for(int i=0;i<nums.length;i++){
            if(prefixprod==0) prefixprod=1;
            prefixprod*=nums[i];
            if(suffixprod==0) suffixprod=1;
            suffixprod*=nums[nums.length-i-1];
            ans=Math.max(ans,Math.max(prefixprod,suffixprod));
            
        }
        return ans;
    }
}