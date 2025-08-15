/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
import java.util.*;

/**
 * Selection Sort Algorithm Implementation
 * Time Complexity: O(n²) in all cases
 * Space Complexity: O(1)
 */
public class SelectionSort {
    
    /**
     * Selection sort algorithm - finds minimum element and places it at beginning
     * @param arr Array to be sorted
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        
        System.out.println("Starting Selection Sort...");
        System.out.print("Initial array: ");
        printArray(arr);
        
        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) {
            // Find minimum element in remaining unsorted array
            int minIndex = i;
            
            System.out.println("\nStep " + (i + 1) + ": Finding minimum from position " + i);
            System.out.println("Sorted portion: " + Arrays.toString(Arrays.copyOfRange(arr, 0, i)));
            System.out.println("Unsorted portion: " + Arrays.toString(Arrays.copyOfRange(arr, i, n)));
            
            // Search for minimum element
            for (int j = i + 1; j < n; j++) {
                System.out.println("Comparing " + arr[minIndex] + " with " + arr[j]);
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                    System.out.println("New minimum found: " + arr[j] + " at index " + j);
                }
            }
            
            // Swap minimum element with first element of unsorted portion
            if (minIndex != i) {
                System.out.println("Swapping " + arr[i] + " with " + arr[minIndex]);
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            } else {
                System.out.println("No swap needed - " + arr[i] + " is already minimum");
            }
            
            // Print array after each step
            System.out.print("Array after step " + (i + 1) + ": ");
            printArray(arr);
        }
    }
    
    /**
     * Helper method to print array
     * @param arr Array to print
     */
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Selection Sort Algorithm ===");
        
        // Input array size
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();
        
        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            arr[i] = sc.nextInt();
        }
        
        // Perform selection sort
        selectionSort(arr);
        
        // Display final sorted array
        System.out.print("\nFinal sorted array: ");
        printArray(arr);
        
        sc.close();
    }
}