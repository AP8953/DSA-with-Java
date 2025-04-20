class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;

        for (int ans : answers) {
            map.put(ans, map.getOrDefault(ans, 0) + 1);
        }

        for (int x : map.keySet()) {
            int count = map.get(x);
            int groupSize = x + 1;
            // Calculate how many groups needed and multiply by group size
            int groups = (count + x) / groupSize;
            res += groups * groupSize;
        }

        return res;
    }
}
