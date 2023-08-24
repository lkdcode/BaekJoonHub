class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int arrIndex = 0;

        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] != 0) {
                arr[arrIndex++] = nums1[i];
            }
        }

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] != 0) {
                arr[arrIndex++] = nums2[i];
            }
        }

        Arrays.sort(arr);

        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = arr[i];
        }

    }
}