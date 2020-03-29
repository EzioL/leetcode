import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/29
 */
public class _1162_MaxDistance {

    static class Solution {
        public int maxDistance(int[][] grid) {


            Queue<int[]> queue = new ArrayDeque<>();
            int m = grid.length, n = grid[0].length;
            // 先把所有的陆地都入队。
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (grid[i][j] == 1) {
                        queue.offer(new int[]{i, j});
                    }
                }
            }
            // 从各个陆地开始，一圈一圈的遍历海洋，最后遍历到的海洋就是离陆地最远的海洋。
            int[] dx = {0, 0, 1, -1};
            int[] dy = {1, -1, 0, 0};
            boolean hasOcean = false;
            int rX = 0, rY = 0;
            while (!queue.isEmpty()) {
                int[] point = queue.poll();
                rX = point[0];
                rY = point[1];
                // 取出队列的元素，将其四周的海洋入队。
                for (int i = 0; i < 4; i++) {
                    int newX = rX + dx[i];
                    int newY = rY + dy[i];
                    if (newX < 0 || newY < 0 || newX >= m || newY >= n || grid[newX][newY] != 0) {
                        continue;
                    }
                    grid[newX][newY] = grid[rX][rY] + 1;
                    hasOcean = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
            return hasOcean ? grid[rX][rY] - 1 : -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDistance(new int[][]{{1, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }
}
