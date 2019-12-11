/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-28 18:39
 * @desc:
 */
public class _9_IsPalindrome {

    static class Solution {
        public boolean isPalindrome(int x) {
            if (x < 0) {
                return false;
            }
            if (x == 0) {
                return true;
            }
            int x1 = x;
            int r = 0;
            while (x > 0) {
                int i = x % 10;
                x = x / 10;
                r = r* 10 + i ;
            }
            return r  == x1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.isPalindrome(213);

    }


}
