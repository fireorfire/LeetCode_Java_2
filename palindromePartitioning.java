public class Solution {
    public List<List<String>> partition(String s) {
        if (s.length() == 0) {
            return new ArrayList<List<String>>();
        }
        List<List<String>>[] palindromeBlock = new List[s.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            palindromeBlock[i] = new LinkedList<List<String>>();
        }
        palindromeBlock[s.length()].add(new ArrayList<String>());
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j ||
                    (s.charAt(i) == s.charAt(j) &&
                    (i == j - 1 || isPalindrome[i + 1][j - 1]))) {
                    isPalindrome[i][j] = true;
                    String palindrome = s.substring(i, j + 1);
                    for (List<String> list : palindromeBlock[j + 1]) {
                        List<String> nextList = new LinkedList<>(list);
                        nextList.add(0, palindrome);
                        palindromeBlock[i].add(nextList);
                    }
                }
            }
        }
        return palindromeBlock[0];
    }
}