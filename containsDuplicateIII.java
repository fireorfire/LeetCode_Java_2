public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) {
            return false;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i ++) {
            long num = nums[i];
            Integer top = map.floorKey(nums[i]);
            while (top != null && Math.abs(top - num) <= t) {
                int index = map.get(top);
                if (Math.abs(index - i) <= k) {
                    return true;
                }
                map.remove(top);
                top = map.floorKey(nums[i]);
            }
            Integer bottom = map.ceilingKey(nums[i]);
            while (bottom != null && Math.abs(bottom - num) <= t) {
                int index = map.get(bottom);
                if (Math.abs(index - i) <= k) {
                    return true;
                }
                map.remove(bottom);
                bottom = map.ceilingKey(nums[i]);
            }
            map.put(nums[i], i);
        }
        return false;
    }
}