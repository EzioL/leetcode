import java.util.*;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/21
 */
public class _365_CanMeasureWater {

    // 深度优先
    static class Solution {
        public boolean canMeasureWater(int x, int y, int z) {

            if (z == 0) {
                return true;
            }
            if (x + y < z) {
                return false;
            }
            Queue<Map.Entry<Integer, Integer>> queue = new ArrayDeque<>();
            queue.add(new AbstractMap.SimpleEntry<>(0, 0));
            Set<AbstractMap.SimpleEntry<Integer, Integer>> visited = new HashSet<>();
            while (!queue.isEmpty()) {
                AbstractMap.SimpleEntry<Integer, Integer> pair = (AbstractMap.SimpleEntry<Integer, Integer>) queue.poll();
                int curX = pair.getKey();
                int curY = pair.getValue();
                if (curX == z || curY == z || curX + curY == z) {
                    return true;
                }
                if (visited.contains(pair)) {
                    continue;
                }
                visited.add(pair);
                // 把x壶填满
                queue.add(new AbstractMap.SimpleEntry<>(x, curY));
                // 把y壶填满
                queue.add(new AbstractMap.SimpleEntry<>(curX, y));
                // 把x壶倒空
                queue.add(new AbstractMap.SimpleEntry<>(0, curY));
                // 把y壶倒空
                queue.add(new AbstractMap.SimpleEntry<>(curX, 0));
                //x壶的水灌进y壶，直至灌满或倒空。
                queue.add(new AbstractMap.SimpleEntry<>(curX - Math.min(curX, y - curY), curY + Math.min(curX, y - curY)));
                //y壶的水灌进x壶，直至灌满或倒空。
                queue.add(new AbstractMap.SimpleEntry<>(curX + Math.min(curY, x - curX), curY - Math.min(curY, x - curX)));

            }
            return false;

        }
    }

    //数学 贝祖定律
    static class Solution2 {
        public boolean canMeasureWater(int x, int y, int z) {
            if (x + y < z) {
                return false;
            }
            if (x == 0 || y == 0) {
                return z == 0 || x + y == z;
            }

            return z % gcd(x, y) == 0;
        }

        int gcd(int a, int b) {
            if (a < b) {
                int t = a;
                a = b;
                b = t;
            }
            int k = a % b;
            while (k > 0) {
                a = b;
                b = k;
                k = a % b;
            }
            return b;
        }

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Solution2 solution2 = new Solution2();

        System.out.println(solution.canMeasureWater(2, 6, 5));
        System.out.println(solution2.canMeasureWater(2, 6, 5));
        System.out.println(solution2.canMeasureWater(3, 5, 4));
    }
}
