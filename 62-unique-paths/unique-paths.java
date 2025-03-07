class Solution {
    public int uniquePaths(int m, int n) {
        long res = 1;
        int k = Math.min(m - 1, n - 1); // Choose the smaller value for efficiency
        for (int i = 0; i < k; i++) {
            res = (res * (m + n - 2 - i)) / (i + 1);
            System.out.println(res);
        }
        return (int) res;
    }
}
