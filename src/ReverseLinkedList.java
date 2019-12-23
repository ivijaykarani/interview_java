public class ReverseLinkedList {

    private static Node head = null;
    private static Node tail = null;
    private static int listCount = 0;

    static class Node {
        Node next;
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
                tail = n;
            }
            else {
                prev.next = n;
                tail = n;
            }
            prev = n;
            listCount++;
        }
    }

    public static boolean removeLinkList(int v) {
        Node curr = head;
        Node prev = head;
        boolean retStatus = false;
        while (curr.next != null) {
            if (curr.data == v) {
                if (prev == head) {
                    head = curr.next;
                }
                else {
                    prev.next = curr.next;
                    curr.next = null;
                    listCount--;
                    break;
                }

                if (tail == curr) {
                    tail = prev;
                }
            }
            prev = curr;
            curr = curr.next;
        }
        return  retStatus;
    }

    public static void appendLinkList(int v) {
        Node n = new Node(v);
        Node t = tail;
        tail = n;
        if (head == null) {
            head = n;
        }
        else {
            t.next = n;
        }
        listCount++;
    }

    public static void mutateOddEvenLinkList() {
        Node hOdd = null;
        Node tOdd = null;
        Node hEven = null;
        Node tEven = null;
        Node n = head;
        Node next = null;
        while (n != null) {
            next = n.next;
            if (n.data%2 == 0) {
                if (hEven == null) {
                    hEven = n;
                }
                if (tEven != null) {
                    tEven.next = n;
                }
                tEven = n;
                tEven.next = null;
            }
            else {
                if (hOdd == null) {
                    hOdd = n;
                }
                if (tOdd != null) {
                    tOdd.next = n;
                }
                tOdd = n;
                tOdd.next = null;
            }
            n = next;
        }
        tOdd.next = hEven;
        head = hOdd;
        tail = tEven;
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
        /*int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        createLinkList(arr);
        appendLinkList(21);
        printLinkedList();
        removeLinkList(8);
        printLinkedList();
        reverseLinkList(8);
        printLinkedList();
        */

        int[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8};
        createLinkList(arr1);
        mutateOddEvenLinkList();
        printLinkedList();
    }
}
