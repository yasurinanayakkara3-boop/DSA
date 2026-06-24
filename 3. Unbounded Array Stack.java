public class UnboundedArrayStack<T> {

    private T[] stack;
    private int top;
    private int capacity;

    @SuppressWarnings("unchecked")
    public UnboundedArrayStack() {
        capacity = 2;
        stack = (T[]) new Object[capacity];
        top = -1;
    }

    public void push(T item) {
        if (top + 1 == capacity) {
            resize(capacity * 2); 
        }

        stack[++top] = item;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        T item = stack[top];
        stack[top] = null;
        top--;

        
        if (!isEmpty() && (top + 1) <= capacity / 4) {
            resize(capacity / 2);
        }

        return item;
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }

        return stack[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public int size() {
        return top + 1;
    }

    public int getCapacity() {
        return capacity;
    }

    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        T[] newStack = (T[]) new Object[newCapacity];

        for (int i = 0; i <= top; i++) {
            newStack[i] = stack[i];
        }

        stack = newStack;
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        UnboundedArrayStack<Integer> stack = new UnboundedArrayStack<>();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Size: " + stack.size());
        System.out.println("Capacity: " + stack.getCapacity());

        System.out.println("Pop: " + stack.pop());
        System.out.println("Pop: " + stack.pop());

        System.out.println("Size: " + stack.size());
        System.out.println("Capacity: " + stack.getCapacity());

        System.out.println("Top: " + stack.peek());
    }
}
