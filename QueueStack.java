import java.util.*;

/**
 * Queue implementation using Stack operations
 */
class QueueStack {
    private Stack<Integer> stack1; // For enqueue operations
    private Stack<Integer> stack2; // For dequeue operations
    
    public QueueStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    // Add element to queue (enqueue)
    public void enqueue(int element) {
        stack1.push(element);
        System.out.println("Enqueued: " + element);
    }
    
    // Remove element from queue (dequeue)
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.pop();
    }
    
    // Peek at front element without removing
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
        
        // If stack2 is empty, move all elements from stack1 to stack2
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        
        return stack2.peek();
    }
    
    // Check if queue is empty
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
    
    // Get size of queue
    public int size() {
        return stack1.size() + stack2.size();
    }
    
    // Display queue state
    public void display() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return;
        }
        
        // Create temporary stacks to preserve order
        Stack<Integer> temp1 = new Stack<>();
        Stack<Integer> temp2 = new Stack<>();
        
        // Copy stack2 elements (these are in correct order for dequeue)
        temp2.addAll(stack2);
        
        // Copy stack1 elements (need to reverse for correct queue order)
        temp1.addAll(stack1);
        
        System.out.print("Queue (front to rear): ");
        
        // Print stack2 elements first (front of queue)
        if (!temp2.isEmpty()) {
            Stack<Integer> reversed2 = new Stack<>();
            while (!temp2.isEmpty()) {
                reversed2.push(temp2.pop());
            }
            while (!reversed2.isEmpty()) {
                System.out.print(reversed2.pop() + " ");
            }
        }
        
        // Print stack1 elements (rear of queue)
        while (!temp1.isEmpty()) {
            System.out.print(temp1.pop() + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        QueueStack queue = new QueueStack();
        
        System.out.println("Queue using Stack Operations:");
        System.out.println("1. Enqueue (add element)");
        System.out.println("2. Dequeue (remove element)");
        System.out.println("3. Peek (view front element)");
        System.out.println("4. Display queue");
        System.out.println("5. Show size");
        System.out.println("6. Check if empty");
        System.out.println("7. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to enqueue: ");
                    int element = scanner.nextInt();
                    queue.enqueue(element);
                    break;
                case 2:
                    try {
                        int dequeued = queue.dequeue();
                        System.out.println("Dequeued element: " + dequeued);
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 3:
                    try {
                        int front = queue.peek();
                        System.out.println("Front element: " + front);
                    } catch (NoSuchElementException e) {
                        System.out.println("Queue is empty!");
                    }
                    break;
                case 4:
                    queue.display();
                    break;
                case 5:
                    System.out.println("Size: " + queue.size());
                    break;
                case 6:
                    System.out.println("Is empty: " + queue.isEmpty());
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