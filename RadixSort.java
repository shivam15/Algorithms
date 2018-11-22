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
public class RadixSort {

    public static void main(String args[]) {
        int[] arr = {1, 9, 5, 2, 3, 3, 100, 11};
        radixSort(arr);
        printArray(arr);
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void countingSort(int arr[], int exp) {
        int[] out = new int[arr.length];
        int[] count = new int[10];
        for (int i = 0; i < arr.length; i++) {
            count[((arr[i] / exp) % 10)]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            out[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = out[i];
        }
    }

    public static void radixSort(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        for (int i = 1; max / i > 0; i *= 10) {
            countingSort(arr, i);
        }
    }
}
