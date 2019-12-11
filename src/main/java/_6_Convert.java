import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-25 18:37
 * @desc:
 */
public class _6_Convert {
    static class Solution {
        public String convert(String s, int numRows) {

            if (numRows < 2) {
                return s;
            }
            List<StringBuilder> rows = new ArrayList<StringBuilder>();
            for (int i = 0; i < numRows; i++) {
                rows.add(new StringBuilder());
            }
            // 默认方向 下
            int i = 0, flag = -1;
            for (char c : s.toCharArray()) {
                rows.get(i).append(c);
                if (i == 0 || i == numRows - 1) {
                    flag = -flag;
                }
                i = i + flag;
            }
            StringBuilder res = new StringBuilder();
            for (StringBuilder row : rows) {
                res.append(row);
            }
            return res.toString();

        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.convert("LEETCODEISHIRING", 4));
    }


}
