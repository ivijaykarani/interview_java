import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Stack1Queue {
    private static Queue<Integer> queueList = new LinkedList<Integer>();

    public static void pushE(int n) {
        int qSize = queueList.size();
        queueList.add(n);
        while (qSize > 0) {
            queueList.add(queueList.remove());
            qSize--;
        }
    }

    public static void pushElement(int n) {
        queueList.add(n);
    }

    public static int popE() {
        return queueList.remove();
    }

    public static int popElement() {
        ArrayList<Integer> qElements = new ArrayList<Integer>();
        int lastElement = -1;
        while (!queueList.isEmpty()) {
            lastElement = queueList.remove();
            qElements.add(lastElement);
        }

        return lastElement;
    }

    public static void main(String[] args) {
        pushE(25);
        pushE(33);
        pushE(47);
        System.out.println("pop element 1 : " + popE());
        System.out.println("pop element 2 : " + popE());
    }
}
