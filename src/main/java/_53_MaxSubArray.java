/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/5/5
 */
public class _53_MaxSubArray {


    static class Solution {
        public int maxSubArray(int[] nums) {
            int ans = nums[0];
            int sum = 0;
            for (int num : nums) {
                if (sum > 0) {
                    sum += num;
                } else {
                    sum = num;
                }
                ans = Math.max(ans, sum);
            }
            return ans;
        }
    }

    static class Solution2 {
        public int maxSubArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int maxAns = nums[0];
            for (int i = 1; i < nums.length; i++) {
                if (nums[i - 1] > 0) {
                    nums[i] = nums[i - 1] + nums[i];
                }
                maxAns = Math.max(maxAns, nums[i]);
            }
            return maxAns;

        }
    }

    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
