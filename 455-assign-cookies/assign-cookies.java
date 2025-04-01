import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // If the cookie satisfies the child's greed
                i++; // Move to the next child
            }
            j++; // Move to the next cookie
        }
        
        return i; // Number of children that got cookies
    }
}
