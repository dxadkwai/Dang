package LinkedList;

import LinkedList.LinkedList.Node;

public class DoublyLinkedList {
    private Node head;
    private Node tail;
    private int length;

    public static class Node{
        int value;
        Node next;
        Node prev;

        Node(int value) {
            this.value = value;
        }
    }

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head=newNode;
        tail=newNode;
        length = 1;
    }
    
    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head =newNode;
            tail = newNode;

        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        length ++;

    }


    public Node removeLast() {
        if (length==0) return null;
        Node temp =tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        if (length==0) {
            head =null;
            tail = null;
        }
        return temp;
    }

    
}
