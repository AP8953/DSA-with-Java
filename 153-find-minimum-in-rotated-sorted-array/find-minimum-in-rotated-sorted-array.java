class Solution {
    public int findMin(int[] nums) {
        int smallest=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            if(smallest>nums[i]){
                smallest=nums[i];
            }
        }
        return smallest;
    }
}