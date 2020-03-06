import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/6
 */
public class _57_FindContinuousSequence {


    static class Solution {
        public int[][] findContinuousSequence(int target) {
            // 1到target/2 直接 左右指针 滑动窗口
            int left = 1, right = 2;
            List<int[]> list = new ArrayList<int[]>();
            while (left < right && left <= target / 2) {
                // 高斯的那个求100 ，首尾项
                int sum = ((left + right) * (right - left + 1)) / 2;
                if (sum < target) {
                    right++;
                } else if (sum > target) {
                    left++;
                } else {
                    int[] ints = new int[right - left + 1];

                    int t = 0;
                    for (int i = left; i <= right; i++) {
                        ints[t] = i;
                        t++;
                    }
                    list.add(ints);
                    // 继续寻找
                    left++;
                }
            }
            int[][] result = new int[list.size()][];
            for (int i = 0; i < list.size(); i++) {
                result[i] = list.get(i);
            }
            return result;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.findContinuousSequence(9));
        System.out.println(solution.findContinuousSequence(15));
    }
}
