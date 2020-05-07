import java.util.ArrayList;
import java.util.List;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/5/7
 */
public class _102_LevelOrder {

    class Solution {

        List<List<Integer>> levels = new ArrayList<>();

        public List<List<Integer>> levelOrder(TreeNode root) {
            if (root == null) {
                return levels;
            }
            add(root, 0);
            return levels;

        }

        private void add(TreeNode node, int level) {
            if (levels.size() == level) {
                levels.add(new ArrayList<>());
            }

            levels.get(level).add(node.val);
            if (node.left != null) {
                add(node.left, level + 1);
            }

            if (node.right != null) {
                add(node.right, level + 1);
            }
        }
    }


}
