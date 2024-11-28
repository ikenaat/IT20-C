package topic_6_sorting;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            // Recursively sort elements before and after partition
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

 private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        

        // Swap arr[i + 1] and arr[high] (or pivot)
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
    }

    public static void printArray(String message, int[] arr) {
        System.out.println(message + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Quick Sort Program!");
        System.out.println("----------------------------------");
        System.out.print("Enter the number of elements you'd like to sort: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Great! Please enter the " + n + " numbers (space-separated):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        System.out.println("\nAnalyzing your input...");
        printArray("Original array: ", arr);

        // Record the start time
        long startTime = System.currentTimeMillis();
        LocalTime startSortTime = LocalTime.now();

        // Perform Quick Sort
        quickSort(arr, 0, arr.length - 1);

        // Record the end time
        long endTime = System.currentTimeMillis();
        LocalTime endSortTime = LocalTime.now();

        printArray("Sorted array: ", arr);

        // Display runtime
        System.out.println("\nQuick Sort completed in " + (endTime - startTime) + " milliseconds!");
        System.out.println("Sorting started at: " + startSortTime);
        System.out.println("Sorting ended at: " + endSortTime);
        System.out.println("\nThank you for using the Quick Sort Program. Have a great day!");
    }
}
