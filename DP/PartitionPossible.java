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
public class PartitionPossible {
    public static void main(String args[]){
        int arr[] = {3, 1, 1, 2, 2,1}; 
        System.out.println(PartitionPossibleUtil(arr));
    }
    
    private static boolean PartitionPossibleUtil(int[] arr) {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        boolean[][] dp = new boolean[n + 1][(sum / 2) + 1];
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= sum / 2; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum / 2; j++) {
                dp[i][j] = dp[i-1][j];
                if(j>=arr[i-1]){
                    dp[i][j] = dp[i][j] || dp[i-1][j-arr[i-1]];
                }
            }
        }
        return dp[n][sum/2];
    }
}
