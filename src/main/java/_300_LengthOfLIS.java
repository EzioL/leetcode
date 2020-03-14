import java.util.Arrays;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/14
 */
public class _300_LengthOfLIS {

    static class Solution {
        public int lengthOfLIS(int[] nums) {
            if (nums.length < 2) {
                return nums.length;
            }

            int[] dp = new int[nums.length];
            Arrays.fill(dp, 1);
            for (int i = 1; i < nums.length; i++) {
                // 看以前的，比它小的，说明可以接在后面形成一个更长的子序列
                // int curMax = Integer.MIN_VALUE; 不能这样写，万一前面没有比自己小的，
                // 这个值就得不到更新
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) {
                        dp[i] = Math.max(dp[j] + 1, dp[i]);
                    }
                }
            }
            int max = dp[0];
            for (int i = 0; i < nums.length; i++) {
                max = Math.max(max, dp[i]);
            }
            return max;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}));
    }
}
