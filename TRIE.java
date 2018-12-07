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
public class TRIE {

    static int alphabets = 26;
    static Trie root;

    static class Trie {

        Trie[] children = new Trie[alphabets];
        boolean isEnd;

        Trie() {
            isEnd = false;
            for (int i = 0; i < alphabets; i++) {
                children[i] = null;
            }
        }
    }

    static void insert(String str) {
        int n = str.length();
        Trie crawler = root;
        for (int i = 0; i < n; i++) {
            int index = str.charAt(i) - 'a';
            if (crawler.children[index] == null) {
                crawler.children[index] = new Trie();
            }
            crawler = crawler.children[index];
        }
        crawler.isEnd = true;
    }

    static boolean search(String str) {
        int n = str.length();
        Trie crw = root;
        for (int i = 0; i < n; i++) {
            int index = str.charAt(i) - 'a';
            if (crw.children[index] == null) {
                return false;
            }
            crw = crw.children[index];
        }
        return (crw != null && crw.isEnd);
    }

    static void display(Trie node, char str[], int level) {
        if (node.isEnd) {
            for (int i = 0; i < level; i++) {
                System.out.print(str[i]);
            }
            System.out.println("");
        }
        for (int i = 0; i < alphabets; i++) {
            if (node.children[i] != null) {
                str[level] = (char) (i + 'a');
                display(node.children[i], str, level + 1);
            }
        }
    }

    static boolean delete(Trie node, char[] key, int level, int len) {
        if (node != null) {
            if (level == len) {
                if (node.isEnd) {
                    node.isEnd = false;
                    if (isItFreeNode(node)) {
                        return true;
                    }
                    return false;
                }
            } else {
                int index = key[level] - 'a';
                if (delete(node.children[index], key, level + 1, len)) {
                    node.children[index] = null;
                    return (!node.isEnd && isItFreeNode(node));
                }
            }
        }
        return false;
    }

    static boolean isItFreeNode(Trie node) {
        int i;
        for (i = 0; i < alphabets; i++) {
            if (node.children[i] != null) {
                return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case) 
        String keys[] = {"the", "a", "there", "answer", "any",
            "by", "bye", "their"};

        String output[] = {"Not present in trie", "Present in trie"};

        root = new Trie();

        // Construct trie 
        int i;
        for (i = 0; i < keys.length; i++) {
            insert(keys[i]);
        }

        // Search for different keys 
        if (search("the") == true) {
            System.out.println("the --- " + output[1]);
        } else {
            System.out.println("the --- " + output[0]);
        }

        if (search("these") == true) {
            System.out.println("these --- " + output[1]);
        } else {
            System.out.println("these --- " + output[0]);
        }

        if (search("their") == true) {
            System.out.println("their --- " + output[1]);
        } else {
            System.out.println("their --- " + output[0]);
        }

        if (search("thaw") == true) {
            System.out.println("thaw --- " + output[1]);
        } else {
            System.out.println("thaw --- " + output[0]);
        }
        char[] str = new char[20];
        display(root, str, 0);
        delete(root,keys[5].toCharArray(),0,keys[5].length());
        str = new char[20];
        display(root, str, 0);

    }
}
