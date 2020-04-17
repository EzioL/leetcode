import java.util.ArrayList;
import java.util.List;

/**
 * Here be dragons !
 * https://leetcode-cn.com/problems/course-schedule/
 *
 * @author: Ezio
 * created on 2020/4/17
 */
public class _207_CanFinish {

    static class Solution {
        public boolean canFinish(int numCourses, int[][] prerequisites) {

            List<List<Integer>> adjacency = new ArrayList<>();
            for (int i = 0; i < numCourses; i++) {
                adjacency.add(new ArrayList<>());
            }
            for (int[] cp : prerequisites) {
                adjacency.get(cp[1]).add(cp[0]);
            }
            int[] flags = new int[numCourses];
            for (int i = 0; i < numCourses; i++) {
                if (!dfs(adjacency, flags, i)) {
                    return false;
                }
            }

            return true;
        }

        private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
            if (flags[i] == 1) {
                return false;
            }
            if (flags[i] == -1) {
                return true;
            }
            flags[i] = 1;
            for (Integer j : adjacency.get(i)) {
                if (!dfs(adjacency, flags, j)) {
                    return false;
                }
            }
            flags[i] = -1;
            return true;
        }

    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.canFinish(2,new int[][]{{1,0}}));

    }
}
