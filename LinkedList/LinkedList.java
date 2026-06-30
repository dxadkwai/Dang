package LinkedList;

public class LinkedList {


    //instantiate head, tail and length to keep track of the list
    private Node head;
    private Node tail;
    public int length;


    // an internal class inside LinkedList that will always be creates with each method
    class Node{

        int value;
        Node next;

        // method to create a new node
        Node (int value) {
            this.value = value;
            next = null;
        }
    }   

    // create a linkedlist using a node method
    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }


    // use to print out the linked list
    public void printList() {
        Node temp = head;
        while(temp!=null) {
            System.out.println(temp.value);
            temp=temp.next;
        }
    }

    public void getHead() {
        System.out.println("Head: " + head.value);
    }

    public void getTail() {
        System.out.println("Tail: " + tail.value);
    }

    public void getLength() {
        System.out.println("Length: " + length);
    }


    public void append(int value) {
        Node newNode = new Node(value);
        if(length == 0) {
            head = newNode;
            tail = newNode;
        } else{
            tail.next = newNode;
            tail = newNode;
        }
        length++;

    }


    // add one item to your linked list
    public void prepend(int value) {
        Node newNode =new Node(value);
        if (length == 0) {
            head = newNode;
            tail =newNode;
        } else {
            newNode.next = head;
            head = newNode;
            
        }
        length ++;
    }


    // remove last item in the linked list
    public Node removeLast() {
        // case where there is no item --> automatically return null because there is no linked list there
        if (length == 0) return null;   

        // create temp and pre to iterate through the linked list from the head
        Node pre = head;
        Node temp = head;

        // normal case
        while (temp.next != null) {
            pre = temp;
            temp = temp.next;
        }
        tail = pre;
        tail.next = null;
        length--;

        //edge case --> this is the linkedlist after decrement by 1 item
        if (length == 0) {
            head = null;
            tail = null;

        }
        return temp;

    }
    // remove first item
    public Node removeFirst() {

        if (length == 0) return null;

        Node pre = head;
        head = pre.next;
        pre.next = head;
        length--;

        
        if (length == 0) {
            head = null;
            tail = null;
        }
        return pre;

    }

    public Node get(int index) {
        if (index<0 ||index >= length) return null;
        if(index > length - 1) return null;

        Node temp = head;

        for (int i = 0; i<length; i++) {
            temp = temp.next;
        }
        return temp;

    }
    public boolean set(int index, int value) {
        Node temp = get(index);

        if (temp!= null) {
            temp.value = value;
            return true;
        } 
        return false;
        
    }

    public boolean insert (int index, int value) {
        
        if (index <0 || index >length) return false;
        if (index ==0) {
            prepend(value);

            return true;
        } else if (index == length ){
            append(value);
            return true;
        }

        Node temp = get (index-1);
        Node newNode = new Node(value);
        newNode.next = temp.next;
        temp.next=newNode;
        length++;

        return true;
        
    }

    public Node remove(int index) {
            if (index<0 || index>=length) return null;
            if (index==0) return removeFirst();
            if (index == length-1) return removeLast();

            Node prev = get(index - 1);
            Node temp = prev.next;
            prev.next=temp.next;
            temp.next=null;
            length--;
            return temp;

            
    }

    public void reverse() {
        Node temp =head;
        head =tail;
        tail = temp;

        Node after = temp.next;
        Node before =null;
        for (int i =0; i<length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp=after;
            
        }




    }
}



