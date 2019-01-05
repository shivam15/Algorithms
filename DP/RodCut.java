/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP;

/**
 *
 * @author shivam
 */
public class RodCut {

    //C(i) = max(Vk+C(i-k))
    public static void main(String args[]) {
        int arr[] = {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println(rodCutUtil(arr, arr.length));
    }

    private static int rodCutUtil(int[] arr, int n) {
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                max = Math.max(max, arr[j] + dp[i - j - 1]);
            }
            dp[i] = max;
        }
        return dp[n];
    }
}
