import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2019/12/20
 */
public class _15_ThreeSum {

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {

            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (nums == null || nums.length < 3) {
                return result;
            }
            // 排序
            Arrays.sort(nums);
            return threeSum0(nums);
        }

        public List<List<Integer>> threeSum0(int[] nums) {

            List<List<Integer>> res = new ArrayList<List<Integer>>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    break;
                }
                if (i > 0 && nums[i] == nums[i - 1]) {
                    continue;
                }
                int l = i + 1, r = nums.length - 1;
                while (l < r) {
                    int sum = nums[i] + nums[l] + nums[r];
                    if (sum == 0) {
                        res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        while (l < r && nums[l] == nums[l + 1]) {
                            l++;
                        }
                        while (l < r && nums[r] == nums[r - 1]) {
                            r--;
                        }
                        l++;
                        r--;
                    } else if (sum > 0) {
                        r--;
                    } else {
                        l++;
                    }
                }
            }
            return res;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        List<List<Integer>> lists = solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);

    }
}
