import java.util.ArrayList;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/30
 */
public class _62_LastRemaining {


    class Solution {
        public int lastRemaining(int n, int m) {
            ArrayList<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }

            int idx = 0;
            while (n > 1) {
                idx = (idx + m - 1) % n;
                list.remove(idx);
                n--;
            }
            return list.get(0);
        }
    }


}
