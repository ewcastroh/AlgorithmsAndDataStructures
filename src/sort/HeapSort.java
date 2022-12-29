package sort;

import java.util.Arrays;
import java.util.stream.Collectors;

public class HeapSort {

    /* heap data structure */
    int[] array;
    int size;

    // Create Heap
    public void createHeap(int size) {
        this.array = new int[size + 1];
        this.size = 0;
    }

    // Insert values
    public void insert(int value) {
        array[size + 1] = value;
        size++;
        heapifyBottomToTop(size);
    }

    public void heapifyBottomToTop(int index) {
        int parent = index / 2;
        // We are at root of the tree. Hence no more Heapifying is required.
        if (index <= 1) {
            return;
        }
        // If Current value is smaller than its parent, then we need to swap
        if (array[index] < array[parent]) {
            int tmp = array[index];
            array[index] = array[parent];
            array[parent] = tmp;
        }
        heapifyBottomToTop(parent);
    }

    //Extract Head of Heap
    public int extract() {
        if(size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }else {
            int extractedValue = array[1];
            array[1] = array[size];
            size--;
            heapifyTopToBottom(1);
            return extractedValue;
        }
    }

    // heapify from top to bottom
    public void heapifyTopToBottom(int index) {
        int left  = index * 2;
        int right = (index * 2) + 1;
        int smallestChild = 0;

        if (size < left) { //If there is no child of this node, then nothing to do. Just return.
            return;
        }else if (size == left) { //If there is only left child of this node, then do a comparison and return.
            if(array[index] > array[left]) {
                int tmp = array[index];
                array[index] = array[left];
                array[left] = tmp;
            }
            return;
        }else { //If both children are there
            if(array[left] < array[right]) { //Find out the smallest child
                smallestChild = left;
            }else {
                smallestChild = right;
            }
            if(array[index] > array[smallestChild]) { //If Parent is greater than the smallest child, then swap
                int tmp = array[index];
                array[index] = array[smallestChild];
                array[smallestChild] = tmp;
            }
        }
        heapifyTopToBottom(smallestChild);
    }

    // heap sort algorithm
    public void heapSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) { // insert into heap
            insert(nums[i]);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = extract();
        }
    }

    public static void main(String[] args) {
        int[] nums = {6, 4, 7, 3, 1, 2, 5};
        System.out.println("Before sorting:");
        String unSortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(unSortedArrayAsc);

        HeapSort heap = new HeapSort();
        heap.createHeap(nums.length);
        heap.heapSort(nums);

        System.out.println("After sorting Asc:");
        String sortedArrayAsc = Arrays.stream(nums)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining(", "));
        System.out.println(sortedArrayAsc);

    }
}
