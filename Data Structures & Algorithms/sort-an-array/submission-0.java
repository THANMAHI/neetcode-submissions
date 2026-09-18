class Solution {
    public static void conquer(int[] arr, int l, int mid, int h) {
        int[] merged = new int[h - l + 1];

        int idx1 = l;
        int idx2 = mid + 1;
        int k = 0;

        while (idx1 <= mid && idx2 <= h) {
            if (arr[idx1] <= arr[idx2]) {
                merged[k++] = arr[idx1++];
            } else {
                merged[k++] = arr[idx2++];
            }
        }

        while (idx1 <= mid) {
            merged[k++] = arr[idx1++];
        }

        while (idx2 <= h) {
            merged[k++] = arr[idx2++];
        }

        for (int i = 0; i < merged.length; i++) {
            arr[l + i] = merged[i];
        }
    }

    public static void divide(int[] arr, int l, int h) {
        if (l >= h) {
            return;
        }

        int mid = l + (h - l) / 2;

        divide(arr, l, mid);
        divide(arr, mid + 1, h);
        conquer(arr, l, mid, h);
    }

    public int[] sortArray(int[] nums) {
        divide(nums, 0, nums.length - 1);
        return nums;
    }
}