public class KLargest215 {

    public int findKthLargest(int[] nums, int k) {
        return findKthLargest(nums, 0, nums.length - 1, k);
    }

    private int findKthLargest(int[] nums, int start, int iPivot, int k) {
        int pivot = nums[iPivot];
        int j = iPivot - 1;
        int i;
        for (i = start; i < iPivot; i++) {
            if (nums[i] < pivot) {
                while (nums[j] < pivot && j > i) {
                    j--;
                }
                if (i == j) {
                    nums[iPivot] = nums[i];
                    break;
                } else {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        if (i == k - 1) {
            return pivot;
        } else {
            return k <= i ? findKthLargest(nums, start, i - 1, k) : findKthLargest(nums, i + 1, iPivot, k);
        }
    }

}
