class Solution {
  public int removeElement(int[] nums, int val) {
        int result = 0;

        for (int num : nums) {
            if (num != val) {
                nums[result++] = num;
            }
        }

        return result;
    }
}