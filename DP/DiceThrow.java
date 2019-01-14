/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms.DP;

/**
 *
 * @author shivam
 */
public class DiceThrow {

    public static void main(String args[]) {
        System.out.println(diceThrowUtil(4, 2, 1));
        System.out.println(diceThrowUtil(2, 2, 3));
        System.out.println(diceThrowUtil(6, 3, 8));
        System.out.println(diceThrowUtil(4, 2, 5));
        System.out.println(diceThrowUtil(4, 3, 5));
    }

    private static int diceThrowUtil(int m, int n, int x) {
        int dp[][] = new int[n + 1][x + 1];
        for (int j = 1; j <= m && j <= x; j++) {
            dp[1][j] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= x; j++) {
                for (int k = 1; k <= m; k++) {
                    if (k < j) {
                        dp[i][j] += dp[i - 1][j - k];
                    }
                }
            }
        }
        return dp[n][x];
    }
}
