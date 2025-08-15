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
 * Priority Queue implementation using Min-Heap
 */
class PriorityQueueQueue {
    private ArrayList<Integer> heap;
    
    public PriorityQueueQueue() {
        heap = new ArrayList<>();
    }
    
    // Get parent index
    private int parent(int index) {
        return (index - 1) / 2;
    }
    
    // Get left child index
    private int leftChild(int index) {
        return 2 * index + 1;
    }
    
    // Get right child index
    private int rightChild(int index) {
        return 2 * index + 2;
    }
    
    // Swap elements
    private void swap(int i, int j) {
        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
    
    // Add element (enqueue with priority)
    public void add(int element) {
        heap.add(element);
        heapifyUp(heap.size() - 1);
    }
    
    // Remove and return highest priority element (smallest in min-heap)
    public int poll() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        int min = heap.get(0);
        int lastElement = heap.get(heap.size() - 1);
        heap.set(0, lastElement);
        heap.remove(heap.size() - 1);
        
        if (!isEmpty()) {
            heapifyDown(0);
        }
        
        return min;
    }
    
    // Peek at highest priority element
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        return heap.get(0);
    }
    
    // Maintain heap property upward
    private void heapifyUp(int index) {
        while (index > 0 && heap.get(index) < heap.get(parent(index))) {
            swap(index, parent(index));
            index = parent(index);
        }
    }
    
    // Maintain heap property downward
    private void heapifyDown(int index) {
        int smallest = index;
        int left = leftChild(index);
        int right = rightChild(index);
        
        if (left < heap.size() && heap.get(left) < heap.get(smallest)) {
            smallest = left;
        }
        
        if (right < heap.size() && heap.get(right) < heap.get(smallest)) {
            smallest = right;
        }
        
        if (smallest != index) {
            swap(index, smallest);
            heapifyDown(smallest);
        }
    }
    
    public boolean isEmpty() {
        return heap.isEmpty();
    }
    
    public int size() {
        return heap.size();
    }
    
    // Display current heap
    public void display() {
        System.out.println("Priority Queue (Min-Heap): " + heap);
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueueQueue pq = new PriorityQueueQueue();
        
        System.out.println("Priority Queue Operations:");
        System.out.println("1. Add element");
        System.out.println("2. Poll (remove highest priority)");
        System.out.println("3. Peek (view highest priority)");
        System.out.println("4. Display queue");
        System.out.println("5. Show size");
        System.out.println("6. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int element = scanner.nextInt();
                    pq.add(element);
                    System.out.println("Element added successfully!");
                    break;
                case 2:
                    try {
                        int polled = pq.poll();
                        System.out.println("Polled element: " + polled);
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 3:
                    try {
                        int peeked = pq.peek();
                        System.out.println("Highest priority element: " + peeked);
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 4:
                    pq.display();
                    break;
                case 5:
                    System.out.println("Size: " + pq.size());
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