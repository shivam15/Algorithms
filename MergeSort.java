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
public class MergeSort {

    public static void main(String args[]) {
        int[] arr = {10, 7, 8, 9, 1, 5,10,90,0,2};
        mergeSort(arr, 0, arr.length - 1);
        printArray(arr);
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    static void mergeSort(int[] arr, int low, int high) {
        int mid = (low + high) / 2;
        if (low < high) {
            mergeSort(arr, mid + 1, high);
            mergeSort(arr, low, mid);
            merge(arr, low, high, mid);
        }
    }

    static void merge(int[] arr, int low, int high, int mid) {
        int n = mid - low + 1;
        int m = high - mid;
        int[] l = new int[n];
        int[] r = new int[m];
        for (int i = 0; i < n; ++i) {
            l[i] = arr[low + i];
        }
        for (int j = 0; j < m; ++j) {
            r[j] = arr[mid + 1 + j];
        }
        int x = 0;
        int y = 0;
        int k = low;
        while (x < n && y < m) {
            if (l[x] <= r[y]) {
                arr[k] = l[x];
                x++;
            } else {
                arr[k] = r[y];
                y++;
            }
            k++;
        }
        if (x != n) {
            while (x < n) {
                arr[k] = l[x];
                x++;
                k++;
            }
        } else {
            while (y < m) {
                arr[k] = r[y];
                y++;
                k++;
            }
        }
    }
}
