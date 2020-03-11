/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/11
 */
public class _1013_CanThreePartsEqualSum {

    static class Solution {
        public boolean canThreePartsEqualSum(int[] A) {
            if (A.length < 3) {
                return false;
            }
            int sum = 0;
            for (int value : A) {
                sum += value;
            }
            if (sum % 3 > 0) {
                return false;
            }
            int c = 0;
            int f = 0;

            for (int value : A) {
                c += value;
                if (c == sum / 3) {
                    f++;
                    c = 0;
                }
            }

            return f >= 3;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.canThreePartsEqualSum(new int[]{10, -10, 10, -10, 10, -10, 10, -10}));
    }


}
