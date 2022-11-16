package stacks;

public class StackUsingLinkedList {

    class Node {
        int data;
        Node nextNode;

        Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    Node head;

    public void createStack() {
        this.head = null;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.nextNode = head;
            head = newNode;
        }
    }

    public int pop() {
        if (head == null) {
            System.out.println("Stack Overflow Error. Stack is empty!");
            return -1;
        } else {
            int topOfStackValue = this.head.data;
            this.head = this.head.nextNode;
            return topOfStackValue;
        }
    }

    public int peek() {
        if (head == null) {
            System.out.println("Stack Overflow Error. Stack is empty!");
            return -1;
        } else {
            return this.head.data;
        }
    }

    public boolean isEmpty() {
        return this.head == null;
    }

    public void deleteStack() {
        head = null;
    }

    public static void main(String[] args) {

        StackUsingLinkedList stack = new StackUsingLinkedList();

        // create stack
        System.out.println("Creating stack");
        stack.createStack();

        // push elements to the stack
        System.out.println("Inserting value=1");
        stack.push(1);
        System.out.println("Inserting value=2");
        stack.push(2);
        System.out.println("Inserting value=3");
        stack.push(3);

        // remove and return top element from stack
        System.out.println("Pop from stack: " + stack.pop());

        // return top element without remove it
        System.out.println("Peek top element from stack: " + stack.peek());

        // isEmpty will check whether the stack is empty or not
        System.out.println("Checking if stack is empty:");
        System.out.println(stack.isEmpty());

        // deleteStack will delete the entire stack
        System.out.println("Delete stack:");
        stack.deleteStack();

        System.out.println("Peek top element from empty stack:");
        stack.peek();

    }
}
