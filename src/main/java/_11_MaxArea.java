/**
 * @creed: Here be dragons !
 * @author: EzioQAQ
 * @Time: 2019/11/29 5:40 下午
 */
public class _11_MaxArea {

    class Solution {
        public int maxArea(int[] height) {

            int max = 0;
            for (int i = 0; i < height.length; i++) {
                for (int j = i + 1; j < height.length; j++) {
                    max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
                }
            }
            return max;

        }
    }
}
