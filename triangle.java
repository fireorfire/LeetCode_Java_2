public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size() == 0) {
            return 0;
        }

        for (int i = 1; i < triangle.size(); i++) {
            List<Integer> currList = triangle.get(i);
            List<Integer> lastList = triangle.get(i - 1);
            currList.set(0, currList.get(0) + lastList.get(0));
            currList.set(i, currList.get(i) + lastList.get(i - 1));
            for (int j = 1; j < i; j++) {
                currList.set(j, 
                    currList.get(j) + Math.min(lastList.get(j - 1), lastList.get(j)));
            }
        }

        List<Integer> bottomList = triangle.get(triangle.size() - 1);
        int min = bottomList.get(0);
        for (int i = 1; i < bottomList.size(); i++) {
            if (min > bottomList.get(i)) {
                min = bottomList.get(i);
            }
        }

        return min;
    }
}