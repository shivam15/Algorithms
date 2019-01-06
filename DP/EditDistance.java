/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DP;

import java.util.ArrayList;

/**
 *
 * @author shivam
 */
public class EditDistance {

    private static final int DIAGONAL = 1;
    private static final int UP = 3;
    private static final int SIDE = 2;
    private static int[][] path;

    public static void main(String args[]) {
        String s1 = "sunday";
        String s2 = "saturday";
        System.out.println(editDistanceUtil(s1, s2));
        printDis(s1.length(), s2.length(), s1.toCharArray(), s2.toCharArray());
    }

    private static int editDistanceUtil(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        path = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    path[i][j] = (DIAGONAL);
                } else {
                    //This else will compare min(dp[i-1][j-1],dp[i-1][j],dp[i][j-1])
                    if (dp[i - 1][j - 1] < dp[i][j - 1]) {
                        if (dp[i - 1][j - 1] < dp[i - 1][j]) {
                            dp[i][j] = dp[i - 1][j - 1] + 1;
                            path[i][j] = (DIAGONAL);
                        } else {
                            dp[i][j] = dp[i - 1][j] + 1;
                            path[i][j] = (UP);
                        }
                    } else {
                        if (dp[i][j - 1] < dp[i - 1][j]) {
                            dp[i][j] = dp[i][j - 1] + 1;
                            path[i][j] = (SIDE);
                        } else {
                            dp[i][j] = dp[i - 1][j] + 1;
                            path[i][j] = (UP);
                        }
                    }
                }
            }
        }
        return dp[n][m];
    }

    private static void printDis(int m, int n, char[] c1, char[] c2) {
        if (m == 0 || n == 0) {
            return;
        }
        switch (path[m][n]) {
            case 2:
                printDis(m, n - 1, c1, c2);
                break;
            case 1:
                printDis(m - 1, n - 1, c1, c2);
                System.out.println(c2[n - 1] + " " + c1[m - 1]);
                break;
            case 3:
                printDis(m - 1, n, c1, c2);
                break;
            default:
                System.out.println("None");
        }
    }
}
