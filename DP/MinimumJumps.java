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
public class MinimumJumps {

    //dynamic programming
    static int minJumpsUtil(int[] arr) {
        if (arr.length == 1) {
            return 0;
        }
        if (arr.length == 0 || arr[0] == 0) {
            return -1;
        }
        int dp[] = new int[arr.length];
        dp[0] = 0;
        for (int i = 1; i < arr.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (i <= j + arr[j] && dp[j] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                    break;
                }
            }
        }
        return dp[arr.length - 1];
    }

    //in O(n)
    static int minJumpsUtilSimplified(int[] arr) {
        if (arr.length <= 1) {
            return 0;
        }
        if (arr[0] == 0) {
            return -1;
        }
        int steps = arr[0];
        int jumps = 1;
        int maxReach = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (i == arr.length - 1) {
                return jumps;
            }
            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;
            if (steps == 0) {
                jumps++;
                if (i >= maxReach) {
                    return -1;
                }
                steps = maxReach - i;
            }
        }
        return -1;
    }

    public static void main(String args[]) {
        int arr[] = new int[]{1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        System.out.println(minJumpsUtilSimplified(arr));
        System.out.println(minJumpsUtil(arr));
    }
}
