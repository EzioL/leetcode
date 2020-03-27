import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/27
 */
public class _914_HasGroupsSizeX {

    static class Solution {
        public boolean hasGroupsSizeX(int[] deck) {
            // 计数
            int[] counter = new int[10000];
            for (int num : deck) {
                counter[num]++;
            }
            // 求最大公约数
            return Arrays.stream(counter).reduce(this::gcd).getAsInt() > 1;
        }

        private int gcd(int a, int b) {
            return b == 0 ? a : gcd(b, a % b);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1}));
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 2, 1, 2, 2, 2}));
        System.out.println(solution.hasGroupsSizeX(new int[]{1, 1, 1, 1, 2, 2, 2, 2, 2, 2}));
    }

}
