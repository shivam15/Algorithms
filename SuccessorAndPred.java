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
public class SuccessorAndPred {

    static Node pred;
    static Node suc;

    static class Node {

        Node left;
        Node right;
        int data;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void main(String args[]) {
        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(25);
        root.left.left = new Node(10);
        root.left.right = new Node(17);
        root.right.left = new Node(22);
        root.right.right = new Node(30);
        sucPred(root, 30);
        System.out.println("Pred::" + pred.data + " Succ::" + suc.data);
    }

    static void sucPred(Node root, int key) {
        if (root == null) {
            return;
        }
        if (root.data == key) {
            if (root.left != null) {
                Node tmp = root.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                pred = tmp;
            }
            if (root.right != null) {
                Node tmp = root.right;
                while (tmp.left != null) {
                    tmp = tmp.left;
                }
                suc = tmp;
            }
            return;
        }
        if (root.data > key) {
            suc = root;
            sucPred(root.left, key);
        }
        if (root.data < key) {
            pred = root;
            sucPred(root.right, key);
        }
    }

}
