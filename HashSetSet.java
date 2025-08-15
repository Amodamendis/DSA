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
 * Simple HashSet implementation using array and chaining for collision resolution
 */
class HashSetSet {
    private static final int DEFAULT_CAPACITY = 16;
    private LinkedList<Integer>[] buckets;
    private int size = 0;
    
    @SuppressWarnings("unchecked")
    public HashSetSet() {
        buckets = new LinkedList[DEFAULT_CAPACITY];
        for (int i = 0; i < DEFAULT_CAPACITY; i++) {
            buckets[i] = new LinkedList<>();
        }
    }
    
    // Hash function
    private int hash(int key) {
        return Math.abs(key) % buckets.length;
    }
    
    // Add element (no duplicates)
    public boolean add(int element) {
        int index = hash(element);
        LinkedList<Integer> bucket = buckets[index];
        
        // Check if element already exists
        if (bucket.contains(element)) {
            return false; // Element already exists
        }
        
        bucket.add(element);
        size++;
        return true;
    }
    
    // Check if element exists
    public boolean contains(int element) {
        int index = hash(element);
        return buckets[index].contains(element);
    }
    
    // Remove element
    public boolean remove(int element) {
        int index = hash(element);
        LinkedList<Integer> bucket = buckets[index];
        
        if (bucket.remove(Integer.valueOf(element))) {
            size--;
            return true;
        }
        return false;
    }
    
    // Display all elements
    public void display() {
        System.out.print("HashSet: {");
        boolean first = true;
        for (LinkedList<Integer> bucket : buckets) {
            for (Integer element : bucket) {
                if (!first) System.out.print(", ");
                System.out.print(element);
                first = false;
            }
        }
        System.out.println("}");
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSetSet hashSet = new HashSetSet();
        
        System.out.println("HashSet Operations:");
        System.out.println("1. Add element");
        System.out.println("2. Remove element");
        System.out.println("3. Check if contains");
        System.out.println("4. Display set");
        System.out.println("5. Show size");
        System.out.println("6. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int element = scanner.nextInt();
                    if (hashSet.add(element)) {
                        System.out.println("Element added successfully!");
                    } else {
                        System.out.println("Element already exists!");
                    }
                    break;
                case 2:
                    System.out.print("Enter element to remove: ");
                    int removeElement = scanner.nextInt();
                    if (hashSet.remove(removeElement)) {
                        System.out.println("Element removed successfully!");
                    } else {
                        System.out.println("Element not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter element to check: ");
                    int checkElement = scanner.nextInt();
                    if (hashSet.contains(checkElement)) {
                        System.out.println("Element exists in the set!");
                    } else {
                        System.out.println("Element does not exist!");
                    }
                    break;
                case 4:
                    hashSet.display();
                    break;
                case 5:
                    System.out.println("Size: " + hashSet.size());
                    break;
                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

