/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/16
 */
public class _01_06_CompressString {

    static class Solution {
        public String compressString(String S) {
            if (S == null) {
                return null;
            }
            if (S.trim().length() == 0) {
                return "";
            }
            char c = S.charAt(0);
            int f = 0;
            StringBuilder r = new StringBuilder();
            for (int i = 0; i < S.length(); i++) {
                char s = S.charAt(i);
                if (i == 0) {
                    c = s;
                    f = 1;
                } else {
                    if (s == c) {
                        f++;
                    } else {
                        r.append(c).append(f);
                        f = 1;
                        c = s;
                    }
                }
            }

            if (f > 0) {
                r.append(c).append(f);
            }
            if (r.toString().length() >= S.length()) {
                return S;
            }

            return r.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.compressString("aabcccccaaa"));
        System.out.println(solution.compressString("abbccd"));
    }

}
