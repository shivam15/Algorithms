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
public class NthLevelNode {
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
    public static void main(String args[])
    {
        Node root = new Node(20);
        root.left = new Node(15);
        root.right = new Node(25);
        root.left.left = new Node(10);
        root.left.right = new Node(17);
        root.right.left = new Node(22);
        root.right.right = new Node(30);
        root.right.right.right = new Node(35);
        printNth(root,3);
    }
    
    static void printNth(Node root, int level){
        if(root==null)
            return;
        if(level==0)
            System.out.print(root.data+" ");
        if(root.left!=null)
            printNth(root.left,level-1);
        if(root.right!=null)
            printNth(root.right,level-1);
    }
}
