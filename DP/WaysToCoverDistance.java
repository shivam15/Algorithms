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
public class WaysToCoverDistance {

    public static void main(String[] args) {
        int dist = 25;
        System.out.println(printCountRec(dist));
    }

    private static int printCountRec(int dist) {
        int[] dp = new int[dist + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= dist; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }
        return dp[dist];
    }
}
