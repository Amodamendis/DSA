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
 * Queue implementation using ArrayList
 * FIFO (First In First Out) data structure
 */
class ListQueue<T> {
    private ArrayList<T> queue;
    
    // Constructor
    public ListQueue() {
        queue = new ArrayList<>();
    }
    
    // Add element to rear of queue
    public void enqueue(T item) {
        queue.add(item);
        System.out.println("Enqueued: " + item);
    }
    
    // Remove element from front of queue
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        T item = queue.remove(0);
        System.out.println("Dequeued: " + item);
        return item;
    }
    
    // Peek at front element without removing
    public T front() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return queue.get(0);
    }
    
    // Peek at rear element
    public T rear() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }
        return queue.get(queue.size() - 1);
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }
    
    // Get queue size
    public int size() {
        return queue.size();
    }
    
    // Display queue contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue (front to rear): ");
        for (T item : queue) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ListQueue<Integer> queue = new ListQueue<>();
        
        System.out.println("=== Queue Operations ===");
        
        while (true) {
            System.out.println("\n1. Enqueue  2. Dequeue  3. Front  4. Rear  5. Display  6. Exit");
            System.out.print("Choose operation: ");
            int choice = sc.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter value to enqueue: ");
                    int value = sc.nextInt();
                    queue.enqueue(value);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    Integer front = queue.front();
                    if (front != null) {
                        System.out.println("Front element: " + front);
                    }
                    break;
                case 4:
                    Integer rear = queue.rear();
                    if (rear != null) {
                        System.out.println("Rear element: " + rear);
                    }
                    break;
                case 5:
                    queue.display();
                    break;
                case 6:
                    System.out.println("Goodbye!");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}