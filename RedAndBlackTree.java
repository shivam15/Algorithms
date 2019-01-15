/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * @author shivam
 */
public class RedAndBlackTree {

    enum Color {
        RED, BLACK
    }

    class Node {

        Node left;
        Node right;
        int val;
        Node parent;
        Color color;

        Node(int n) {
            this.val = n;
            this.left = null;
            this.right = null;
            this.parent = null;
        }
    }
    Node ROOT;

    private void leftRotate(Node B) {
        Node A = B.right;
        B.right = A.left;
        if (A.left != null) {
            A.left.parent = B;
        }
        A.parent = B.parent;
        if (B.parent == null) {
            ROOT = A;
        } else if (B.parent.left == B) {
            B.parent.left = A;
        } else {
            B.parent.right = A;
        }
        A.left = B;
        B.parent = A;
    }

    private void rightRotate(Node A) {
        Node B = A.left;
        A.left = B.right;
        if (B.right != null) {
            B.right.parent = A;
        }
        B.parent = A.parent;
        if (A.parent == null) {
            ROOT = B;
        } else if (A.parent.left == A) {
            A.parent.left = B;
        } else {
            A.parent.right = B;
        }
        B.right = A;
        A.parent = B;
    }

    private void insert(int val) {
        Node root = ROOT;
        Node temp = null;
        while (root != null) {
            temp = root;
            if (root.val > val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        Node n = new Node(val);
        n.parent = temp;
        n.color = Color.RED;
        if (temp == null) {
            ROOT = n;
        } else if (temp.val > n.val) {
            temp.left = n;
        } else {
            temp.right = n;
        }
        fixTree(ROOT, n);
    }

    private void fixTree(Node root, Node cur) {
        Node y;
        while (cur != root && cur.parent.color == Color.RED) {
            if (cur.parent == cur.parent.parent.left) {
                y = cur.parent.parent.right;
                if (y != null && y.color == Color.RED) {
                    y.color = Color.BLACK;
                    cur.parent.color = Color.BLACK;
                    cur.parent.parent.color = Color.RED;
                    cur = cur.parent.parent;
                } else {
                    if (cur == cur.parent.right) {
                        cur = cur.parent;
                        leftRotate(cur);
                    }
                    cur.parent.color = Color.BLACK;
                    cur.parent.parent.color = Color.RED;
                    rightRotate(cur.parent.parent);
                }

            } else {
                y = cur.parent.parent.left;
                if (y != null && y.color == Color.RED) {
                    y.color = Color.BLACK;
                    cur.parent.color = Color.BLACK;
                    cur.parent.parent.color = Color.RED;
                    cur = cur.parent.parent;
                } else {
                    if (cur == cur.parent.left) {
                        cur = cur.parent;
                        rightRotate(cur);
                    }
                    cur.parent.color = Color.BLACK;
                    cur.parent.parent.color = Color.RED;
                    leftRotate(cur.parent.parent);
                }
            }
        }
        ROOT.color = Color.BLACK;
    }

    private void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.val + " ");
        inOrderTraversal(root.right);
    }

    private void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> qu = new LinkedList<Node>();
        qu.add(root);
        while (!qu.isEmpty()) {
            Node temp = qu.poll();
            System.out.println(temp.val + " " + temp.color + " ");
            if (temp.left != null) {
                qu.add(temp.left);
            }
            if (temp.right != null) {
                qu.add(temp.right);
            }
        }
    }

    public static void main(String args[]) {
        RedAndBlackTree tree = new RedAndBlackTree();
        tree.insert(7);
        tree.insert(6);
        tree.insert(5);
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.inOrderTraversal(tree.ROOT);
        System.out.println("");
        tree.levelOrderTraversal(tree.ROOT);
    }
}
