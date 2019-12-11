/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-28 18:51
 * @desc:
 */
public class _10_IsMatch {

    static class Solution {
        public boolean isMatch(String s, String p) {
            memo = new Result[s.length() + 1][p.length() + 1];
            return dp(0, 0, s, p);
        }
    }

    static Result[][] memo;

    enum Result {TRUE, FALSE}

    public static boolean dp(int i, int j, String text, String pattern) {
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()) {
            ans = (i == text.length());
        } else {
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) || pattern.charAt(j) == '.')
            );

            if (j + 1 < pattern.length() && pattern.charAt(j + 1) == '*') {
                ans = (dp(i, j + 2, text, pattern) ||
                        first_match && dp(i + 1, j, text, pattern));
            } else {
                ans = first_match && dp(i + 1, j + 1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.isMatch("aa","a*"));
    }

}
