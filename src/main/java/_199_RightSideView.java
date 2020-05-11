import java.util.ArrayList;
import java.util.List;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/5/7
 */
public class _199_RightSideView {

    class Solution {

        List<Integer> res = new ArrayList<>();

        public List<Integer> rightSideView(TreeNode root) {

            dfs(root, 0);
            return res;
        }

        private void dfs(TreeNode root, int depth) {
            if (root == null) {
                return;
            }
            if (depth == res.size()) {
                res.add(root.val);
            }
            depth++;
            dfs(root.right, depth);
            dfs(root.left, depth);
        }

    }

}
