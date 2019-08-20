import java.util.LinkedList;
import java.util.Queue;

public class SnakeLadder {

    public static void main(String args[]) {
        int N = 30;
        int moves[] = new int[N];
        for (int i = 0; i < N; i++)
            moves[i] = -1;

        // Ladders
        moves[2] = 21;
        moves[4] = 7;
        moves[10] = 25;
        moves[19] = 28;

        // Snakes
        moves[26] = 0;
        moves[20] = 8;
        moves[16] = 3;
        moves[18] = 6;
        System.out.println("Min Dice throws required is " +
                getMinDiceThrow(moves, N));
    }

    static class qentry {
        int v;
        int distance;
    }

    static int getMinDiceThrow(int[] moves, int n) {
        boolean[] visited = new boolean[n];
        Queue<qentry> li = new LinkedList<qentry>();
        qentry qe = new qentry();
        //visit first vertex
        qe.distance = 0;
        qe.v = 0;
        visited[0] = true;
        li.add(qe);
        while (!li.isEmpty()) {
            qe = li.remove();
            if (qe.v == n - 1)
                break;
            for (int i = qe.v + 1; i <= qe.v + 6 && i<n; i++) {
                qentry a = new qentry();
                a.distance = qe.distance + 1;
                if (moves[i] != -1) {
                    a.v = moves[i];
                } else {
                    a.v = i;
                }
                li.add(a);
            }
        }
        return qe.distance;
    }
}
