import java.util.*;

class Solution {
    private Set<Integer> numSet;
    private Set<Integer> visited;
    
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        numSet = new HashSet<>();
        visited = new HashSet<>();
        
        for (int num : nums) numSet.add(num);

        int maxLen = 0;
        for (int num : numSet) {
            if (!visited.contains(num)) {  // Start DFS only for unvisited nodes
                maxLen = Math.max(maxLen, dfs(num));
            }
        }
        return maxLen;
    }
    
    private int dfs(int num) {
        if (!numSet.contains(num) || visited.contains(num)) return 0;
        
        visited.add(num); // Mark as visited
        
        return 1 + dfs(num + 1) + dfs(num - 1); // Explore both directions
    }
}
