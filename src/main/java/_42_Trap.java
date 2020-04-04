import java.util.Stack;

/**
 * Here be dragons !
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * @author: Ezio
 * created on 2020/4/4
 */
public class _42_Trap {

    // 双指针
    static class Solution {
        public int trap(int[] height) {
            int sum = 0;
            int maxLeft = 0;
            int[] maxRight = new int[height.length];
            for (int i = height.length - 2; i >= 0; i--) {
                maxRight[i] = Math.max(maxRight[i + 1], height[i + 1]);
            }
            for (int i = 1; i < height.length - 1; i++) {
                maxLeft = Math.max(maxLeft, height[i - 1]);
                int min = Math.min(maxLeft, maxRight[i]);
                if (min > height[i]) {
                    sum = sum + (min - height[i]);
                }
            }
            return sum;
        }
    }

    // 栈
    static class Solution2 {
        public int trap(int[] height) {
            int sum = 0;
            Stack<Integer> stack = new Stack<>();
            int current = 0;
            while (current < height.length) {
                //如果栈不空并且当前指向的高度大于栈顶高度就一直循环
                while (!stack.empty() && height[stack.peek()] < height[current]) {

                    int h = height[stack.peek()]; //取出要出栈的元素
                    stack.pop(); //出栈
                    if (stack.empty()) { // 栈空就出去
                        break;
                    }
                    int distance = current - stack.peek() - 1; //两堵墙之前的距离。
                    int min = Math.min(height[stack.peek()], height[current]);
                    sum = sum + distance * (min - h);
                }
                //当前指向的墙入栈
                stack.push(current);
                //指针后移
                current++;
            }
            return sum;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));

//
//        Solution2 solution2 = new Solution2();
//        System.out.println(solution2.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

}
