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
public class LCS {

    static int[][] c;
    static int[][] b;
    static int diag = 1;
    static int left = 2;
    static int up = 3;

    public static void main(String args[]) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        doLCS(s1.toCharArray(), s2.toCharArray());
        printLCS(s1.length(),s2.length(),s1.toCharArray(),s2.toCharArray());
    }

    static void doLCS(char[] c1, char[] c2) {
        c = new int[c1.length + 1][c2.length + 1];
        b = new int[c1.length + 1][c2.length + 1];
        for (int i = 0; i <= c1.length; i++) {
            for (int j = 0; j <= c2.length; j++) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                    continue;
                }
                if (c1[i - 1] == c2[j - 1]) {
                    c[i][j] = c[i - 1][j - 1] + 1;
                    b[i][j] = diag;
                } else if (c[i][j - 1] >= c[i - 1][j]) {
                    c[i][j] = c[i][j - 1];
                    b[i][j] = left;
                } else {
                    c[i][j] = c[i - 1][j];
                    b[i][j] = up;
                }
            }
        }
    }

    static void printLCS(int m, int n, char[] c1, char[] c2) {
        if (m == 0 || n == 0) {
            return;
        }
        switch (b[m][n]) {
            case 2:
                printLCS(m, n - 1, c1, c2);
                break;
            case 1:
                printLCS(m - 1, n - 1, c1, c2);
                System.out.print(c1[m-1]);
                break;
            case 3:
                printLCS(m - 1, n, c1, c2);
                break;
            default:
                System.out.println("None");
        }
    }

}
