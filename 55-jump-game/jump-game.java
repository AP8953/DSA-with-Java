class Solution {
    public boolean canJump(int[] nums) {
        int max=0;
        for(int i=0;i<nums.length;i++){
            int temp=nums[i];
            max=Math.max(max,i+temp);
            if(temp==0&&max<=i&&(nums.length-1)!=i){
                return false;
            }
            else{
                
                if(max>=(nums.length-1)){
                    return true;
                }
            }
            
        }
        return false;
    }
}