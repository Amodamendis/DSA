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
 * Stack implementation using Queue operations
 */
class StackQueue {
    private Queue<Integer> queue1; // Primary queue
    private Queue<Integer> queue2; // Temporary queue
    
    public StackQueue() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    
    // Push element onto stack
    public void push(int element) {
        // Add element to queue2
        queue2.offer(element);
        
        // Move all elements from queue1 to queue2
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        
        // Swap references so queue1 becomes primary again
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
        
        System.out.println("Pushed: " + element);
    }
    
    // Pop element from stack
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        
        return queue1.poll();
    }
    
    // Peek at top element without removing
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        
        return queue1.peek();
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return queue1.isEmpty();
    }
    
    // Get size of stack
    public int size() {
        return queue1.size();
    }
    
    // Display stack contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.println("Stack (top to bottom): " + queue1);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StackQueue stack = new StackQueue();
        
        System.out.println("Stack using Queue Operations:");
        System.out.println("1. Push element");
        System.out.println("2. Pop element");
        System.out.println("3. Peek top element");
        System.out.println("4. Display stack");
        System.out.println("5. Show size");
        System.out.println("6. Check if empty");
        System.out.println("7. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int element = scanner.nextInt();
                    stack.push(element);
                    break;
                case 2:
                    try {
                        int popped = stack.pop();
                        System.out.println("Popped element: " + popped);
                    } catch (NoSuchElementException e) {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case 3:
                    try {
                        int top = stack.peek();
                        System.out.println("Top element: " + top);
                    } catch (NoSuchElementException e) {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case 4:
                    stack.display();
                    break;
                case 5:
                    System.out.println("Size: " + stack.size());
                    break;
                case 6:
                    System.out.println("Is empty: " + stack.isEmpty());
                    break;
                case 7:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}