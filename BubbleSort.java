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
 * Bubble Sort Algorithm Implementation
 * Time Complexity: O(n²) in worst case, O(n) in best case
 * Space Complexity: O(1)
 */
public class BubbleSort {
    
    /**
     * Bubble sort algorithm - repeatedly swaps adjacent elements if in wrong order
     * @param arr Array to be sorted
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        boolean swapped;
        
        System.out.println("Starting Bubble Sort...");
        
        // Outer loop for number of passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;
            
            System.out.println("\nPass " + (i + 1) + ":");
            
            // Inner loop for comparisons in each pass
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print("Comparing " + arr[j] + " and " + arr[j + 1] + ": ");
                
                // Swap if elements are in wrong order
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                    System.out.println("Swapped!");
                } else {
                    System.out.println("No swap needed");
                }
            }
            
            // Print array after each pass
            System.out.print("Array after pass " + (i + 1) + ": ");
            printArray(arr);
            
            // If no swapping occurred, array is sorted
            if (!swapped) {
                System.out.println("Array is already sorted!");
                break;
            }
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
        
        System.out.println("=== Bubble Sort Algorithm ===");
        
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
        
        // Display original array
        System.out.print("\nOriginal array: ");
        printArray(arr);
        
        // Perform bubble sort
        bubbleSort(arr);
        
        // Display sorted array
        System.out.print("\nFinal sorted array: ");
        printArray(arr);
        
        sc.close();
    }
}
