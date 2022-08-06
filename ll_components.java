class Node {
    public int data;
    public Node next;
    public Node previous;

    public Node(int initialData) {
        data = initialData;
        next = null;
        previous = null;
    }
} 

class LinkedList {
    public Node head;
    public Node tail;

    public LinkedList() {
        head = null;
        tail = null;
    }

    public void append(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
        } 
        else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }
}

