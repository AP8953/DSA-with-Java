import java.util.HashMap;

class Solution {
    public int numRabbits(int[] answers) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int result = 0;

        for (int x : answers) {
            if (!map.containsKey(x) || map.get(x) == 0) {
                result += x + 1;
                map.put(x, x);
            } else {
                map.put(x, map.get(x) - 1);
            }
        }

        return result;
    }
}
