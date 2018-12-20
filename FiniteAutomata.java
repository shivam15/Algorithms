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
public class FiniteAutomata {

    private static int chars = 256;
    public static int[][] tf;

    public static void main(String args[]) {
        search("AABAACAADAABAAABAA","AABA");
    }

    static void search(String text, String pattern) {
        formTf(text, pattern);
        int state = 0;
        for (int i = 0; i < text.length(); i++) {
            state = tf[state][text.toCharArray()[i]];
            if (state == pattern.length()) {
                System.out.println("Pattern found at:: " + (i - pattern.length() + 1));
            }
        }
    }

    public static void formTf(String text, String pattern) {
        int m = pattern.length();
        tf = new int[m + 1][chars];
        for (int state = 0; state <= m; state++) {
            for (int x = 0; x < chars; x++) {
                tf[state][x] = getNextState(pattern, m, state, x);
            }
        }
    }

    static int getNextState(String pattern, int m, int state, int x) {
        if (state < m && x == pattern.toCharArray()[state]) {
            return state + 1;
        }
        int ns, i;
        for (ns = state; ns > 0; ns--) {
            if (pattern.toCharArray()[ns - 1] == x) {
                for (i = 0; i < ns-1; i++) {
                    if (pattern.toCharArray()[i] != pattern.toCharArray()[state - ns + 1 + i]) {
                        break;
                    }
                }
                if (i == ns - 1) {
                    return ns;
                }
            }
        }
        return 0;
    }

}
