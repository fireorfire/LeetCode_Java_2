public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        int n = matrix.length;
        if (n == 0) {
            return;
        }
        int m = matrix[0].length;
        if (m == 0) {
            return;
        }
        for (int i = 0; i < n; i ++) {
            if (matrix[i][0] == 0) {
                rowZero = true;
            }
        }
        for (int i = 0; i < n; i ++) {
            for (int j = 1; j < m; j ++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = n - 1; i >= 0; i --) {
            for (int j = m - 1; j >= 1; j --) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (rowZero) {
                matrix[i][0] = 0;
            }
        }
    }
}