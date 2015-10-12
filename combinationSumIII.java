public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] candidates;
    int k;
    public List<List<Integer>> combinationSum3(int k, int n) {
        this.candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.k = k;
        addCandidate(n, new ArrayList<Integer>(), 0, k);
        return result;
    }
    private void addCandidate(int n, List<Integer> list, int index, int k) {
        if (k < 0) {
            return;
        }
        if (k == 0) {
            if (n == 0) {
                result.add(new ArrayList<Integer>(list));
            }
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > n) {
                break;
            }
            list.add(candidates[i]);
            addCandidate(n - candidates[i], list, i + 1, k - 1);
            list.remove(list.size() - 1);
        }
    }
}