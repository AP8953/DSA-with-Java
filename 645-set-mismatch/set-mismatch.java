class Solution {
    public int[] findErrorNums(int[] nums) {
        int sum = 0;
        int actualSum = nums.length * (nums.length + 1) / 2;
        boolean[] seen = new boolean[nums.length + 1];  // Track seen numbers
        int duplicate = 0;
        
        for (int num : nums) {
            sum += num;
            if (seen[num]) duplicate = num;
            seen[num] = true;
        }
        
        return new int[]{duplicate, duplicate + (actualSum - sum)};
    }
}
