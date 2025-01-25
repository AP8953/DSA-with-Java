class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] ans={-1,-1};
        Map<Integer, Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            
            if(map.containsKey(target-nums[i])){
                ans[0]=map.get(target-nums[i]);
                ans[1]=i;
                break;
            }
            map.put(nums[i],i);
        }
        return ans;
    }
}