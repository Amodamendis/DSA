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
 * Dynamic Array (ArrayList) implementation
 */
class ArrayListImpl {
    private int[] array;
    private int size;
    private int capacity;
    
    // Constructor with default capacity
    public ArrayListImpl() {
        this(10);
    }
    
    // Constructor with custom capacity
    public ArrayListImpl(int initialCapacity) {
        capacity = initialCapacity;
        array = new int[capacity];
        size = 0;
    }
    
    // Add element to end of list
    public void add(int element) {
        ensureCapacity();
        array[size++] = element;
        System.out.println("Added: " + element);
    }
    
    // Add element at specific index
    public void add(int index, int element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        
        ensureCapacity();
        
        // Shift elements to right
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        
        array[index] = element;
        size++;
        System.out.println("Added " + element + " at index " + index);
    }
    
    // Get element at index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return array[index];
    }
    
    // Set element at index
    public void set(int index, int element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        array[index] = element;
        System.out.println("Set element at index " + index + " to " + element);
    }
    
    // Remove element at index
    public int remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        
        int removedElement = array[index];
        
        // Shift elements to left
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        
        size--;
        return removedElement;
    }
    
    // Check if contains element
    public boolean contains(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return true;
            }
        }
        return false;
    }
    
    // Find index of element
    public int indexOf(int element) {
        for (int i = 0; i < size; i++) {
            if (array[i] == element) {
                return i;
            }
        }
        return -1; // Not found
    }
    
    // Ensure capacity for new elements
    private void ensureCapacity() {
        if (size >= capacity) {
            capacity *= 2;
            int[] newArray = new int[capacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            System.out.println("Array resized to capacity: " + capacity);
        }
    }
    
    // Get current size
    public int size() {
        return size;
    }
    
    // Check if empty
    public boolean isEmpty() {
        return size == 0;
    }
    
    // Display all elements
    public void display() {
        if (isEmpty()) {
            System.out.println("ArrayList is empty");
            return;
        }
        
        System.out.print("ArrayList: [");
        for (int i = 0; i < size; i++) {
            System.out.print(array[i]);
            if (i < size - 1) System.out.print(", ");
        }
        System.out.println("]");
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter initial capacity (or press Enter for default 10): ");
        String input = scanner.nextLine();
        
        ArrayListImpl list;
        if (input.trim().isEmpty()) {
            list = new ArrayListImpl();
        } else {
            int capacity = Integer.parseInt(input);
            list = new ArrayListImpl(capacity);
        }
        
        System.out.println("\nArrayList Operations:");
        System.out.println("1. Add element");
        System.out.println("2. Add at index");
        System.out.println("3. Get element");
        System.out.println("4. Set element");
        System.out.println("5. Remove element");
        System.out.println("6. Contains element");
        System.out.println("7. Find index");
        System.out.println("8. Display list");
        System.out.println("9. Show size");
        System.out.println("10. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int element = scanner.nextInt();
                    list.add(element);
                    break;
                case 2:
                    System.out.print("Enter index: ");
                    int index = scanner.nextInt();
                    System.out.print("Enter element: ");
                    int indexElement = scanner.nextInt();
                    try {
                        list.add(index, indexElement);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Enter index to get: ");
                    int getIndex = scanner.nextInt();
                    try {
                        int value = list.get(getIndex);
                        System.out.println("Element at index " + getIndex + ": " + value);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.print("Enter index to set: ");
                    int setIndex = scanner.nextInt();
                    System.out.print("Enter new value: ");
                    int setValue = scanner.nextInt();
                    try {
                        list.set(setIndex, setValue);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Enter index to remove: ");
                    int removeIndex = scanner.nextInt();
                    try {
                        int removed = list.remove(removeIndex);
                        System.out.println("Removed element: " + removed);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;
                case 6:
                    System.out.print("Enter element to check: ");
                    int checkElement = scanner.nextInt();
                    boolean contains = list.contains(checkElement);
                    System.out.println("Contains " + checkElement + ": " + contains);
                    break;
                case 7:
                    System.out.print("Enter element to find index: ");
                    int findElement = scanner.nextInt();
                    int foundIndex = list.indexOf(findElement);
                    if (foundIndex != -1) {
                        System.out.println("Index of " + findElement + ": " + foundIndex);
                    } else {
                        System.out.println("Element " + findElement + " not found");
                    }
                    break;
                case 8:
                    list.display();
                    break;
                case 9:
                    System.out.println("Size: " + list.size());
                    break;
                case 10:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}