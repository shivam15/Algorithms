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
public class PowFunction {

    public static void main(String args[]) {
        System.out.println(pow(3,11));
    }

    static int pow(int n, int m) {
        int res = 1;
        while (m > 0) {
            if ((m & 1) == 1) {
                res = res * n;
            }
            m = m/2;
            n = n * n;
        }
        return res;
    }
}
