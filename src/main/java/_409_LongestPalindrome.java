import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/19
 */
public class _409_LongestPalindrome {

    static class Solution {
        public int longestPalindrome(String s) {
            List<Character> list = new ArrayList<>();

            for (char c : s.toCharArray()) {
                list.add(c);
            }

            List<Integer> collect = list.stream()
                    .collect(Collectors.groupingBy(e -> e))
                    .values()
                    .stream()
                    .map(List::size)
                    .collect(Collectors.toList());
            int ans = 0;
            for (Integer v : collect) {
                ans += v / 2 * 2;
                if (v % 2 == 1 && ans % 2 == 0) {
                    ans += 1;
                }
            }
            return ans;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("abccccdd"));
    }


}
