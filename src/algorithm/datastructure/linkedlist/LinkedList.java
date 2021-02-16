package algorithm.datastructure.linkedlist;

public class LinkedList {
    private Node head;
    private Node tail;
    private int size = 0;


    private class Node{
        private int data;
        private Node next;
        public Node(int input){
            this.data = input;
            this.next = null;
        }
    }

    // 가장 앞쪽에 추가
    public void addFirst(int input){
       Node newNode = new Node(input);
       newNode.next = head;
       head = newNode;
       size++;
       if(head.next == null){
           tail = head;
       }
    }

    // 가장 뒷쪽에 추가
    public void addLast(int input){
        Node newNode = new Node(input);
        if(size == 0)
            addFirst(input);
        else{
            tail.next = newNode;
            tail = newNode;
            size++;
        }
    }

    // 특정 노드 검색
    public Node searchNode(int idx){
        int i = 0 ;
        Node current = head;
        while (i != idx){
            current = current.next;
            i++;
        }
        return current;
    }


    // 중간에 데이터 추가
    public void addNode(int idx, int input){
        if(idx == 0){
            addFirst(input);
        } else if (idx >= size){
            addLast(input);
        } else {
            Node newNode = new Node(input);
            Node preNode = searchNode(idx-1);
            Node nextNode = preNode.next;
            preNode.next = newNode;
            newNode.next = nextNode;
            size++;
        }
    }

    // 가장 앞쪽 노드 삭제 ( 삭제한 노드 반환 )
    public Node deleteFirst(){
        Node delNode = null;
        if ( size == 0 ){
            return null;
        } else if ( size == 1) {
            delNode = head;
            head = null;
            tail = null;
            size = 0;
            return delNode;
        } else {
            delNode = head;
            Node tmp = delNode.next;
            head = tmp;
            size --;
            return delNode;
        }
    }

    // 가장 뒷쪽 노드 삭제 (삭제한 노드 반환)
    public Node deleteLast(){
        Node delNode = null;
        if(size == 0) {
            return null;
        } else if (size == 1){
            delNode = deleteFirst();
            return delNode;
        } else {
            delNode = tail;
            Node preNode = searchNode(size - 2);
            preNode.next = null;
            tail = preNode;
            size --;
            return delNode;
        }
    }

    // 중간 노드 삭제
    public Node deleteNode(int idx){
        Node delNode = null;
        if( size == 0 || idx < 0){
            return null;
        } else if ( size == 1 || idx == 0){
            delNode = deleteFirst();
            return delNode;
        } else if ( idx >= size-1 ){
            delNode = deleteLast();
            return delNode;
        } else {
            delNode = searchNode(idx);
            Node nextNode = delNode.next;
            Node preNode = searchNode(idx-1);
            preNode.next = nextNode;
            delNode.next = null;
            size --;
            return delNode;
        }
    }

    public void printList(){
        Node tmp = head;
        while (tmp != null){
            System.out.print(tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }

}
