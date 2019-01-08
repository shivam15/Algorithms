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
public class PartitionProblem {

    public static void main(String args[]) {
        int[] arr = {1, 6, 11, 5, 17};
        System.out.println(partitionUtil(arr));

    }

    private static int partitionUtil(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (j >= arr[i - 1]) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]];
                }
            }
        }
        int diff = Integer.MAX_VALUE;
        for (int i = sum / 2; i >= 0; i--) {
            if (dp[n][i]) {
                diff = sum - 2 * i;
                break;
            }
        }
        return diff;
    }
}
