package trees;

public class HeapUsingArray {

    int[] array;
    int size;

    // create heap
    public void createHeap(int size) {
        array = new int[size + 1];
        size = 0;
    }

    //Insert a new value in Heap
    public void insert(int value) {
        array[size + 1] = value;
        size++;
        heapifyBottomToTop(size);
    }

    // heapify the heap
    private void heapifyBottomToTop(int index) {
        if (index > 1) {
            int parent = index / 2;
            if (array[index] < array[parent]) {
                int temp = array[index];
                array[index] = array[parent];
                array[parent] = temp;
            }
            heapifyBottomToTop(parent);
        }
    }

    // size of heap
    public int getSize() {
        return size;
    }

    // check whether the heap is empty or not
    public boolean isEmpty() {
        return size <= 0;
    }

    // Peek the head
    public int peek() {
        if (size <= 0) {
            System.out.println("Value doesn't exist.");
            return -1;
        } else {
            return array[1];
        }
    }

    //Extract Head of Heap
    public int extract() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        } else {
            int extractedValue = array[1];
            array[1] = array[size];
            size--;
            heapifyTopToBottom(1);
            return extractedValue;
        }
    }

    // heapify from top to bottom
    private void heapifyTopToBottom(int index) {
        int left = index * 2;
        int right = (index * 2) + 1;
        int smallestChild = 0;
        if (size < left) {  // If current node has no child.
            return;
        } else if (size == left) {  // If current node has only left child.
            if (array[index] > array[left]) {
                int temp = array[index];
                array[index] = array[left];
                array[left] = temp;
            }
            return;
        } else {    // If current node has left and right child.
            if (array[left] < array[right]) { //Find out the smallest child
                smallestChild = left;
            } else {
                smallestChild = right;
            }
            if (array[index] > array[smallestChild]) {//If Parent is greater than smallest child, then swap
                int temp = array[index];
                array[index] = array[smallestChild];
                array[smallestChild] = temp;
            }
        }
        heapifyTopToBottom(smallestChild);
    }

    // delete heap
    public void deleteHeap() {
        array = null;
    }

    // level order traversal of heap
    public void levelOderTraversal() {
        // Printing from 1 because 0th cell is dummy
        for (int i = 1; i <= size; i++) {
            System.out.println(array[i]);
        }
    }

    // main method
    public static void main(String[] args) {
        HeapUsingArray heap = new HeapUsingArray();

        System.out.println("Creating Heap");
        heap.createHeap(7);

        System.out.println("Inserting values");
        heap.insert(1);
        heap.insert(2);
        heap.insert(3);
        heap.insert(4);
        heap.insert(5);
        heap.insert(6);

        System.out.println("Traversing Heap");
        heap.levelOderTraversal();

        System.out.println("Extracting top element" + heap.extract());

        System.out.println("Traversing Heap");
        heap.levelOderTraversal();

    }
}
