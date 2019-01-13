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
public class WordBreak {

    static String[] dictionary = {"mobile", "samsung", "sam", "sung", "man", "mango",
        "icecream", "and", "go", "i", "like", "ice", "cream"};

    public static void main(String args[]) {
        if (wordUtil("ilikesamsung")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordUtil("ilikelikeimangoiii")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordUtil("samsungandmango")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
        if (wordUtil("samsungandmangok")) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    private static boolean wordUtil(String search) {
        boolean dp[] = new boolean[search.length() + 1];
        for (int i = 1; i <= search.length(); i++) {
            if (dp[i] == false && isInDict(search.substring(0, i))) {
                dp[i] = true;
            }
            if (dp[i] == true) {
                if (i == search.length()) {
                    return true;
                }
                for (int j = i + 1; j <= search.length(); j++) {
                    if (dp[j] == false && isInDict(search.substring(i, j))) {
                        dp[j] = true;
                    }
                    if (j == search.length() && dp[j] == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private static boolean isInDict(String word) {
        for (int i = 0; i < dictionary.length; i++) {
            if (dictionary[i].equalsIgnoreCase(word)) {
                return true;
            }
        }
        return false;
    }
}
