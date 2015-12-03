public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            while (j < nums.length && nums[j] == nums[j - 1] + 1) {
                j++;
            }
            StringBuilder sb = new StringBuilder();
            sb.append(nums[i]);
            if (i != (j - 1)) {
                sb.append("->");
                sb.append(nums[j - 1]);
            }
            result.add(sb.toString());
            i = j;
        }
        return result;
    }
}