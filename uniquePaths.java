public class Solution {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) return 0;
        int[] paths = new int[n];
        for (int i = 0; i < n; i++) {
            paths[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[j] += paths[j - 1];
            }
        }
        return paths[n - 1];
    }
}