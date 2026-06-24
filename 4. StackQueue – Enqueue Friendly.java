import java.util.Stack;

public class StackQueueEnqueueFriendly<T> {

    private Stack<T> s1;
    private Stack<T> s2;

    public StackQueueEnqueueFriendly() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    
    public void enqueue(T item) {
        s1.push(item);
    }

    
    public T dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        
        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        T frontItem = s1.pop();

        
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return frontItem;
    }

    
    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        while (s1.size() > 1) {
            s2.push(s1.pop());
        }

        T frontItem = s1.peek();

        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }

        return frontItem;
    }

    public boolean isEmpty() {
        return s1.isEmpty();
    }

    public int size() {
        return s1.size();
    }

    public static void main(String[] args) {
        StackQueueEnqueueFriendly<Integer> queue = new StackQueueEnqueueFriendly<>();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("Front: " + queue.peek()); 
        System.out.println("Dequeue: " + queue.dequeue()); 
        System.out.println("Dequeue: " + queue.dequeue()); 
        System.out.println("Size: " + queue.size()); 
    }
}
