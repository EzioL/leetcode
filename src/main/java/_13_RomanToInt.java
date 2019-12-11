import java.util.HashMap;
import java.util.Map;

/**
 * @creed: Here be dragons !
 * @author: EzioQAQ
 * @Time: 2019/11/29 6:16 下午
 */
public class _13_RomanToInt {

    static class Solution {
        public int romanToInt(String s) {

            Map<String, Integer> map = new HashMap<String, Integer>();
            map.put("M", 1000);
            map.put("D", 500);
            map.put("C", 100);
            map.put("L", 50);
            map.put("X", 10);
            map.put("V", 5);
            map.put("I", 1);

            char[] chars = s.toCharArray();
            int sum = 0;
            int preNum = 0;

            for (char c : chars) {
                int num = map.get(String.valueOf(c));
                sum = sum + num;

                if ((preNum != 0 && num > preNum)) {
                    //不是第一次进入  当前值大于pre  减去pre的2倍
                    sum = sum - preNum * 2;
                }

                preNum = num;
            }

            return sum;

        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.romanToInt("MCMXCIV"));


    }


}
