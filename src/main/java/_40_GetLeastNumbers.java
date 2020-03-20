/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/20
 */
public class _40_GetLeastNumbers {

    static class Solution {
        public int[] getLeastNumbers(int[] arr, int k) {
            for (int i = 0; i < arr.length-1; i++) {
                for (int j = 0; j < arr.length - i-1; j++) {
                    if (arr[j] > arr[j + 1]) {
                        int t = arr[j];
                        arr[j] = arr[j + 1];
                        arr[j + 1] = t;
                    }

                }
            }

            int[] ints = new int[k];
            System.arraycopy(arr, 0, ints, 0, k);
            return ints;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getLeastNumbers(new int[]{3, 2, 1}, 2));

    }

}
