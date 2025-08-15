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
 * LinkedList with sequence-based operations (add at specific positions)
 */
class LinkedListSequencedCollection {
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private int size = 0;
    
    // Add element at specific index
    public void addAt(int index, int data) {
        if (index < 0 || index > size) {
            System.out.println("Invalid index!");
            return;
        }
        
        Node newNode = new Node(data);
        
        if (index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        size++;
    }
    
    // Get element at specific index
    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid index!");
        }
        
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }
    
    // Display list with indices
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        int index = 0;
        while (current != null) {
            System.out.print("[" + index + "]:" + current.data + " ");
            current = current.next;
            index++;
        }
        System.out.println();
    }
    
    public int size() {
        return size;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListSequencedCollection list = new LinkedListSequencedCollection();
        
        System.out.println("LinkedList Sequenced Collection Operations:");
        System.out.println("1. Add at index");
        System.out.println("2. Get element at index");
        System.out.println("3. Display list");
        System.out.println("4. Show size");
        System.out.println("5. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter index (0 to " + list.size() + "): ");
                    int index = scanner.nextInt();
                    System.out.print("Enter element: ");
                    int element = scanner.nextInt();
                    list.addAt(index, element);
                    System.out.println("Element added successfully!");
                    break;
                case 2:
                    System.out.print("Enter index to get element: ");
                    int getIndex = scanner.nextInt();
                    try {
                        int value = list.get(getIndex);
                        System.out.println("Element at index " + getIndex + ": " + value);
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    System.out.print("Current list: ");
                    list.display();
                    break;
                case 4:
                    System.out.println("Size: " + list.size());
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}