public class Solution {
    List<List<Integer>> result = new ArrayList<>();
    int[] nums;
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        this.nums = nums;
        generateSet(0, new ArrayList<Integer>());
        return result;
    }
    public void generateSet(int index, List<Integer> set) {
        if (index == nums.length) {
            result.add(new ArrayList<Integer>(set));
        } else {
            generateSet(index + 1, set);
            set.add(nums[index]);
            generateSet(index + 1, set);
            set.remove(set.size() - 1);
        }
    }
}