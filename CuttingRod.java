/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

/**
 *
 * @author shivam
 */
public class CuttingRod {
    static int cutRod(int[] arr){
        int n = arr.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i=1;i<=n;i++){
            int val = Integer.MIN_VALUE;
            for(int j=0;j<i;j++)
                val = Math.max(val,arr[j]+dp[i-j-1]);
            dp[i] = val;
        }
        return dp[n];
    }
    public static void main(String args[]){
        int arr[] = new int[] {3, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("Max value obtained:: "+cutRod(arr));
    }
}
