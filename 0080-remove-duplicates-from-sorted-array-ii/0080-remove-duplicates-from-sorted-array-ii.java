class Solution {
  public int removeDuplicates(int[] nums) {
        List<Integer> firstList = new ArrayList<>();
        List<Integer> secondList = new ArrayList<>();

        int index = 0;

        for (int i = 0; i < nums.length; i++) {
            if (firstList.contains(nums[i]) && secondList.contains(nums[i])) {
                continue;
            }

            if (firstList.contains(nums[i]) && !secondList.contains(nums[i])) {
                secondList.add(nums[i]);
            }

            if (!firstList.contains(nums[i])) {
                firstList.add(nums[i]);
            }

            nums[index++] = nums[i];
        }

        return index;
    }
}