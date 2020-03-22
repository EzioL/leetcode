import java.util.Arrays;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/22
 */
public class _945_MinIncrementForUnique {

    static class Solution {
        public int minIncrementForUnique(int[] A) {
            int[] count = new int[80000];
            for (int x : A) {
                count[x]++;
            }

            int ans = 0, taken = 0;

            for (int x = 0; x < 80000; ++x) {
                if (count[x] >= 2) {
                    taken += count[x] - 1;
                    ans -= x * (count[x] - 1);
                } else if (taken > 0 && count[x] == 0) {
                    taken--;
                    ans += x;
                }
            }

            return ans;
        }
    }

    static class Solution2 {
        public int minIncrementForUnique(int[] A) {

            Arrays.sort(A);
            int move = 0;
            // 遍历数组，若当前元素小于等于它的前一个元素，则将其变为前一个数+1
            for (int i = 1; i < A.length; i++) {
                if (A[i] <= A[i - 1]) {
                    int pre = A[i];
                    A[i] = A[i - 1] + 1;
                    move += A[i] - pre;
                }
            }
            return move;
        }
    }


}
