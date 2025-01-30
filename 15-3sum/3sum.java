class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        
        for(int i=0;i<nums.length-2;i++){
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target=0-nums[i];
            int first=i+1;
            int last=nums.length-1;
            while(first<last){
                if((nums[first]+nums[last])==target){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(nums[first]);
                    temp.add(nums[last]);
                    temp.add(nums[i]);
                    ans.add(temp);
                    while (first < last && nums[first] == nums[first + 1]) first++;
                    while (first < last && nums[last] == nums[last - 1]) last--;
                    first++;
                    last--;
                }
                else {
                    if(nums[first]+nums[last]>target){
                        last--;
                    }
                    else{
                        first++;
                    }
                }
            }
        }
        return ans;
    }
}