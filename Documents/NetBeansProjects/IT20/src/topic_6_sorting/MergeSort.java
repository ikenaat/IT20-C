package topic_6_sorting;
import java.util.Scanner;
import java.time.LocalTime;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        if (arr.length < 2) {
            return;
        }
        
 int mid = arr.length / 2;
        int[] left = new int[mid];
        int[] right = new int[arr.length - mid];

        System.arraycopy(arr, 0, left, 0, mid);
        System.arraycopy(arr, mid, right, 0, arr.length - mid);

        mergeSort(left);
        mergeSort(right);

        merge(arr, left, right);
    }
    
private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
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

        // Perform Merge Sort
        mergeSort(arr);

        // Record the end time
        long endTime = System.currentTimeMillis();
        LocalTime endSortTime = LocalTime.now();

        System.out.println("Sorted array:");
        printArray(arr);

        // Display runtime
        System.out.println("Sorting completed in " + (endTime - startTime) + " milliseconds.");

        // Display the exact start and end times
        System.out.println("Sorting started at: " + startSortTime);
        System.out.println("Sorting ended at: " + endSortTime);
    }
}

