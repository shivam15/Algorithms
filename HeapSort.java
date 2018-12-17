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
public class HeapSort {

    static void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        heapSort(arr);
    }

    static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);
        }
        print(arr);
    }

    static void buildHeap(int[] arr) {
        int n = arr.length;
        for (int i = (n / 2) - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
    }

    static void heapify(int[] arr, int n, int i) {
        int lar = i;
        int l = 2*i+1;
        int r = 2*i+2;
         if (l < n && arr[l] > arr[lar]) 
            lar = l; 
        if (r < n && arr[r] > arr[lar]) 
            lar = r; 
        if(lar!=i){
            int temp = arr[lar];
            arr[lar] = arr[i];
            arr[i] = temp;
            heapify(arr,n,lar);
        }
    }
}
