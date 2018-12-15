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
public class LPS {
    //use diag left up for printing string
    static int diag = 1;
    static int left = 2;
    static int up = 3;
    static String str;
    public static void main(String args[]){
        str = "agbdba";
        doLPS(str);
    }
    
    static void doLPS(String str){
        
        int[][] dp = new int[str.length()][str.length()];
        for(int i=0;i<str.length();i++){
            dp[i][i] = 1;
        }
        int n = str.length();
        for(int c1 = 2;c1<=str.length();c1++){
            for(int i=0;i<n-c1+1;i++){
                int j = i+c1-1;
                if(str.charAt(i)==str.charAt(j)){
                    dp[i][j] = dp[i+1][j-1]+2;
                }
                else if(dp[i][j-1]>dp[i+1][j])
                {
                    dp[i][j] = dp[i][j-1];
                }
                else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        System.out.println(dp[0][n-1]);
        
    }
}
