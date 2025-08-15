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
 * Stack implementation using ArrayList
 * LIFO (Last In First Out) data structure
 */
class ListStack<T> {
    private ArrayList<T> stack;
    
    // Constructor
    public ListStack() {
        stack = new ArrayList<>();
    }
    
    // Push element to top of stack
    public void push(T item) {
        stack.add(item);
        System.out.println("Pushed: " + item);
    }
    
    // Pop element from top of stack
    public T pop() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        T item = stack.remove(stack.size() - 1);
        System.out.println("Popped: " + item);
        return item;
    }
    
    // Peek at top element without removing
    public T peek() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return null;
        }
        return stack.get(stack.size() - 1);
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return stack.isEmpty();
    }
    
    // Get stack size
    public int size() {
        return stack.size();
    }
    
    // Display stack contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty!");
            return;
        }
        System.out.print("Stack (top to bottom): ");
        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i) + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListStack<Integer> stack = new ListStack<>();
        
        System.out.println("=== Stack Operations ===");
        
        while (true) {
            System.out.println("\n1. Push  2. Pop  3. Peek  4. Display  5. Exit");
            System.out.print("Choose operation: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = sc.nextInt();
                    stack.push(value);
                    break;
                case 2:
                    stack.pop();
                    break;
                case 3:
                    Integer top = stack.peek();
                    if (top != null) {
                        System.out.println("Top element: " + top);
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
