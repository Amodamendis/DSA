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
 * FIFO Queue implementation using Deque operations
 */
class FIFOQueueDeque {
    private LinkedList<Integer> deque;
    
    public FIFOQueueDeque() {
        deque = new LinkedList<>();
    }
    
    // Enqueue element (add to rear for FIFO)
    public void enqueue(int element) {
        deque.addLast(element); // Add to rear for FIFO behavior
        System.out.println("Enqueued: " + element);
    }
    
    // Dequeue element (remove from front for FIFO)
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return deque.removeFirst(); // Remove from front for FIFO behavior
    }
    
    // Peek at front element without removing
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return deque.peekFirst();
    }
    
    // Add to front (deque operation)
    public void addFront(int element) {
        deque.addFirst(element);
        System.out.println("Added to front: " + element);
    }
    
    // Remove from rear (deque operation)
    public int removeRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.removeLast();
    }
    
    // Peek at rear element
    public int peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("Deque is empty");
        }
        return deque.peekLast();
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
            System.out.println("FIFO Queue is empty");
            return;
        }
        System.out.println("FIFO Queue (front to rear): " + deque);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        FIFOQueueDeque fifoQueue = new FIFOQueueDeque();
        
        System.out.println("FIFO Queue using Deque Operations:");
        System.out.println("1. Enqueue (add to rear)");
        System.out.println("2. Dequeue (remove from front)");
        System.out.println("3. Peek front");
        System.out.println("4. Add to front");
        System.out.println("5. Remove from rear");
        System.out.println("6. Peek rear");
        System.out.println("7. Display queue");
        System.out.println("8. Show size");
        System.out.println("9. Check if empty");
        System.out.println("10. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int enqueueElement = scanner.nextInt();
                    fifoQueue.enqueue(enqueueElement);
                    break;
                case 2:
                    try {
                        int dequeued = fifoQueue.dequeue();
                        System.out.println("Dequeued element: " + dequeued);
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 3:
                    try {
                        int front = fifoQueue.peek();
                        System.out.println("Front element: " + front);
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 4:
                    System.out.print("Enter element to add to front: ");
                    int frontElement = scanner.nextInt();
                    fifoQueue.addFront(frontElement);
                    break;
                case 5:
                    try {
                        int removedRear = fifoQueue.removeRear();
                        System.out.println("Removed from rear: " + removedRear);
                    } catch (NoSuchElementException e) {
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 6:
                    try {
                        int rear = fifoQueue.peekRear();
                        System.out.println("Rear element: " + rear);
                    } catch (NoSuchElementException e) {
                        System.out.println("Deque is empty!");
                    }
                    break;
                case 7:
                    fifoQueue.display();
                    break;
                case 8:
                    System.out.println("Size: " + fifoQueue.size());
                    break;
                case 9:
                    System.out.println("Is empty: " + fifoQueue.isEmpty());
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
