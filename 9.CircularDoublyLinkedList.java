class CDLLNode {
    int data;
    CDLLNode next, prev;

    CDLLNode(int data) {
        this.data = data;
    }
}

public class CircularDoublyLinkedList {
    CDLLNode head = null;

    
    public void insert(int data) {
        CDLLNode newNode = new CDLLNode(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
            return;
        }

        CDLLNode last = head.prev;

        last.next = newNode;
        newNode.prev = last;

        newNode.next = head;
        head.prev = newNode;
    }

    
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        CDLLNode temp = head;

        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.display();
    }
}
