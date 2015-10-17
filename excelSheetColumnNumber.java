public class Solution {
    public int titleToNumber(String s) {
        int base = 1;
        int count = 0;
        char[] ch = s.toCharArray();
        for (int i = ch.length - 1; i >= 0; i--) {
            int num = ch[i] - 'A' + 1;
            num *= base;
            base *= 26;
            count += num;
        }
        return count;
    }
}