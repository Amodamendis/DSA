/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Administrator
 */
/**
 * LinkedListCollection - A simple singly linked list implementation
 * Each node contains data and a reference to the next node
 */
import java.util.*;

/**
 * LinkedList implementation with basic operations
 */
class LinkedListCollection {
    // Node class for linked list
    static class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    
    // Add element to the end
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }
    
    // Display all elements
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }
    
    // Remove element by value
    public boolean remove(int data) {
        if (head == null) return false;
        
        if (head.data == data) {
            head = head.next;
            return true;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            return true;
        }
        return false;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedListCollection list = new LinkedListCollection();
        
        System.out.println("LinkedList Operations:");
        System.out.println("1. Add element");
        System.out.println("2. Remove element");
        System.out.println("3. Display list");
        System.out.println("4. Exit");
        
        while (true) {
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    System.out.print("Enter element to add: ");
                    int element = scanner.nextInt();
                    list.add(element);
                    System.out.println("Element added successfully!");
                    break;
                case 2:
                    System.out.print("Enter element to remove: ");
                    int removeElement = scanner.nextInt();
                    if (list.remove(removeElement)) {
                        System.out.println("Element removed successfully!");
                    } else {
                        System.out.println("Element not found!");
                    }
                    break;
                case 3:
                    System.out.print("Current list: ");
                    list.display();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}