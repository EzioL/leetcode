/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-28 18:51
 * @desc:
 */
public class _10_IsMatch_2 {

    static class Solution {
        public boolean isMatch(String s, String p) {

            return dp(0, 0, s, p);


        }
    }


    public static boolean dp(int i, int j, String text, String pattern) {

        return false;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.isMatch("aa", "a*"));
    }

}
