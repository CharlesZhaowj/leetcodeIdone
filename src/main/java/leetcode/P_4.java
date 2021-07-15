package leetcode;

public class P_4 {
    public static double findKth(int[] a, int begina, int m, int[] b, int beginb, int n, int k) {
        if (m > n) {
           return findKth(b, beginb, n, a, begina, m, k);
        }
        if (m == 0) {
            return b[beginb + k - 1];
        }
        if (k == 1) {
            return Math.min(a[begina], b[beginb]);
        }
        // 将k对半分
        int ma = Math.min(k / 2, m), mb = k - ma;
        if(a[begina + ma - 1] < b[beginb + mb - 1]) {
            return findKth(a, begina+ma, m-ma, b, beginb, n, k-ma);
        } else if(a[begina + ma -1] > b[beginb+mb-1]) {
            return findKth(a, begina, m, b, beginb+mb, n-mb, k-mb);
        } else {
            return a[begina+ma-1];
        }
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int length = nums1.length + nums2.length;
        if(length % 2 == 1) {
            return findKth(nums1, 0, m, nums2,0, n, length/2 + 1);
        } else {
            return (findKth(nums1, 0, m, nums2,0, n, length/2)
                    + findKth(nums1, 0, m, nums2,0, n, length/2+1)) / 2;
        }
    }

    public static void main(String[] args) {

    }
}
