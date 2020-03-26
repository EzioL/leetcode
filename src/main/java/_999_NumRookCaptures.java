/**
 * Here be dragons !
 * https://leetcode-cn.com/problems/available-captures-for-rook/
 *
 * @author: Ezio
 * created on 2020/3/26
 */
public class _999_NumRookCaptures {

    static class Solution {
        public int numRookCaptures(char[][] board) {

            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};

            int cnt = 0, st = 0, ed = 0;
            for (int i = 0; i < 8; ++i) {
                for (int j = 0; j < 8; ++j) {
                    if (board[i][j] == 'R') {
                        st = i;
                        ed = j;
                        break;
                    }
                }
            }

            for (int i = 0; i < 4; ++i) {
                for (int step = 0; ; ++step) {
                    int tx = st + step * dx[i];
                    int ty = ed + step * dy[i];
                    if (tx < 0 || tx >= 8 || ty < 0 || ty >= 8 || board[tx][ty] == 'B') {
                        break;
                    }
                    if (board[tx][ty] == 'p') {
                        cnt++;
                        break;
                    }
                }
            }
            return cnt;
        }
    }

    public static void main(String[] args) {
        char[][] board = {
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', 'R', '.', '.', '.', 'p'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', 'p', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.'}};
        Solution solution = new Solution();
        int res = solution.numRookCaptures(board);
        System.out.println(res);
    }


}
