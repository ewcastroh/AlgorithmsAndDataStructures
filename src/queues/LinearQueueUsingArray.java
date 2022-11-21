package queues;

public class LinearQueueUsingArray {

    int[] array;
    int front;
    int rear;

    public void createQueue(int size) {
        array = new int[size];
        front = rear = -1;
    }

    public void enQueue(int value) {
        // if the queue is full
        if (array.length - 1 == rear) {
            System.out.println("Queue Overflow.");
        } else if (rear == -1) { // if the queue is empty
            front = 0;
            rear++;
            array[rear] = value;
        } else { // if the queue already has some elements
            rear++;
            array[rear] = value;
        }
    }

    public int deQueue() {
        if (rear == -1) {
            System.out.println("Queue Underflow.");
            return -1;
        } else {
            int returnedValue = array[front];
            array[front] = 0;
            front++;
            if (front > rear) {
                front = rear = -1;
            }
            return returnedValue;
        }
    }

    public int peek() {
        if (front == -1) {
            System.out.println("Queue is empty.");
            return -1;
        } else {
            return array[front];
        }
    }

    public boolean isEmpty() {
        return front == -1;
    }

    public boolean isFull() {
        return rear == array.length -1;
    }

    public void deleteQueue() {
        array = null;
    }

    public void printQueue() {
        if (front == -1) {
            System.out.println("Queue is empty.");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.println("Position " + i + ": " + array[i]);
            }
        }
    }

    public static void main(String[] args) {

        LinearQueueUsingArray queue = new LinearQueueUsingArray();

        System.out.println("Creating queue with size=5");
        queue.createQueue(5);

        for (int i = 1; i <= queue.array.length; i++) {
            System.out.println("Enqueuing value " + i);
            queue.enQueue(i);
        }
        System.out.println("... Queue ...");
        queue.printQueue();
        // queue = [1, 2, 3, 4, 5]

        System.out.println("Peek: " + queue.peek()); // output: 1

        System.out.println("isEmpty():" + queue.isEmpty()); // output: false

        System.out.println("isFull():" + queue.isFull()); // output: true

        System.out.println("Dequeue: " + queue.deQueue()); // output: 1
        // queue after deQueue() operation, queue = [0, 2, 3, 4, 5]

        System.out.println("... Queue ...");
        queue.printQueue();
        // output: 2, 3, 4, 5
    }
}
