

/**
 * @creed: Here be dragons !
 * @author: Ezio
 * @Time: 2019-11-28 17:44
 * @desc:
 */
public class _8_MyAtoi {

    public int myAtoi(String str) {
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }
        int i = 0;
        //2.判断数字的符号
        int flag = 1;
        char ch = str.charAt(i);
        if (ch == '+') {
            i++;
        } else if (ch == '-') {
            flag = -1;
            i++;
        }
        //3.找出数字部分
        int res = 0;
        for (; i < str.length(); i++) {
            ch = str.charAt(i);
            if (ch < '0' || ch > '9') {
                break;
            }
            int x = ch - '0';
            //溢出判断
            if (flag > 0 && res > Integer.MAX_VALUE / 10) {
                return Integer.MAX_VALUE;
            }
            if (flag > 0 && res == Integer.MAX_VALUE / 10 && x > Integer.MAX_VALUE % 10) {
                return Integer.MAX_VALUE;
            }
            if (flag < 0 && -res < Integer.MIN_VALUE / 10) {
                return Integer.MIN_VALUE;
            }
            if (flag < 0 && -res == Integer.MIN_VALUE / 10 && -(x) < Integer.MIN_VALUE % 10) {
                return Integer.MIN_VALUE;
            }
            res = res * 10 + x;
        }
        return res * flag;

    }

}
