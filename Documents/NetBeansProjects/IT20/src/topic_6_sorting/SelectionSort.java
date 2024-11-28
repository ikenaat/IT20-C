
package topic_6_sorting;
import java.util.Scanner;
import java.time.LocalTime;
import java.util.Arrays;

public class SelectionSort {
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            
  // Swap the found minimum element with the first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
  public static void printArray(String message, int[] arr) {
        System.out.println(message + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Selection Sort Program!");
        System.out.println("--------------------------------------");
        System.out.print("Enter the number of elements you'd like to sort: ");
        int n = scanner.nextInt();

        int[] arr = new int[n];
        System.out.println("Please enter the " + n + " numbers (space-separated):");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        

        System.out.println("\nAnalyzing your input...");
        printArray("Original array: ", arr);

        // Record the start time
        long startTime = System.currentTimeMillis();
        LocalTime startSortTime = LocalTime.now();

        // Perform Selection Sort
        selectionSort(arr);

        // Record the end time
        long endTime = System.currentTimeMillis();
        LocalTime endSortTime = LocalTime.now();

        // Display sorted array
        printArray("Sorted array: ", arr);

        // Display runtime
        System.out.println("\nSorting completed in " + (endTime - startTime) + " milliseconds!");
        System.out.println("Sorting started at: " + startSortTime);
        System.out.println("Sorting ended at: " + endSortTime);
        System.out.println("\nThank you for using the Selection Sort Program. Have a nice day!");
    }
}