package queues;

public class CircularQueueUsingArray {

    int[] array;
    int front;
    int rear;
    int size;

    public void createQueue(int length) {
        array = new int[length];
        front = rear = -1;
        size = length;
    }

    public void enQueue(int value) {
        if (isFull()) {
            System.out.println("Queue is full.");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            array[rear] = value;
            System.out.println("Inserted " + value);
        }
    }

    public boolean isEmpty() {
        return rear == -1;
    }

    public boolean isFull() {
        if (front == 0 && rear == size - 1) {
            return true;
        }
        if (front == rear + 1) {
            return true;
        }
        return false;
    }

    public int deQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        }
        int temp = array[front];
        if (front == rear) {
            front = rear = -1;
            return -1;
        } else {
            front = (front + 1) % size;
        }
        return temp;
    }

    public int peek() {
        if (isEmpty()) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return array[front];
        }
    }

    public void deleteQueue() {
        array = null;
        front = rear = -1;
    }

    public void printQueue() {
        if (front == -1) {
            System.out.println("Queue is Empty!");
            return;
        }
        int i;
        for (i = front; i != rear; i = (i + 1) % size) {
            System.out.println(array[i]);
        }
        System.out.println("index of front=" + front);
        System.out.println("index of rear=" + rear);
    }

    public static void main(String[] args) {

        CircularQueueUsingArray queue = new CircularQueueUsingArray();

        System.out.println("Creating queue with size=5");
        queue.createQueue(5);

        System.out.println("Enqueuing values ");
        for (int i = 1; i <= queue.array.length; i++) {
            System.out.println("Enqueuing value " + i * 10);
            queue.enQueue(i * 10);
        }
        System.out.println("... Queue ...");
        queue.printQueue();
        // queue = [10, 20, 30, 40, 50]

        System.out.println("Dequeue: " + queue.deQueue()); // output: 10
        System.out.println("Dequeue: " + queue.deQueue()); // output: 20

        System.out.println("Enqueuing value " + 60);
        queue.enQueue(60);

        System.out.println("... Queue ...");
        queue.printQueue();

        System.out.println("Dequeue: " + queue.deQueue()); // output: 30

        System.out.println("... Queue ...");
        queue.printQueue();

        System.out.println("... Delete Queue ...");
        queue.deleteQueue();

        System.out.println("... Queue ...");
        queue.printQueue();
    }

}
