/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-25 17:56
 * @desc:
 */
public class _70_ClimbStairs {

    static class Solution {
        public int climbStairs(int n) {
            if (n == 1) {
                return 1;
            }
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.climbStairs(4));
        System.out.println(solution.climbStairs(5));


    }


}
