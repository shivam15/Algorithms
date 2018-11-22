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
public class BinarySearchTree {

    static class Node {
        int data;
        Node left;
        Node right;
        Node(int data)
        {
           this.data = data;
           this.left = null;
           this.right = null;
        }
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data +" ");
        inOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data +" ");
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data +" ");
        postOrder(root.left);
        postOrder(root.right);
    }

    static void Search(Node root, int data) {
        if (root == null) {
            return;
        }
        if (root.data == data) {
            System.out.print("Fount" + root.data);
        }
        if (root.data > data) {
            Search(root.left, data);
        } else {
            Search(root.right, data);
        }
    }

    static void SearchItr(Node root, int data) {
        while (root != null) {
            if (root.data == data) {
                System.out.print("Found" + root.data);
            }
            if (root.data > data) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
    }
    
    public static void main(String args[])
    {
        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(25);
        root.left.left = new Node(10);
        root.left.right = new Node(17);
        root.right.left = new Node(22);
        root.right.right = new Node(30);
        inOrder(root);
        System.out.println("");
        postOrder(root);
        System.out.println("");
        preOrder(root);
        System.out.println("");
        SearchItr(root,17);
        System.out.println("");
        Search(root,22);
    }

}
