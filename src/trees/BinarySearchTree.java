package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinarySearchTree {

    // Binary Search Tree Node
    private class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }

    Node root;

    // Create Binary Search Tree
    public void createBST() {
        root = null;
    }

    public void insert(int value) {
        root = insert(root, value);
    }

    private Node insert(Node currentNode, int value) {
        if (currentNode == null) {
            return new Node(value);
        } else if (currentNode.value > value) {
            currentNode.left = insert(root.left, value);
            return currentNode;
        } else {
            currentNode.right = insert(root.right, value);
            return currentNode;
        }
    }

    public List<Integer> preOrderTraversal(Node root) {
        List list = new ArrayList<>();
        if (this.root == null) {
            return list;
        }
        list.add(this.root.value);
        preOrderTraversal(this.root.left);
        preOrderTraversal(this.root.right);
        return list;
    }

    public List<Integer> inOrderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        inOrderTraversal(root.left);
        list.add(root.value);
        inOrderTraversal(root.right);
        return list;
    }

    public List<Integer> postOrderTraversal(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        list.add(root.value);
        return list;
    }

    public List<Integer> levelOrderTraversal() {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currenNode = queue.poll();
            list.add(currenNode.value);
            if (currenNode.left != null) {
                queue.add(currenNode.left);
            }
            if (currenNode.right != null) {
                queue.add(currenNode.right);
            }
        }
        return list;
    }

    public void search(int value) {
        search(root, value);
    }

    private Node search(Node currenNode, int value) {
        if (currenNode == null) {
            System.out.println("Value not found.");
            return null;
        } else if (currenNode.value == value) {
            System.out.println("Value found it.");
            return currenNode;
        } else if (currenNode.value > value) {
            return search(currenNode.left, value);
        } else {
            return search(currenNode.right, value);
        }
    }

    public void deleteNode(int value) {
        deleteNode(root, value);
    }

    private Node deleteNode(Node currentNode, int value) {
        if (currentNode == null) {
            System.out.println("Value not found.");
            return null;
        }
        if (currentNode.value > value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (currentNode.value < value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else {    // Current node to be deleted.
            // Current node has two children.
            if (currentNode.left != null && currentNode.right != null) {
                Node temp = currentNode;
                Node minNodeRight = minimumNodeInRightBranch(temp.right);
                currentNode.value = minNodeRight.value;
                currentNode.right = deleteNode(currentNode.right, minNodeRight.value);
            } else if (currentNode.left != null) { // Current node has left child.
                currentNode = currentNode.left;
            } else if (currentNode.right != null) { // Current node has right child.
                currentNode = currentNode.right;
            } else {
                currentNode = null;
            }
        }
        return currentNode;
    }

    private Node minimumNodeInRightBranch(Node currentNode) {
        if (currentNode.left == null) {
            return currentNode;
        } else {
            return minimumNodeInRightBranch(currentNode.left);
        }
    }

    public void deleteBST() {
        root = null;
    }

    // main function
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(40);
        bst.insert(60);

        List<Integer> list = bst.levelOrderTraversal();
        System.out.println("Current values in Tree");
        list.forEach(System.out::println);

        System.out.println("After deleting value 50 in Tree");
        bst.deleteNode(50);
        list = bst.levelOrderTraversal();
        list.forEach(System.out::println);

        System.out.println("After deleting Tree");
        bst.deleteBST();
        list = bst.levelOrderTraversal();
        list.forEach(System.out::println);
    }
}
