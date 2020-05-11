import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Here be dragons !
 * 最短路径
 *
 * @author: Ezio
 * created on 2020/5/9
 */
public class Dijkstra {

    static class node {
        int x; //节点编号
        int len;//长度

        public node(int x, int len) {
            this.x = x;
            this.len = len;
        }
    }

    public static void main(String[] args) {
        //记录权值，顺便记录链接情况，可以考虑附加邻接表
        int[][] map = new int[6][6];
        //初始化
        initmap(map);
        //判断是否已经确定
        boolean bool[] = new boolean[6];
        //长度
        int len[] = new int[6];
        for (int i = 0; i < 6; i++) {
            len[i] = Integer.MAX_VALUE;
        }
        Queue<node> q1 = new PriorityQueue<   >(Comparator.comparingInt(o -> o.len));


        len[0] = 0;
        q1.add(new node(0, 0));
        //计算执行了几次dijkstra
        int count = 0;
        while (!q1.isEmpty()) {
            node t1 = q1.poll();
            int index = t1.x;//节点编号
            int length = t1.len;//节点当前点距离
            bool[index] = true;//抛出的点确定
            count++;//其实执行了6次就可以确定就不需要继续执行了  这句可有可无，有了减少计算次数
            for (int i = 0; i < map[index].length; i++) {
                if (map[index][i] > 0 && !bool[i]) {
                    node node = new node(i, length + map[index][i]);
                    //需要更新节点的时候更新节点并加入队列
                    if (len[i] > node.len) {
                        len[i] = node.len;
                        q1.add(node);
                    }
                }
            }
        }
        for (int i = 0; i < 6; i++) {
            System.out.println(len[i]);
        }

    }


    private static void initmap(int[][] map) {
        map[0][1] = 2;
        map[0][2] = 3;
        map[0][3] = 6;
        map[1][0] = 2;
        map[1][4] = 4;
        map[1][5] = 6;
        map[2][0] = 3;
        map[2][3] = 2;
        map[3][0] = 6;
        map[3][2] = 2;
        map[3][4] = 1;
        map[3][5] = 3;
        map[4][1] = 4;
        map[4][3] = 1;
        map[5][1] = 6;
        map[5][3] = 3;
    }


}
