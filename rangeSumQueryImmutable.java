public class NumArray {

    private int[] count;
    private int[] nums;
    public NumArray(int[] nums) {
        this.nums = nums;
        if (nums.length == 0) {
            count = null;
            return;
        }
        count = new int[nums.length];
        count[0] = nums[0];
        for (int i = 1; i < nums.length; i ++) {
            count[i] = count[i - 1] + nums[i];
        }
    }

    public int sumRange(int i, int j) {
        if (count == null) {
            return 0;
        }
        return count[j] - count[i] + nums[i];
    }
}


// Your NumArray object will be instantiated and called as such:
// NumArray numArray = new NumArray(nums);
// numArray.sumRange(0, 1);
// numArray.sumRange(1, 2);