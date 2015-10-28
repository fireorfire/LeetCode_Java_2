public class Solution {
    public void moveZeroes(int[] nums) {
        int start = 0;
        while (start < nums.length && nums[start] != 0) {
            start ++;
        }
        int index = start + 1;
        while (index < nums.length) {
            if (nums[index] != 0) {
                nums[start] = nums[index];
                nums[index] = 0;
                start ++;
            }
            index ++;
        }
    }
}