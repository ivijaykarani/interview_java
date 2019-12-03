import java.util.List;
import java.util.ArrayList;

public class SuperStack<K> {

    private List<K> stackList = new ArrayList<K>();

    public void push(K o1) {
        stackList.add(o1);
    }

    public K pop() {
        K v1 = stackList.get(0);
        stackList.remove(0);
        return v1;
    }

    public static void main(String[] args) {
        SuperStack<Integer> stack = new SuperStack<Integer>();
        stack.push(10);
        stack.push(15);
        stack.push(23);
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
        System.out.println("pop = " + stack.pop());
    }
}
