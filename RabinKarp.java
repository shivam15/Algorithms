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
public class RabinKarp {

    private static int prime = 101;

    public static void main(String args[]) {
        patternSearch("abcdabcefgabtcabc","abc");
    }

    public static void patternSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        long patternHash = createHash(pattern, m - 1);
        long textHash = createHash(text, m - 1);
        for (int i = 1; i <= n - m + 1; i++) {
            if (patternHash == textHash && checkEqual(text, pattern, i - 1, i + m - 2, 0, m - 1)) {
                System.out.println("Pattern found at:: "+ (i - 1));
            }
            if (i < n - m + 1) {
                textHash = recomputeHash(text, i - 1, i + m - 1, textHash, m);
            }
        }
    }

    private static boolean checkEqual(String text, String pattern, int start1, int end1, int start2, int end2) {
        if (end1 - start1 != end2 - start2) {
            return false;
        }
        while (start1 <= end1 && start2 <= end2) {
            if (text.toCharArray()[start1] != pattern.toCharArray()[start2]) {
                return false;
            }
            start1++;
            start2++;
        }
        return true;
    }

    private static Long recomputeHash(String text, int oldIndex, int newIndex, Long oldHash, int size) {
        long newHash = oldHash - text.toCharArray()[oldIndex];
        newHash = newHash / prime;
        newHash += text.toCharArray()[newIndex] * Math.pow(prime, size - 1);
        return newHash;
    }

    private static Long createHash(String s, int n) {
        long hash = 0;
        for (int i = 0; i <= n; i++) {
            hash += s.toCharArray()[i] * Math.pow(prime, i);
        }
        return hash;
    }

}
