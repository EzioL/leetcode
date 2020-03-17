import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/17
 */
public class _1160_CountCharacters {
    static class Solution {
        public int countCharacters(String[] words, String chars) {

            int res = 0;
            Map<Character, Integer> charMap = getCharMap(chars);
            for (String word : words) {
                Map<Character, Integer> map = getCharMap(word);
                AtomicBoolean f = new AtomicBoolean(true);
                map.forEach((key, value) -> {
                    Integer i = charMap.get(key);
                    if (i == null || i < value) {
                        f.set(false);
                    }

                });
                if (f.get()) {
                    res = res + word.length();
                }
            }
            return res;
        }

        private Map<Character, Integer> getCharMap(String str) {
            Map<Character, Integer> map = new HashMap<>();
            for (char c : str.toCharArray()) {
                map.merge(c, 1, Integer::sum);
            }
            return map;

        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.countCharacters(new String[]{"hello", "world", "leetcode"}, "welldonehoneyr"));
    }
}
