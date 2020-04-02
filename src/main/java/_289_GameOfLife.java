/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/4/2
 */
public class _289_GameOfLife {
    class Solution {
        public void gameOfLife(int[][] board) {
            int[] nearX = {-1, 0, 1};
            int[] nearY = {-1, 0, 1};

            int rows = board.length;
            int cols = board[0].length;

            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    int nearLiveCount = 0;
                    for (int x : nearX) {
                        for (int y : nearY) {
                            if (x == 0 && y == 0) {
                                // 是本身
                                continue;
                            }
                            int currentX = row + x;
                            int currentY = col + y;
                            if (currentX < 0 || currentX >= rows || currentY < 0 || currentY >= cols) {
                                continue;
                            }
                            if (Math.abs(board[currentX][currentY]) == 1) {
                                nearLiveCount += 1;
                            }

                        }

                    }
                    // 规则 1 或 规则 3
                    if ((board[row][col] == 1) && (nearLiveCount < 2 || nearLiveCount > 3)) {
                        // -1 代表这个细胞过去是活的现在死了
                        board[row][col] = -1;
                    }
                    // 规则 4
                    if (board[row][col] == 0 && nearLiveCount == 3) {
                        // 2 代表这个细胞过去是死的现在活了
                        board[row][col] = 2;
                    }
                }

            }
            // 遍历 board 得到一次更新后的状态
            for (int row = 0; row < rows; row++) {
                for (int col = 0; col < cols; col++) {
                    if (board[row][col] > 0) {
                        board[row][col] = 1;
                    } else {
                        board[row][col] = 0;
                    }
                }
            }
        }
    }
}
