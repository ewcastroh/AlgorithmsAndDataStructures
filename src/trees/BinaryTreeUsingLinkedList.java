package trees;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class BinaryTreeUsingLinkedList {

    // Node
    private class Node {
        int value;
        Node left;
        Node right;

        Node(int value) {
            this.value = value;
        }

        Node(int value, Node left, Node right) {
            this.value = value;
            this.left = left;
            this.right = right;
        }
    } // end of class Node

    Node root;

    // create binary tree method will create the binary tree
    public void createBinaryTree() {
        root = null;
    }

    // insert new node at the deepest place in the Binary Tree
    public void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
        } else {
            Queue<Node> queue = new LinkedList<>();
            queue.add(root);
            while (!queue.isEmpty()) {
                Node currentNode = queue.remove();
                if (currentNode.left == null) {
                    currentNode.left = newNode;
                    break;
                } else if (currentNode.right == null) {
                    currentNode.right = newNode;
                    break;
                } else {
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                }
            }
        }
    }

    // Search for a given value
    public boolean search(int value) {
        if (root == null) {
            System.out.println("Tree is Empty!");
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            if (currentNode.value == value) {
                System.out.println("Value:" + value + " is found!");
                return true;
            } else {
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        return false;
    }

    public boolean deleteNode(int value) {
        if (root == null) {
            System.out.println("Tree is empty!");
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currentNode = queue.remove();
            // if node is found then copy deepest node here and delete deepest node.
            if (currentNode.value == value) {
                // currentNode = getDeepestNode();
                currentNode.value = getDeepestNode().value;
                deleteDeepestNode();
                break;
            } else {
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        System.out.println("Did not find the node!!");
        return false;
    }

    private Node getDeepestNode() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return null;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        Node currentNode = null;
        while (!queue.isEmpty()) {
            currentNode = queue.poll();
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
        return currentNode;
    }

    // delete deepest node of a binary tree
    public boolean deleteDeepestNode() {
        if (root == null) {
            System.out.println("Tree is empty!");
            return false;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node previousNode = null;
        Node currentNode = null;
        while (!queue.isEmpty()) {
            previousNode = currentNode;
            currentNode = queue.poll();
            if (currentNode.left == null) {
                previousNode.right = null;
                return true;
            } else if (currentNode.right == null) {
                currentNode.left = null;
                return true;
            }
            queue.add(currentNode.left);
            queue.add(currentNode.right);
        }
        return false;
    }

    public void deleteTree() {
        root = null;
    }

    public List<Integer> preOrderTraversalRecursive() {
        List<Integer> list = new ArrayList<>();
        preOrderTraversalRecursiveHelper(root, list);
        return list;
    }

    private void preOrderTraversalRecursiveHelper(Node node, List<Integer> list) {
        if (node != null) {
            list.add(node.value);
            preOrderTraversalRecursiveHelper(node.left, list);
            preOrderTraversalRecursiveHelper(node.right, list);
        }
    }

    public List<Integer> preOrderTraversalIterative() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null) {
            list.add(currentNode.value);
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left == null && !stack.isEmpty()) {
                currentNode = stack.pop();
            } else {
                currentNode = currentNode.left;
            }
        }
        return list;
    }

    public List<Integer> inOrderTraversalRecursive() {
        List<Integer> list = new ArrayList<>();
        inOrderTraversalRecursiveHelper(root, list);
        return list;
    }

    private void inOrderTraversalRecursiveHelper(Node node, List<Integer> list) {
        if (node != null) {
            inOrderTraversalRecursiveHelper(node.left, list);
            list.add(node.value);
            inOrderTraversalRecursiveHelper(node.right, list);
        }
    }

    public List<Integer> inOrderTraversalIterative() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        while (currentNode != null || !stack.isEmpty()) {
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }
            currentNode = stack.pop();
            list.add(currentNode.value);
            currentNode = currentNode.right;
        }
        return list;
    }

    public List<Integer> postOrderTraversalRecursive() {
        List<Integer> list = new ArrayList<>();
        postOrderTraversalRecursiveHelper(root, list);
        return list;
    }

    private void postOrderTraversalRecursiveHelper(Node node, List<Integer> list) {
        if (node != null) {
            postOrderTraversalRecursiveHelper(node.left, list);
            postOrderTraversalRecursiveHelper(node.right, list);
            list.add(node.value);
        }
    }

    public List<Integer> postOrderTraversalIterative() {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        Node currentNode = root;
        if (currentNode != null) {
            stack.push(currentNode);
            while (!stack.isEmpty()) {
                currentNode = stack.pop();
                list.add(0, currentNode.value);
                if (currentNode.left != null) {
                    stack.push(currentNode.left);
                }
                if (currentNode.right != null) {
                    stack.push(currentNode.right);
                }
            }
        }
        return list;
    }

    public List<List<Integer>> levelOrderRecursive() {
        List<List<Integer>> list = new ArrayList<>();
        levelOrderRecursiveHelper(list, root, 0);
        return list;
    }

    private void levelOrderRecursiveHelper(List<List<Integer>> list, Node node, int level) {
        if (root != null) {
            if (level >= list.size()) {
                List<Integer> newLevelList = new LinkedList<>();
                list.add(newLevelList);
            }
            list.get(level).add(node.value);
            levelOrderRecursiveHelper(list, node.left, level++);
            levelOrderRecursiveHelper(list, node.right, level++);
        }
    }

    public List<List<Integer>> levelOrderIterative() {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> newLevelList = new ArrayList<>();
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                Node node = queue.poll();
                newLevelList.add(node.value);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(newLevelList);
        }
        return list;
    }


    public static void main(String[] args) {

        BinaryTreeUsingLinkedList binaryTreeUsingLinkedList = new BinaryTreeUsingLinkedList();
        System.out.println("Creation BinaryTree");
        binaryTreeUsingLinkedList.createBinaryTree();

        System.out.println("Inserting value: 10");
        binaryTreeUsingLinkedList.insert(10);
        System.out.println("Inserting value: 20");
        binaryTreeUsingLinkedList.insert(20);
        System.out.println("Inserting value: 30");
        binaryTreeUsingLinkedList.insert(30);

        System.out.println("Deleting value 30");
        binaryTreeUsingLinkedList.deleteNode(30);

        System.out.println("Searching value 30");
        System.out.println(binaryTreeUsingLinkedList.search(30));
        System.out.println("Searching value 20");
        System.out.println(binaryTreeUsingLinkedList.search(20));

    }
}
