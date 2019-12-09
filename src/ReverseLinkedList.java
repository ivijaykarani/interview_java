public class ReverseLinkedList {

    private static Node head = null;

    static class Node {
        public Node next;
        int data;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void reverseLinkList() {
        Node r = head;
        Node prev = null;
        boolean isCompleted = false;
        while (!isCompleted) {
            Node t = r.next;
            if (r.next == null) {
                head = r;
                isCompleted = true;
            }
            r.next = prev;
            prev = r;
            r = t;
        }
    }

    public static void reverseLinkList(int k) {
        Node n = head;
        int revCount = 0;
        Node kEnd = null;
        Node kStart = head;
        Node prev = null;
        boolean isCompleted = false;
        while (!isCompleted) {
            Node t = n.next;
            n.next = prev;
            prev = n;
            revCount++;
            if (revCount == k) {
                if (kStart == head) {
                    head = n;
                }
                else {
                    kStart.next = n;
                    kStart = kEnd;
                }
                kEnd = t;
                prev = null;
                revCount = 0;
            }
            if (t == null) {
                if (revCount > 0) {
                    kStart.next = n;
                    kEnd.next = null;
                }
                isCompleted = true;
            }
            n = t;
        }
    }

    public static void createLinkList(int[] arr) {
        Node prev = null;
        for (int i = 0; i < arr.length; i++) {
            Node n = new Node(arr[i]);
            if (head == null) {
                head = n;
            }
            else {
                prev.next = n;
            }
            prev = n;
        }
    }

    public static void printLinkedList() {
        Node r = head;
        while (r != null) {
            System.out.print(r.data + " ");
            r = r.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        createLinkList(arr);
        //printLinkedList();
        reverseLinkList(8);
        printLinkedList();
    }
}
