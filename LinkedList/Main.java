package LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList(1);

        // linkedList.getHead();
        // linkedList.getTail();
        // linkedList.getLength();
        linkedList.append(2);
        linkedList.append(3);

        linkedList.append(7);
        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(12);
        linkedList.append(13);
        linkedList.append(15);
        linkedList.append(14);



        linkedList.printList();
        System.out.println(linkedList.get(5).value);



        DoublyLinkedList myDLL = new DoublyLinkedList(7);
    }
}
