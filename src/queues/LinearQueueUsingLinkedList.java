package queues;

public class LinearQueueUsingLinkedList {

    class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            next = null;
        }
    }

    Node front, rear;

    public void createQueue() {
        front = rear = null;
    }

    public void enQueue(int value) {
        Node newNode = new Node(value);
        if (front == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
        System.out.println("Inserted " + value);
    }

    public int peek() {
        if (front == null) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            System.out.println(front.value);
            return front.value;
        }
    }

    public boolean isEmpty() {
        return front == null;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            int temp = front.value;
            front = front.next;
            if (front == null) {
                rear = null;
            }
            System.out.println("DeQueueing " + temp);
            return temp;
        }
    }

    public void deleteQueue() {
        front = rear = null;
    }

    public void printQueue() {
        Node current = front;
        while (current != null) {
            System.out.println(current.value);
            current = current.next;
        }
    }

    public static void main(String[] args) {

        LinearQueueUsingLinkedList queue = new LinearQueueUsingLinkedList();

        System.out.println("Creating queue.");
        queue.createQueue();

        System.out.println("Enqueuing values ");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Enqueuing value " + i * 10);
            queue.enQueue(i * 10);
        }
        System.out.println("... Queue ...");
        queue.printQueue();
        // queue = [10, 20, 30, 40, 50]

        System.out.println("Dequeue: " + queue.deQueue()); // output: 10
        System.out.println("Dequeue: " + queue.deQueue()); // output: 20

        System.out.println("... Queue ...");
        queue.printQueue();

        System.out.println("Peek: " + queue.peek()); // output: 30

        System.out.println("isEmpty():" + queue.isEmpty()); // output: false

        System.out.println("... Delete Queue ...");
        queue.deleteQueue();

        System.out.println("... Queue ...");
        queue.printQueue();

    }
}
