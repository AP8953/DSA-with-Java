class Solution {
    public int countPairs(int[] nums, int k) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;

        // Group indices by value
        for (int i = 0; i < nums.length; i++) {
            map.computeIfAbsent(nums[i], x -> new ArrayList<>()).add(i);
        }

        // For each group of same value, check valid index pairs
        for (List<Integer> indices : map.values()) {
            for (int i = 0; i < indices.size(); i++) {
                for (int j = i + 1; j < indices.size(); j++) {
                    if ((indices.get(i) * indices.get(j)) % k == 0) {
                        count++;
                    }
                }
            }
        }

        return count;
    }

}