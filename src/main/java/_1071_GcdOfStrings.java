/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/12
 */
public class _1071_GcdOfStrings {
    static class Solution {

        public String gcdOfStrings(String str1, String str2) {

            if (!(str1 + str2).equals(str2 + str1)) {
                return "";
            }
            int gcd = gcd(str1.length(), str2.length());

            return str1.substring(0, gcd);

        }

        private int gcd(int s1, int s2) {
            if (s2 == 0) {
                return s1;
            }
            return gcd(s2, s1 % s2);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.gcdOfStrings("ABCABC","ABC"));
        System.out.println(solution.gcdOfStrings("LEEF","CODE"));

    }

}
