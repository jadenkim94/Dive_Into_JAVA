package algorithm.datastructure.linkedlist;

public class LinkedListTester {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(1);
        linkedList.printList();
        linkedList.addFirst(2);
        linkedList.printList();
        linkedList.deleteFirst();
        linkedList.printList();
        linkedList.addLast(2);
        linkedList.printList();
        linkedList.addLast(3);
        linkedList.printList();
        linkedList.addNode(1, 9);
        linkedList.printList();
    }
}
