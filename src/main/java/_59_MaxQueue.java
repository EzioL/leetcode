import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Here be dragons !
 *
 * @author: Ezio
 * created on 2020/3/7
 */
public class _59_MaxQueue {

    public static class MaxQueue {

        private Deque<Integer> queue;
        private Deque<Integer> help;

        public MaxQueue() {

            queue = new ArrayDeque<Integer>();
            help = new ArrayDeque<Integer>();

        }

        public int max_value() {
            return queue.isEmpty() ? -1 : help.peek();
        }

        public void push_back(int value) {

            queue.offer(value);
            while(!help.isEmpty() && value > help.peekLast()) {
                help.pollLast();
            }
            help.offer(value);

        }

        public int pop_front() {
            if(queue.isEmpty()) {
                return -1;
            }
            int val = queue.pop();
            if(help.peek() == val) {
                help.pop();
            }
            return val;
        }
    }
}
