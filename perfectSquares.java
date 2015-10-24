public class Solution {
    public int numSquares(int n) {
        int[] opt = new int[n + 1];
        Arrays.fill(opt, Integer.MAX_VALUE);
        opt[0] = 0;
        for (int i = 0; i <= n; i ++) {
            for (int j = 1; Math.sqrt(n - i) >= j; j ++) {
                int jSquare = (int)Math.pow(j, 2);
                opt[i + jSquare] = Math.min(opt[i + jSquare], opt[i] + 1);
            }
        }
        return opt[n];
    }
}