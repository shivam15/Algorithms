/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author shivam
 */
public class knightTour {

    static int[][] arr;
    static int N;

    public static void main(String args[]) {
        arr = new int[5][5];
        N = 5;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                arr[x][y] = -1;
            }
        }
        int xMove[] = {2, 1, -1, -2, -2, -1, 1, 2};
        int yMove[] = {1, 2, 2, 1, -1, -2, -2, -1};

        arr[0][0] = 0;
        if (!knightUtil(0, 0, xMove, yMove,1)) {
            System.out.println("Solution does not exist");
        } else {
            printSol();
        }
    }

    public static void printSol() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println("");
        }
    }

    public static boolean isSafe(int x, int y) {
        return (x >= 0 && x < N && y >= 0
                && y < N && arr[x][y] == -1);
    }

    public static boolean knightUtil(int x, int y, int[] xmove, int[] ymove, int m) {
        if (m == N * N) {
            return true;
        } else {
            for (int i = 0; i < 8; i++) {
                int nextx = xmove[i] + x;
                int nexty = ymove[i] + y;
                if (isSafe(nextx, nexty)) {
                    arr[nextx][nexty] = m;
                    if (knightUtil(nextx, nexty, xmove, ymove, m + 1)) {
                        return true;
                    } else {
                        arr[nextx][nexty] = -1;
                    }
                }
            }
            return false;
        }
    }
}
