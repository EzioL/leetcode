/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-28 17:17
 * @desc:
 */
public class _7_Reverse {

    static class Solution {
        public int reverse(int x) {
            int rev = 0;
            while (x != 0) {
                int pop = x % 10;
                x = x / 10;
                if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > Integer.MAX_VALUE % 10)) {
                    return 0;
                }
                if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < Integer.MIN_VALUE % 10)) {
                    return 0;
                }
                rev = rev * 10 + pop;
            }
            return rev;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reverse(-123));


    }
}
