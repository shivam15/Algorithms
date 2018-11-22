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
public class CountingSort {

    public static void main(String args[]) {
        int[] arr = {1, 9, 5, 2, 3, 3};
        printArray(countingSort(arr));
    }

    public static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static int[] countingSort(int arr[]) {
        int max = Integer.MIN_VALUE;
        int[] out = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }
        int[] count = new int[max];
        for (int i = 0; i < arr.length; i++) {
            count[arr[i] - 1]++;
        }

        for (int i = 1; i < count.length; i++) {
            count[i] += count[i - 1];
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            out[count[arr[i] - 1] - 1] = arr[i];
            --count[arr[i] - 1];
        }
        return out;
    }
}
