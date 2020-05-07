import java.util.Arrays;

/**
 * Here be dragons !
 * https://leetcode-cn.com/problems/house-robber-ii/
 *
 * @author: Ezio
 * created on 2020/5/7
 */
public class _213_Rob {

    static class Solution {
        public int rob(int[] nums) {

            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }
            int i = rob0(Arrays.copyOfRange(nums, 0, nums.length - 1));
            int i1 = rob0(Arrays.copyOfRange(nums, 1, nums.length));
            return Math.max(i, i1);

        }

        private int rob0(int[] nums) {
            int pre = 0, cur = 0, tmp;
            for (int num : nums) {
                tmp = cur;
                cur = Math.max(pre + num, cur);
                pre = tmp;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.rob(new int[]{1, 2, 3, 1}));
    }
}
