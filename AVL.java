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
public class AVL {

    Node root;

    static class Node {

        int height;
        int value;
        Node Left;
        Node right;

        Node(int n) {
            this.value = n;
            this.Left = null;
            this.right = null;
            this.height = 1;
        }
    }

    public static void main(String args[]) {
        AVL tree = new AVL();

        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10); 
        tree.root = tree.insert(tree.root, 20); 
        tree.root = tree.insert(tree.root, 30); 
        tree.root = tree.insert(tree.root, 40); 
        tree.root = tree.insert(tree.root, 50); 
        tree.root = tree.insert(tree.root, 25); 

        /* The constructed AVL Tree would be 
             30 
            /  \ 
          20   40 
         /  \     \ 
        10  25    50 
         */
        System.out.println("Preorder traversal"
                + " of constructed tree is : ");
        tree.preOrder(tree.root);
    }

    static void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.value + " ");
            preOrder(node.Left);
            preOrder(node.right);
        }
    }

    static Node insert(Node node, int n) {
        if (node == null) {
            Node no = new Node(n);
            return no;
        } else if (node.value > n) {
            node.Left = insert(node.Left, n);
        } else if (node.value < n) {
            node.right = insert(node.right, n);
        } else {
            return node;
        }
        node.height = 1 + Math.max(height(node.Left), height(node.right));
        int x = getBalance(node);

        if (x > 1 && n < node.Left.value) {
            return rightRotate(node);
        }
        if (x < -1 && n > node.right.value) {
            return leftRotate(node);
        }
        if (x > 1 && n > node.Left.value) {
            node.Left = leftRotate(node.Left);
            return rightRotate(node);
        }
        if (x < -1 && n < node.right.value) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    static int height(Node N) {
        if (N == null) {
            return 0;
        }

        return N.height;
    }

    static int getBalance(Node N) {
        if (N == null) {
            return 0;
        }

        return height(N.Left) - height(N.right);
    }

    static Node rightRotate(Node y) {
        Node x = y.Left; 
        Node T2 = x.right; 
  
        // Perform rotation 
        x.right = y; 
        y.Left = T2; 
  
        // Update heights 
        y.height = Math.max(height(y.Left), height(y.right)) + 1; 
        x.height = Math.max(height(x.Left), height(x.right)) + 1; 
  
        // Return new root 
        return x; 
    }

    static Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.Left;
        y.Left = x;
        x.right = T2;
        x.height = Math.max(height(x.Left), height(x.right)) + 1;
        y.height = Math.max(height(y.Left), height(y.right)) + 1;
        return y;
    }
}
