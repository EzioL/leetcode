/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/8
 */
public class _322_CoinChange {

    private static class Solution {

        public int coinChange(int[] coins, int amount) {
            if (amount < 1) {
                return 0;
            }
            return findWay(coins, amount, new int[amount]);

        }

        public int findWay(int[] coins, int rem, int[] count) {

            if (rem < 0) {
                return -1;
            }
            if (rem == 0) {
                return 0;
            }
            if (count[rem - 1] != 0) {
                return count[rem - 1];
            }
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                int res = findWay(coins, rem - coin, count);
                if (res >= 0 && res < min) {
                    min = 1 + res;
                }
            }
            count[rem - 1] = (min == Integer.MAX_VALUE) ? -1 : min;
            return count[rem - 1];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // System.out.println(solution.coinChange(new int[]{1,2, 5}, 4));
        System.out.println(solution.coinChange(new int[]{1, 2, 5}, 100));

    }
}
