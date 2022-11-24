package trees;

import java.util.Arrays;

/*
 Formula to calculate left and right children from a node.
 Left child = array[2x]
 Right child = array[2x + 1]
 */
public class BinaryTreeUsingArray {

    int[] array;
    int lastUsedIndex;

    // creation of binary tree
    public void createBinaryTree(int size) {
        array = new int[size + 1];
        lastUsedIndex = 0;
        System.out.println("Binary tree has been created!");
    }

    // Check if array is full
    public boolean isFull() {
        return array.length - 1 == lastUsedIndex;
    }

    // New node should be inserted at the first empty place in the array
    public boolean insert(int value) {
        if (isFull()) {
            System.out.println("Tree is full!");
            return false;
        }
        array[lastUsedIndex + 1] = value;
        lastUsedIndex++;
        System.out.println("Value " + value + " inserted at position " + lastUsedIndex);
        return true;
    }

    // Do a linear search on the array
    public int search(int value) {
        for (int i = 1; i <= lastUsedIndex; i++) {
            if (array[i] == value) {
                System.out.println("Value found at index " + i);
                return i;
            }
        }
        System.out.println(value + " does not exist!");
        return -1;
    }

    // delete operation of binary tree
    public void deleteNode(int value) {
        int location = search(value);
        if (location == -1) {
            System.out.println("Value doesn't exist.");
        } else {
            //insert last element of the Tree into current location
            array[location] = array[lastUsedIndex];
            lastUsedIndex--;
            System.out.println("Successfully deleted " + value + " from the Tree!");
            System.out.println("Last used index: " + lastUsedIndex);
        }
    }

    // delete entire tree
    public void deleteBinaryTree() {
        try {
            array = null;
            System.out.println("Tree has been deleted successfully!");
        }catch(Exception e){
            System.out.println("There was an error deleting the tree.");
        }
    }

    /*
		Tree Traversal Algorithms:
		1. Pre-order traversal (DFS)
		2. In-order traversal (DFS)
		3. Post-order traversal (DFS)
		4. Level order Traversal (BFS)
	*/

    // Pre-Order traversal of binary tree
    public int[] preOrderTraversalRecursive(int index) {
        int[] preOrderArray = new int[array.length];
        int indexPreOrderArray = 0;
        if (index <= lastUsedIndex) {
            preOrderArray[indexPreOrderArray++] = array[index];
            System.out.println("Index: " + index);
            System.out.println("Item at index: " + array[index]);
            preOrderTraversalRecursive(2 * index);
            preOrderTraversalRecursive(2 * index + 1);
        }
        return preOrderArray;
    }

    // In-Order Traversal of binary tree
    public int[] inOrderTraversalRecursive(int index) {
        int[] inOrderArray = new int[array.length];
        int indexInOrderArray = 0;
        if (index <= lastUsedIndex) {
            inOrderTraversalRecursive(2 * index);
            inOrderArray[indexInOrderArray++] = array[index];
            System.out.println("Index: " + index);
            System.out.println("Item at index: " + array[index]);
            inOrderTraversalRecursive(2 * index + 1);
        }
        return inOrderArray;
    }

    // Post-Order Traversal of binary tree
    public int[] postOrderTraversalRecursive(int index) {
        int[] postOrderArray = new int[array.length];
        int indexPostOrderArray = 0;
        if (index <= lastUsedIndex) {
            postOrderTraversalRecursive(2 * index);
            postOrderTraversalRecursive(2 * index + 1);
            postOrderArray[indexPostOrderArray++] = array[index];
            System.out.println("Index: " + index);
            System.out.println("Item at index: " + array[index]);
        }
        return postOrderArray;
    }

    // level-Order traversal of binary tree
    public void levelOrder() {
        for (int i = 1; i <= lastUsedIndex; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {

        BinaryTreeUsingArray binaryTreeUsingArray = new BinaryTreeUsingArray();

        System.out.println("Creating BinaryTree");
        binaryTreeUsingArray.createBinaryTree(7);

        System.out.println("Inserting values");
        binaryTreeUsingArray.insert(10);
        binaryTreeUsingArray.insert(20);
        binaryTreeUsingArray.insert(30);
        binaryTreeUsingArray.insert(40);
        binaryTreeUsingArray.insert(50);
        binaryTreeUsingArray.insert(60);
        binaryTreeUsingArray.insert(70);

        System.out.println("Level Order");
        binaryTreeUsingArray.levelOrder();

        System.out.println("PreOrder Traversal");
        int[] preOrder = binaryTreeUsingArray.preOrderTraversalRecursive(1);
        Arrays.stream(Arrays.stream(preOrder).toArray()).forEach(value -> System.out.println(value));

    }
}
