class RunLinkedList {
    public static void main(String args[]) {
        LinkedList wordList = new LinkedList();
        Node a = new Node(1776);
        Node b = new Node(2020);
        Node c = new Node(2001);
        Node cur;
        
        wordList.append(a);
        wordList.append(b);
        wordList.append(c);

        cur = wordList.head;

        while (cur != null) {
            System.out.println(cur.data);
            cur = cur.next;
        }
    }
}