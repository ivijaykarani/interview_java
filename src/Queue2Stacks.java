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
            while (!stack1.empty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }

    public Integer dequeue1Stack() {
        return recurseDeQ();
    }

    private Integer recurseDeQ() {
        if (stack1.size() == 1)
            return stack1.pop();
        int curr = stack1.pop();
        int r = recurseDeQ();
        stack1.push(curr);
        return r;
    }

    public static void main(String[] args) {
        Queue2Stacks que = new Queue2Stacks();
        que.enqueue(5);
        que.enqueue(10);
        que.enqueue(15);
        System.out.println("Item 1 : " + que.dequeue1Stack());
        que.enqueue(20);
        que.enqueue(25);
        System.out.println("Item 2: " + que.dequeue1Stack());
        System.out.println("Item 3: " + que.dequeue1Stack());
        System.out.println("Item 4: " + que.dequeue1Stack());
        System.out.println("Item 5: " + que.dequeue1Stack());
    }
}
