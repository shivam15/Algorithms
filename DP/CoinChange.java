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
public class CoinChange {

    public static void main(String args[]) {
        int arr[] = {1, 5, 10};
        int n = 8;
        System.out.println(coinChangeUtil(arr, n));
        System.out.println(coinChangeUtil1D(arr,n));
    }

    //2D solution
    private static int coinChangeUtil(int[] arr, int n) {
        int[][] dp = new int[arr.length][n + 1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0 || i == 0) {
                    dp[i][j] = 1;
                } else if (j >= arr[i]) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - arr[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[arr.length - 1][n];
    }

    //1D solution
    private static int coinChangeUtil1D(int[] arr, int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr[i]; j <= n; j++) {
                dp[j] += dp[j - arr[i]];
            }
        }
        return dp[n];
    }
}
