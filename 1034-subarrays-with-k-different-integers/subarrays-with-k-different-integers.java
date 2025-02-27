class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atMost(nums,k) - atMost(nums,k-1);
    }
    private int atMost(int[] nums, int k){
        int left=0, right=0;
        HashMap<Integer, Integer> count=new HashMap<>();
        int ans=0;
        while(right<nums.length){
            int num=nums[right];
            count.put(num, count.getOrDefault(num,0)+1);
            right++;
            while(count.size()>k){
                int temp=nums[left];
                count.put(temp, count.get(temp)-1);
                if(count.get(temp)==0) count.remove(temp);
                left++;

            }
            ans+=right-left;
        }
        return ans;
    }
}