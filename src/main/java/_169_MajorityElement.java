import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/13
 */
public class _169_MajorityElement {

    static class Solution {
        public int majorityElement(int[] nums) {
            HashMap<Integer, Integer> map = new HashMap<>();

            for (int num : nums) {
                int f = map.getOrDefault(num, 0);
                map.put(num, f + 1);
            }
            AtomicInteger c = new AtomicInteger();
            AtomicInteger f = new AtomicInteger();
            map.forEach((key, value) -> {
                if (value > f.get()) {
                    f.set(value);
                    c.set(key);
                }
            });
            return c.get();
        }
    }

    public static void main(String[] args) {

    }
}
