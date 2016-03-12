public class TwoSortedArraysMedian4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] small, big;
        if (nums1.length > nums2.length) {
            small = nums2;
            big = nums1;
        } else {
            small = nums1;
            big = nums2;
        }
        int half = (small.length + big.length) / 2;
        int c1 = findCut(small, big, 0, small.length, half);
        int c2 = half - c1;
        if (c2 == big.length) {
            return ((double) big[c2 - 1] + small[0]) / 2;
        }
        if ((small.length + big.length) % 2 == 0) {
            int m1 = c2 == 0 || (c1 > 0 && small[c1 - 1] > big[c2 - 1]) ? small[c1 - 1] : big[c2 - 1];
            int m2 = c1 < small.length && small[c1] < big[c2] ? small[c1] : big[c2];
            return ((double) m1 + m2) / 2;
        } else {
            return c1 < small.length && small[c1] < big[c2] ? small[c1] : big[c2];
        }
    }

    private int findCut(int[] small, int[] big, int lcut, int rcut, int size) {
        if (lcut == rcut) return lcut;
        int check = (lcut + rcut) / 2;
        if (small[check] <= big[size - (check - lcut + 1)]) {
            int moreToLeft = size - (check - lcut + 1);
            if (moreToLeft == 0) {
                return check + 1;
            } else {
                return findCut(small, big, check + 1, rcut, moreToLeft);
            }
        } else {
            return findCut(small, big, lcut, check, size);
        }
    }

}
