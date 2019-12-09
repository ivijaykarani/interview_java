import java.util.Stack;

public class Queue2Stacks {

    private Stack<Integer> stack1 = new Stack<Integer>();
    private Stack<Integer> stack2 = new Stack<Integer>();
    private int currQueue = 2;

    public void enqueue(Integer item) {
        stack1.push(item);
    }

    public Integer dequeue() {
        if (stack2.empty()) {
            if (stack1.empty())
                return -1;
        }
        return 1;
    }

    public static void main(String[] args) {
        Queue2Stacks que = new Queue2Stacks();
        que.enqueue(5);
        que.enqueue(10);
        que.enqueue(15);
        System.out.println("Item 1 : " + que.dequeue());
        que.enqueue(20);
        que.enqueue(25);
        System.out.println("Item 2: " + que.dequeue());
        System.out.println("Item 3: " + que.dequeue());
        System.out.println("Item 4: " + que.dequeue());
        System.out.println("Item 5: " + que.dequeue());
    }
}
