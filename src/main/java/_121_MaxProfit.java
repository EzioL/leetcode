/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/9
 */
public class _121_MaxProfit {
    private static class Solution {
        public int maxProfit(int[] prices) {
            int minprice = Integer.MAX_VALUE;
            int maxprofit = 0;
            for (int price : prices) {
                if (price < minprice) {
                    minprice = price;
                } else if (price - minprice > maxprofit) {
                    maxprofit = price - minprice;
                }
            }
            return maxprofit;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7,1,5,3,6,4}));

    }
}
