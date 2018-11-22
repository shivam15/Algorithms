/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algorithms;

/**
 *
 * @author shivam
 */
public class QuickSort {

    public static void main(String args[]) {
        int[] arr = {10, 7, 8, 9, 1, 5};
        printArray(quickSort(arr,0,arr.length-1));
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] quickSort(int[] arr,int low,int high) {
        if(low<high)
        {
            int pi = partition(arr,low,high);
            quickSort(arr,low,pi-1);
            quickSort(arr,pi+1,high);
        }
        return arr;
    }

    static int partition(int[] arr, int low, int high) {
        int x = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (x >= arr[j]) {
                i++;
                int tmp = arr[j];
                arr[j] = arr[i];
                arr[i] = tmp;
            }
        }
        i++;
        int tmp = arr[high];
        arr[high] = arr[i];
        arr[i] = tmp;
        return i;
    }
}
