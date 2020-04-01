import java.util.Stack;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/4/1
 */
public class _20_IsValid {

    static class Solution {
        public boolean isValid(String s) {
            if (s.isEmpty()) {
                return true;
            }
            if (s.length() % 2 > 0) {
                return false;
            }
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(') {
                    stack.push(')');
                } else if (c == '{') {
                    stack.push('}');
                } else if (c == '[') {
                    stack.push(']');
                } else if (stack.empty() || c != stack.pop()) {
                    return false;
                }
            }
            return stack.empty();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
    }

}
