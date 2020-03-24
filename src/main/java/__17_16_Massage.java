/**
 * Here be dragons !
 * 题目地址：https://leetcode-cn.com/problems/the-masseuse-lcci/
 *
 * @author: Ezio
 * created on 2020/3/24
 */
public class __17_16_Massage {
    static class Solution {
        public int massage(int[] nums) {
            int n = nums.length;
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return nums[0];
            }
            //dp[i] = max(dp[i - 1], dp[i - 2] + nums[i])
            int[] dp = new int[n];
            dp[0] = nums[0];
            dp[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < n; i++) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
            }
            return dp[n - 1];
        }
    }

    static class Solution2 {
        public int massage(int[] nums) {
            int a = 0, b = 0;
            for (int num : nums) {
                int c = Math.max(b, a + num);
                a = b;
                b = c;
            }
            return b;

        }
    }

}
