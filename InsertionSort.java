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
 * Insertion Sort Algorithm Implementation
 * Time Complexity: O(n²) in worst case, O(n) in best case
 * Space Complexity: O(1)
 */
public class InsertionSort {
    
    /**
     * Insertion sort algorithm - builds sorted array one element at a time
     * @param arr Array to be sorted
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        
        System.out.println("Starting Insertion Sort...");
        System.out.print("Initial array: ");
        printArray(arr);
        
        // Start from second element (index 1)
        for (int i = 1; i < n; i++) {
            int key = arr[i]; // Current element to be positioned
            int j = i - 1;    // Index of last element in sorted portion
            
            System.out.println("\nStep " + i + ": Inserting " + key);
            System.out.println("Sorted portion: " + Arrays.toString(Arrays.copyOfRange(arr, 0, i)));
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                System.out.println("Moving " + arr[j] + " one position right");
                arr[j + 1] = arr[j];
                j--;
            }
            
            // Insert key at correct position
            arr[j + 1] = key;
            System.out.println("Inserted " + key + " at position " + (j + 1));
            
            // Print array after each step
            System.out.print("Array after step " + i + ": ");
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
        
        System.out.println("=== Insertion Sort Algorithm ===");
        
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
        
        // Perform insertion sort
        insertionSort(arr);
        
        // Display final sorted array
        System.out.print("\nFinal sorted array: ");
        printArray(arr);
        
        sc.close();
    }
}