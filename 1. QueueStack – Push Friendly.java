import java.util.LinkedList;
import java.util.Queue;

public class QueueStackPushFriendly<T> {
    private Queue<T> q1 = new LinkedList<>();
    private Queue<T> q2 = new LinkedList<>();

    
    public void push(T data) {
        q1.offer(data);
    }

    
    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        T item = q1.poll();

        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;

        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        while (q1.size() > 1) {
            q2.offer(q1.poll());
        }

        T top = q1.poll();
        q2.offer(top);

        Queue<T> temp = q1;
        q1 = q2;
        q2 = temp;

        return top;
    }

    public boolean isEmpty() {
        return q1.isEmpty();
    }

    public static void main(String[] args) {
        QueueStackPushFriendly<Integer> stack = new QueueStackPushFriendly<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top: " + stack.peek());
        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());
    }
}
