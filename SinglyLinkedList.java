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
public class SinglyLinkedList {
    static Node head = null;
    static Node tail = null;
    static class Node {

        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static void main(String args[]) {
        insert(10);
        insert(20);
        insert(30);
        insert(40);
        insert(50);
        insertNth(3,60);
        printList(head);
        deleteNode(3);
        printList(head);
    }

    static void insert(int x) {
        Node n = new Node(x);
        if(head==null)
            head = n;
        else
            tail.next= n;
        tail = n;
    }
    
    static void insertNth(int x,int key){
        Node n = head;
        while(x>0)
        {
            n = n.next;
            x--;
        }
        Node temp = n.next;
        n.next = new Node(key);
        n.next.next = temp;
    }
    
    static void deleteNode(int position)
    {
        Node n = head;
        while(position>0)
        {
            n = n.next;
            position--;
        }
        n.next = n.next.next;
    }

    static void printList(Node head) {
        Node n = head;
        getMid();
        while (n != null) {
            System.out.print(n.data+"->");
            n = n.next;
        }
        System.out.println("null");
    }
    static void getMid()
    {
        Node slow = head;
        Node fast = head;
        while( fast!=null && fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow.data);
    }
}
