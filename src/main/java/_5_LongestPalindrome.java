/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-25 17:37
 * @desc:
 */
public class _5_LongestPalindrome {

    static class Solution {
        public String longestPalindrome(String s) {
            if (s == null || s.isEmpty()) {
                return "";
            }
            int start = 0, end = 0;
            for (int i = 0; i < s.length(); i++) {
                int len1 = expandAroundCenter(s, i, i);
                int len2 = expandAroundCenter(s, i, i + 1);
                int len = Math.max(len1, len2);
                if (len > end - start) {
                    start = i - (len - 1) / 2;
                    end = i + len / 2;
                }
            }
            return s.substring(start, end + 1);

        }

        private int expandAroundCenter(String s, int left, int right) {
            int L = left, R = right;
            while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
                L--;
                R++;
            }
            return R - L - 1;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        String s = solution.longestPalindrome("abad");
        System.out.println(s);
    }
}
