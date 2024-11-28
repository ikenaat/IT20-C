
    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package topic_6_sorting;

/**
 *
 * @author L E N O V O
 */
import java.util.Scanner;
import java.time.LocalTime;

public class BubbleSort {
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j + 1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Accept user input for the array
        System.out.println("Enter the number of elements in the array:");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("Original array:");
        printArray(arr);

        // Record the start time
        long startTime = System.currentTimeMillis();
        LocalTime startSortTime = LocalTime.now();

        // Perform Bubble Sort
        bubbleSort(arr);

        // Record the end time
        long endTime = System.currentTimeMillis();
        LocalTime endSortTime = LocalTime.now();

        System.out.println("Sorted array:");
        printArray(arr);

        // Display runtime
        System.out.println("Sorting completed in " + (endTime - startTime) + " milliseconds.");

        // Display the exact start and end time
        System.out.println("Sorting started at: " + startSortTime);
        System.out.println("Sorting ended at: " + endSortTime);
    }
}
