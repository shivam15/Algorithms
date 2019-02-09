/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import java.util.Arrays;

/**
 *
 * @author shivam
 */
public class KStacks {

    int arr[];
    int top[];
    int next[];
    int n, k;
    int free;

    public static void main(String args[]) {
        KStacks ks = new KStacks(3, 10);
        ks.push(15, 2);
        ks.push(45, 2);
        ks.push(17, 1);
        ks.push(49, 1);
        ks.push(39, 1);
        ks.push(11, 0);
        ks.push(9, 0);
        ks.push(7, 0);
        System.out.println("Popped element from stack 2 is " + ks.pop(2));
        System.out.println("Popped element from stack 1 is " + ks.pop(1));
        System.out.println("Popped element from stack 0 is " + ks.pop(0));
    }

    KStacks(int k, int size) {
        this.k = k;
        this.n = size;
        this.free = 0;
        arr = new int[size];
        top = new int[k];
        next = new int[n];
        Arrays.fill(top, -1);
        for (int i = 0; i < n; i++) {
            next[i] = i + 1;
        }
        next[n - 1] = -1;
    }

    void push(int val, int sn) {
        if (isFull()) {
            System.out.println("Stack Full");
            return;
        }
        int i = free;
        free = next[i];
        next[i] = top[sn];
        top[sn] = i;
        arr[i] = val;
    }

    int pop(int sn) {
        if (isEmpty(sn)) {
            System.out.println("Stack Underflow");
            return Integer.MAX_VALUE;
        }
        int i = top[sn];
        top[sn] = next[i];
        next[i] = free;
        free = i;
        return arr[i];
    }

    boolean isFull() {
        return (free == -1);
    }

    boolean isEmpty(int sn) {
        return (top[sn] == -1);
    }
}
