import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/5/7
 */
public class NestedIterator implements Iterator<Integer> {


    public interface NestedInteger {
        public boolean isInteger();

        public Integer getInteger();

        public List<NestedInteger> getList();
    }

    Queue<Integer> res = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        for (NestedInteger nestedInteger : nestedList) {
            dfs(nestedInteger);
        }

    }

    private void dfs(NestedInteger node) {

        if (node.isInteger()) {
            res.offer(node.getInteger());
        }
        for (NestedInteger temp : node.getList()) {
            dfs(temp);
        }
    }

    @Override
    public Integer next() {
        return res.poll();
    }

    @Override
    public boolean hasNext() {
        return !res.isEmpty();
    }
}
