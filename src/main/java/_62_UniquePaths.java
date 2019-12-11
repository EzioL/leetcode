/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-28 19:34
 * @desc:
 */
public class _62_UniquePaths {

    static class Solution {
        public int uniquePaths(int m, int n) {
            if (m < 0 || n < 0) {
                return 0;
            }
            int[][] dp = new int[m][n];

            for (int i = 0; i < m; i++) {
                dp[i][0] = 1;
            }

            for (int i = 0; i < n; i++) {
                dp[0][i] = 1;
            }

            for (int i = 1; i < m; i++) {
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }


            return dp[m - 1][n - 1];
        }
    }

    public static void main(String[] args) {


        Solution solution = new Solution();

        System.out.println(solution.uniquePaths(1,1));
    }


}
