class QueueNode {
    int data;
    QueueNode next;

    QueueNode(int data) {
        this.data = data;
    }
}

public class LinkedListFIFOQueue {

    QueueNode front, rear;

    
    public void enqueue(int data) {

        QueueNode newNode = new QueueNode(data);

        if (rear == null) {
            front = rear = newNode;
            return;
        }

        rear.next = newNode;
        rear = newNode;
    }

    
    public void dequeue() {

        if (front == null) {
            System.out.println("Queue Empty");
            return;
        }

        System.out.println("Removed: " + front.data);

        front = front.next;

        if (front == null)
            rear = null;
    }

    
    public void peek() {
        if (front == null)
            System.out.println("Queue Empty");
        else
            System.out.println("Front: " + front.data);
    }

    
    public void display() {

        QueueNode temp = front;

        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        LinkedListFIFOQueue queue = new LinkedListFIFOQueue();

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.display();

        queue.dequeue();

        queue.display();

        queue.peek();
    }
}
