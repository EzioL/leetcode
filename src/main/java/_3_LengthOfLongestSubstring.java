/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-25 16:34
 * @desc:
 */
public class _3_LengthOfLongestSubstring {
    static class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.isEmpty()) {
                return 0;
            }
            if (s.length() == 1) {
                return 1;
            }

            int k = 0;
            int max = 1;

            for (int i = 0; i < s.length(); i++) {

                for (int j = k; j < i; j++) {
                    if (s.charAt(i) == s.charAt(j)) {
                        k = j + 1;
                        break;
                    }
                }
                if (i - k + 1 > max) {
                    System.out.println(i + "-" + k);
                    max = i - k + 1;
                }
            }

            return max;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int max = solution.lengthOfLongestSubstring("abcabcbb");
        System.out.println(max);


    }


}
