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
public class EggDropping {
    
    public static void main(String args[]){
        System.out.println(eggDroppingUtil(36,2));
    }

    private static int eggDroppingUtil(int n, int m) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            dp[i][1] = 1;
            dp[i][0] = 0;
        }
        for (int j = 1; j <= n; j++) 
            dp[1][j] = j; 
        
        for (int i = 2; i <= m; i++) {
            for (int j = 2; j <= n; j++) {
                if (i > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Integer.MAX_VALUE;
                    for (int x = 1; x <= j; x++) {
                        int val = 1 + Math.max(dp[i - 1][x - 1], dp[i][j - x]);
                        if (val < dp[i][j]) {
                            dp[i][j] = val;
                        }
                    }
                }
            }
        }
        return dp[m][n];

    }
}
