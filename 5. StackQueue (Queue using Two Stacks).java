import java.util.Stack;

public class StackQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;

    public StackQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    
    public void enqueue(int value) {
        stack1.push(value);
    }

    
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.pop();
    }

    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }

        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }

        return stack2.peek();
    }

    
    public boolean isEmpty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    
    public void display() {
        Stack<Integer> temp1 = (Stack<Integer>) stack1.clone();
        Stack<Integer> temp2 = (Stack<Integer>) stack2.clone();

        System.out.print("Queue: ");

        while (!temp2.isEmpty()) {
            System.out.print(temp2.pop() + " ");
        }

        Stack<Integer> reverse = new Stack<>();
        while (!temp1.isEmpty()) {
            reverse.push(temp1.pop());
        }

        while (!reverse.isEmpty()) {
            System.out.print(reverse.pop() + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {
        StackQueue queue = new StackQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        queue.display();

        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Front: " + queue.peek());

        queue.display();
    }
}
