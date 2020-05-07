import java.util.*;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/5/7
 */
public class _46_Permute {


    class Solution {
        public List<List<Integer>> permute(int[] nums) {

            List<List<Integer>> res = new ArrayList<>();
            boolean[] used = new boolean[nums.length];
            Deque<Integer> path = new ArrayDeque<>();
            dfs(nums, nums.length, 0, path, used, res);
            return res;

        }

        private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
            if (len == depth) {
                res.add(new ArrayList<>(path));
                return;
            }

            for (int i = 0; i < nums.length; i++) {
                if (used[i]) {
                    continue;
                }
                path.addLast(nums[i]);
                used[i] = true;
                dfs(nums, len, depth + 1, path, used, res);
                path.removeLast();
                used[i] = false;

            }

        }

    }


}
