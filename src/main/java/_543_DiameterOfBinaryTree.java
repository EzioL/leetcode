import javax.swing.tree.TreeNode;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/10
 */
public class _543_DiameterOfBinaryTree {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    static class Solution {
        int res = 0;

        public int diameterOfBinaryTree(TreeNode root) {
            dfs(root);
            return res;
        }

        public int dfs(TreeNode root) {
            if (root == null) {
                return 0;
            }
            int leftDepth = dfs(root.left);
            int rightDepth = dfs(root.right);
            res = Math.max(res, leftDepth + rightDepth);
            return Math.max(leftDepth, rightDepth) + 1;
        }


    }
}
