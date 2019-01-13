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
public class GameStrategy {

    public static void main(String[] args) {
        int arr1[] = {8, 15, 3, 7};
        int n = arr1.length;
        System.out.println("" + optimalStrategyUtil(arr1, n));

        int arr2[] = {2, 2, 2, 2};
        n = arr2.length;
        System.out.println("" + optimalStrategyUtil(arr2, n));

        int arr3[] = {20, 30, 2, 2, 2, 10};
        n = arr3.length;
        System.out.println("" + optimalStrategyUtil(arr3, n));
    }

    private static int optimalStrategyUtil(int[] arr, int n) {
        int[][] dp = new int[n][n];
        for (int gap = 0; gap < n; gap++) {
            for (int j = gap, i = 0; j < n; j++, i++) {
                int x = (i + 2) <= j ? dp[i + 2][j] : 0;
                int y = (i + 1) <= j - 1 ? dp[i + 1][j - 1] : 0;
                int z = (i) <= j - 2 ? dp[i][j - 2] : 0;
                dp[i][j] = Math.max(arr[i] + Math.min(x, y), arr[j] + Math.min(y, z));
            }
        }
        return dp[0][n - 1];
    }
}
