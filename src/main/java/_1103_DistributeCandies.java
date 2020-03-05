/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/5
 */
public class _1103_DistributeCandies {

    static class Solution {
        public int[] distributeCandies(int candies, int num_people) {
            if (candies == 0 || num_people == 0) {
                return new int[0];
            }

            int flag = 0;
            int[] result = new int[num_people];
            while (candies > 0) {
                for (int i = 0; i < num_people; i++) {
                    int add = Math.min(candies, (i + 1) + flag * num_people);
                    if (flag == 0) {
                        result[i] = add;
                    } else {
                        result[i] = result[i] + add;
                    }
                    candies = candies - add;
                }
                flag++;
            }
            return result;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        System.out.println(solution.distributeCandies(7, 4));
        System.out.println(solution.distributeCandies(2, 3));


    }


}
