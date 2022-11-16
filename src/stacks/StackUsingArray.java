package stacks;

public class StackUsingArray {

    int[] array;
    int topOfStack;

    public void createStack(int size) {
        this.array = new int[5];
        this.topOfStack = -1;
    }

    public void push(int data) {
        if (this.array.length - 1 == topOfStack) {
            System.out.println("Stack Overflow Error. Stack is full!");
        } else {
            array[topOfStack + 1] = data;
            topOfStack++;
            System.out.println("Data inserted: " + data);
        }
    }

    public int pop() {
        if (topOfStack == -1) {
            System.out.println("Stack Overflow Error. Stack is empty!");
            return topOfStack;
        } else {
            int topOfStackValue = this.array[topOfStack];
            this.array[topOfStackValue] = 0;
            topOfStack--;
            return topOfStackValue;
        }
    }

    public int peek() {
        if (topOfStack == -1) {
            System.out.println("Stack Overflow Error. Stack is empty!");
            return topOfStack;
        } else {
            return this.array[topOfStack];
        }
    }

    public boolean isEmpty() {
        return topOfStack == -1;
    }

    public boolean isFull() {
        return topOfStack == this.array.length - 1;
    }

    public void deleteStack() {
        this.array = null;
        this.topOfStack = -1;
    }

    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();

        // create stack of size 5
        System.out.println("Creating stack with size=2");
        stack.createStack(2);

        // insert 1 to the stack
        System.out.println("Inserting value=1");
        stack.push(1);
        System.out.println("Inserting value=2");
        stack.push(2);

        // pop from the stack
        System.out.println("Pop from stack: " + stack.pop());
        System.out.println("Pop from stack: " + stack.pop());

        // check whether stack is empty or not
        System.out.println("Checking if stack is empty:");
        System.out.println(stack.isEmpty());

        // peek top element from stack
        System.out.println("Peek top element from stack:");
        stack.peek();

        // isFull method will check whether stack is full or not
        System.out.println("Check whether stack is full or not");
        System.out.println(stack.isFull());
    }
}
