import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Here be dragons !
 * https://leetcode-cn.com/problems/merge-intervals/
 *
 * @author: Ezio
 * created on 2020/5/5
 */
public interface _56_Merge {

    static class Solution {

        public int[][] merge2(int[][] intervals) {
            int len = intervals.length;
            if (len < 1) {
                return intervals;
            }
            Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));

            List<int[]> list = new ArrayList<>(len);
            for (int i = 0; i < len - 1; i++) {
                if (intervals[i][1] >= intervals[i + 1][0]) {
                    intervals[i + 1][0] = intervals[i][0];
                    intervals[i + 1][1] = Math.max(intervals[i + 1][1], intervals[i][1]);
                } else {
                    list.add(intervals[i]);
                }
            }
            // 别忘了最后一个
            list.add(intervals[len - 1]);
            return list.toArray(new int[list.size()][2]);
        }


        public int[][] merge(int[][] intervals) {
            // 先按照区间起始位置排序
            Arrays.sort(intervals, Comparator.comparingInt(v -> v[0]));
            // 遍历区间
            int[][] res = new int[intervals.length][2];
            int idx = -1;
            for (int[] interval : intervals) {
                // 如果结果数组是空的，或者当前区间的起始位置 > 结果数组中最后区间的终止位置，
                // 则不合并，直接将当前区间加入结果数组。
                if (idx == -1 || interval[0] > res[idx][1]) {
                    res[++idx] = interval;
                } else {
                    // 反之将当前区间合并至结果数组的最后区间
                    res[idx][1] = Math.max(res[idx][1], interval[1]);
                }
            }
            return Arrays.copyOf(res, idx + 1);
        }
    }


    public static void main(String[] args) {
        int[][] ints = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};

        Solution solution = new Solution();
        int[][] merge = solution.merge2(ints);
        System.out.println(merge);


    }

}
