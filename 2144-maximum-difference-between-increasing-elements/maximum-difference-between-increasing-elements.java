class Solution {
    public int maximumDifference(int[] nums) {
        int n = nums.length;
        int max = -1;
        int leftmin = nums[0];
        for(int i=0;i<n;i++){
            int val = (nums [i]);
            if(leftmin<val){
                max=Math.max(max,val-leftmin);
            }
            leftmin = Math.min(val,leftmin);
            }
                    return max;

        }
    }