import java.util.*;

/**
 * Stack implementation using Array with dynamic resizing
 */
class ArrayStack {
    private int[] stack;
    private int top;
    private int capacity;
    
    // Constructor
    public ArrayStack(int initialCapacity) {
        capacity = initialCapacity;
        stack = new int[capacity];
        top = -1;
    }
    
    // Push element onto stack
    public void push(int element) {
        // Resize if needed
        if (top == capacity - 1) {
            resize();
        }
        
        stack[++top] = element;
        System.out.println("Pushed: " + element);
    }
    
    // Pop element from stack
    public int pop() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        
        return stack[top--];
    }
    
    // Peek at top element without removing
    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        
        return stack[top];
    }
    
    // Check if stack is empty
    public boolean isEmpty() {
        return top == -1;
    }
    
    // Get current size
    public int size() {
        return top + 1;
    }
    
    // Get current capacity
    public int getCapacity() {
        return capacity;
    }
    
    // Resize array when needed
    private void resize() {
        capacity *= 2;
        int[] newStack = new int[capacity];
        System.arraycopy(stack, 0, newStack, 0, top + 1);
        stack = newStack;
        System.out.println("Stack resized to capacity: " + capacity);
    }
    
    // Display stack contents
    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }
        
        System.out.print("Stack (top to bottom): ");
        for (int i = top; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter initial capacity for stack: ");
        int initialCapacity = scanner.nextInt();
        ArrayStack stack = new ArrayStack(initialCapacity);
        
        System.out.println("\nArray Stack Operations:");
        System.out.println("1. Push element");
        System.out.println("2. Pop element");
        System.out.println("3. Peek top element");
        System.out.println("4. Display stack");
        System.out.println("5. Show size");
        System.out.println("6. Show capacity");
        System.out.println("7. Check if empty");
        System.out.println("8. Exit");
        
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
                    System.out.println("Capacity: " + stack.getCapacity());
                    break;
                case 7:
                    System.out.println("Is empty: " + stack.isEmpty());
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