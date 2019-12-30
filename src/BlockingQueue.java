import java.util.LinkedList;

public class BlockingQueue {
    private static LinkedList<Integer> queueList = new LinkedList<Integer>();

    private static Node head = null;
    private static Node tail = null;

    static {

    }

    static class Node {
        int value;
        Node next;
        public Node(int v) {
            this.value = v;
            next = null;
        }
    }

    public static void addLastElement(int v) {
        Node n = new Node(v);
        if (head == null) {
            head = tail = n;
        }
        else {
            tail.next = n;
            tail = n;
        }
    }

    public static int removeFirstElement()
        throws Exception {
        if (head == null)
            throw new Exception("No element in Queue");
        Node r = head;
        head = r.next;
        r.next = null;
        return r.value;
    }

    public static int peekElement()
        throws Exception {
        if (head == null)
            throw new Exception("No element in Queue");
        return head.value;
    }

    public static void enqueue(int n) {
        addLastElement(n);
    }

    public static int dequeue()
        throws Exception {
        return removeFirstElement();
    }

    public static void main(String[] args) {
        try {
            enqueue(10);
            enqueue(25);
            enqueue(47);
            System.out.println("Element 1 " + dequeue());
            enqueue(60);
            enqueue(80);
            System.out.println("Element 2 " + dequeue());
            System.out.println("Element 3 " + dequeue());
            System.out.println("Element 4 " + dequeue());
            System.out.println("Element 5 " + dequeue());
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
