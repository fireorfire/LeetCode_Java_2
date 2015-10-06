public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        addCandidate(target, new ArrayList<Integer>(), 0);
        return result;
    }
    private void addCandidate(int target, List<Integer> list, int index) {
        if (target == 0) {
            result.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                break;
            }
            list.add(candidates[i]);
            addCandidate(target - candidates[i], list, i);
            list.remove(list.size() - 1);
            // while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
            //     i++;
            // }
        }
    }
}