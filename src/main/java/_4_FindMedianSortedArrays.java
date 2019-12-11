/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-25 17:09
 * @desc:
 */
public class _4_FindMedianSortedArrays {

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int s1 = nums1.length;
            int s2 = nums2.length;
            int left = (s1 + s2 + 1) / 2;
            int right = (s1 + s2 + 2) / 2;

            return (find(nums1, 0, nums2, 0, left) + find(nums1, 0, nums2, 0, right)) / 2.0;
        }

        private int find(int[] nums1, int i, int[] nums2, int j, int k) {
            if (i >= nums1.length) {
                return nums2[j + k - 1];
            }
            if (j >= nums2.length) {
                return nums1[i + k - 1];
            }
            if (k == 1) {
                return Math.min(nums1[i], nums2[j]);
            }

            int midVal1 = (i + k / 2 - 1 < nums1.length) ? nums1[i + k / 2 - 1] : Integer.MAX_VALUE;
            int midVal2 = (j + k / 2 - 1 < nums2.length) ? nums2[j + k / 2 - 1] : Integer.MAX_VALUE;
            if (midVal1 < midVal2) {
                return find(nums1, i + k / 2, nums2, j, k - k / 2);
            } else {
                return find(nums1, i, nums2, j + k / 2, k - k / 2);
            }

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        double median = solution.findMedianSortedArrays(new int[]{}, new int[]{2, 3});
        System.out.println(median);

    }


}
