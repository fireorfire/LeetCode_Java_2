public class Solution {
    public int hIndex(int[] citations) {
        int len = citations.length;
        if (len == 0) {
            return 0;
        }
        int[] count = new int[len + 1];
        for (int citation : citations) {
            if (citation > len) {
                count[len] ++;
            } else {
                count[citation] ++;
            }
        }
        int total = 0;
        for (int i = len; i >= 0; i--) {
            total += count[i];
            if (total >= i) {
                return i;
            }
        }
        return 0;
    }
}