public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<Integer>());
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> nextResult = new ArrayList<>();
            for (int j = 0; j < result.size(); j++) {
                for (int k = 0; k <= i; k++) {
                    List<Integer> list = new ArrayList<>(result.get(j));
                    list.add(k, nums[i]);
                    nextResult.add(list);
                }
            }
            result = nextResult;
        }
        return result;
    }
}