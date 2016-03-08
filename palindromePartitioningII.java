public class Solution {
    public int minCut(String s) {
        int[] times = new int[s.length() + 1];
        for (int i = 0; i <= s.length() ; i++) {
            times[i] = -1;
        }

        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j || s.charAt(i) == s.charAt(j) && 
                    (i == j - 1 || isPalindrome[i + 1][j - 1])) {
                    isPalindrome[i][j] = true;
                    if (times[i] == -1 || times[j + 1] + 1 < times[i]) {
                        times[i] = times[j + 1] + 1;
                    }
                }
            }
        }
        return times[0];
    }
}