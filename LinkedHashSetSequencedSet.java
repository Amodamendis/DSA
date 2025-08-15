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
 * LinkedHashSet implementation that maintains insertion order
 */
class LinkedHashSetSequencedSet {
    // Node for maintaining insertion order
    static class Node {
        int data;
        Node next, prev; // For doubly linked list
        
        Node(int data) {
            this.data = data;
        }
    }
    
    private HashMap<Integer, Node> map; // For O(1) lookup
    private Node head, tail; // For maintaining order
    private int size = 0;
    
    public LinkedHashSetSequencedSet() {
        map = new HashMap<>();
        head = new Node(-1); // Dummy head
        tail = new Node(-1); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }
    
    // Add element maintaining insertion order
    public boolean add(int element) {
        if (map.containsKey(element)) {
            return false; // Element already exists
        }
        
        Node newNode = new Node(element);
        map.put(element, newNode);
        
        // Add to end of linked list
        Node prev = tail.prev;
        prev.next = newNode;
        newNode.prev = prev;
        newNode.next = tail;
        tail.prev = newNode;
        
        size++;
        return true;
    }
    
    // Remove element
    public boolean remove(int element) {
        Node node = map.get(element);
        if (node == null) {
            return false;
        }
        
        // Remove from linked list
        node.prev.next = node.next;
        node.next.prev = node.prev;
        
        map.remove(element);
        size--;
        return true;
    }
    
    // Check if element exists
    public boolean contains(int element) {
        return map.containsKey(element);
    }
    
    // Display elements in insertion order
    public void display() {
        System.out.print("LinkedHashSet (insertion order): {");
        Node current = head.next;
        boolean first = true;
        
        while (current != tail) {
            if (!first) System.out.print(", ");
            System.out.print(current.data);
            current = current.next;
            first = false;
        }
        System.out.println("}");
    }
    
    // Get first element
    public int getFirst() {
        if (size == 0) throw new NoSuchElementException("Set is empty");
        return head.next.data;
    }
    
    // Get last element
    public int getLast() {
        if (size == 0) throw new NoSuchElementException("Set is empty");
        return tail.prev.data;
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashSetSequencedSet set = new LinkedHashSetSequencedSet();
        
        System.out.println("LinkedHashSet Sequenced Operations:");
        System.out.println("1. Add element");
        System.out.println("2. Remove element");
        System.out.println("3. Check if contains");
        System.out.println("4. Display set");
        System.out.println("5. Get first element");
        System.out.println("6. Get last element");
        System.out.println("7. Show size");
        System.out.println("8. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int element = scanner.nextInt();
                    if (set.add(element)) {
                        System.out.println("Element added successfully!");
                    } else {
                        System.out.println("Element already exists!");
                    }
                    break;
                case 2:
                    System.out.print("Enter element to remove: ");
                    int removeElement = scanner.nextInt();
                    if (set.remove(removeElement)) {
                        System.out.println("Element removed successfully!");
                    } else {
                        System.out.println("Element not found!");
                    }
                    break;
                case 3:
                    System.out.print("Enter element to check: ");
                    int checkElement = scanner.nextInt();
                    System.out.println("Contains " + checkElement + ": " + set.contains(checkElement));
                    break;
                case 4:
                    set.display();
                    break;
                case 5:
                    try {
                        System.out.println("First element: " + set.getFirst());
                    } catch (NoSuchElementException e) {
                        System.out.println("Set is empty!");
                    }
                    break;
                case 6:
                    try {
                        System.out.println("Last element: " + set.getLast());
                    } catch (NoSuchElementException e) {
                        System.out.println("Set is empty!");
                    }
                    break;
                case 7:
                    System.out.println("Size: " + set.size());
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

