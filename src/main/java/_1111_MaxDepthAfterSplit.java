/**
 * Here be dragons !
 * https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/
 *
 * @author: Ezio
 * created on 2020/4/1
 */
public class _1111_MaxDepthAfterSplit {

    static class Solution {
        public int[] maxDepthAfterSplit(String seq) {
            int[] ans = new int[seq.length()];
            int idx = 0;
            for (char c : seq.toCharArray()) {
                ans[idx++] = c == '(' ? idx & 1 : ((idx + 1) & 1);
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDepthAfterSplit("(()())"));
    }

}
