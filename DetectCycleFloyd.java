/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.LinkedList;

/**
 *
 * @author shivam
 */
public class DetectCycleFloyd {

    static Node head;

    static class Node {

        Node next;
        int val;

        Node(int n) {
            this.val = n;
            next = null;
        }
    }

    public static void main(String[] args) {
        head = new Node(50);
        head.next = new Node(20);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(10);

        // Creating a loop for testing  
        head.next.next.next.next.next = head.next.next;
        detectAndRemoveLoop(head);
        System.out.println("Linked List after removing loop : ");
        printList(head);
    }

    static void detectAndRemoveLoop(Node head) {
        Node slow = head;
        Node fast = head;
        slow = slow.next;
        fast = fast.next.next;
        while (fast.next != null || fast != null) {
            if (slow == fast) {
                break;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println("Loop detected at "+slow.val);
        if (slow == fast) {
            slow = head;
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            fast.next = null;
        } else {
            System.out.println("No rings");
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}
