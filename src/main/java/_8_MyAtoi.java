import java.util.regex.Matcher;
import java.util.regex.Pattern;

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


    static class Solution {
        public int myAtoi(String str) {
            if (null == str || str.trim().length() == 0) {
                return 0;
            }
            char[] chars = str.trim().toCharArray();

            int negative = 1;
            int idx = 0;
            if (chars[0] == '-') {
                negative = -1;
                idx++;
            } else if (chars[idx] == '+') {
                idx++;
            } else if (!Character.isDigit(chars[idx])) {
                // 其他符号
                return 0;
            }
            int ans = 0;
            while (idx < chars.length && Character.isDigit(chars[idx])) {
                int digit = chars[idx] - '0';
                if (ans > (Integer.MAX_VALUE - digit) / 10) {
                    return negative < 0 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                ans = ans * 10 + digit;
                idx++;
            }
            return ans * negative;
        }
    }


    public static void main(String[] args) {
        String s = " 123 ";
        System.out.println(s.trim());
        System.out.println(Character.isDigit("1".toCharArray()[0]));
    }

}
