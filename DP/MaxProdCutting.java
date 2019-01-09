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
public class MaxProdCutting {

    public static void main(String args[]) {
        int n = 10;
        System.out.println(maxProdUtil(n));
    }

    private static int maxProdUtil(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 1; i <= n; i++) {
            int max = 0;
            for (int j = 1; j <= i / 2; j++) {
                max = Integer.max(max, Math.max((i - j) * j, j * dp[i - j]));
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
