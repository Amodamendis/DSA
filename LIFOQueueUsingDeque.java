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
 * LIFO Queue (Stack) implementation using Deque operations
 */
class LIFOQueueDeque {
    private LinkedList<Integer> deque;
    
    public LIFOQueueDeque() {
        deque = new LinkedList<>();
    }
    
    // Push element to top (LIFO - Last In, First Out)
    public void push(int element) {
        deque.addFirst(element); // Add to front for LIFO behavior
        System.out.println("Pushed: " + element);
    }
    
    // Pop element from top
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return deque.removeFirst(); // Remove from front for LIFO behavior
    }
    
    // Peek at top element without removing
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        return deque.peekFirst();
    }
    
    // Add to rear (queue operation)
    public void addRear(int element) {
        deque.addLast(element);
        System.out.println("Added to rear: " + element);
    }
    
    // Remove from rear
    public int removeRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeLast();
    }
    
    // Check if empty
    public boolean isEmpty() {
        return deque.isEmpty();
    }
    
    // Get size
    public int size() {
        return deque.size();
    }
    
    // Display current state
    public void display() {
        if (isEmpty()) {
            System.out.println("LIFO Queue is empty");
            return;
        }
        System.out.println("LIFO Queue (top to bottom): " + deque);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LIFOQueueDeque lifoQueue = new LIFOQueueDeque();
        
        System.out.println("LIFO Queue (Stack) using Deque Operations:");
        System.out.println("1. Push (add to top)");
        System.out.println("2. Pop (remove from top)");
        System.out.println("3. Peek (view top element)");
        System.out.println("4. Add to rear");
        System.out.println("5. Remove from rear");
        System.out.println("6. Display queue");
        System.out.println("7. Show size");
        System.out.println("8. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to push: ");
                    int pushElement = scanner.nextInt();
                    lifoQueue.push(pushElement);
                    break;
                case 2:
                    try {
                        int popped = lifoQueue.pop();
                        System.out.println("Popped element: " + popped);
                    } catch (NoSuchElementException e) {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case 3:
                    try {
                        int peeked = lifoQueue.peek();
                        System.out.println("Top element: " + peeked);
                    } catch (NoSuchElementException e) {
                        System.out.println("Stack is empty!");
                    }
                    break;
                case 4:
                    System.out.print("Enter element to add to rear: ");
                    int rearElement = scanner.nextInt();
                    lifoQueue.addRear(rearElement);
                    break;
                case 5:
                    try {
                        int removedRear = lifoQueue.removeRear();
                        System.out.println("Removed from rear: " + removedRear);
                    } catch (NoSuchElementException e) {
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 6:
                    lifoQueue.display();
                    break;
                case 7:
                    System.out.println("Size: " + lifoQueue.size());
                    break;
                case 8:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}

