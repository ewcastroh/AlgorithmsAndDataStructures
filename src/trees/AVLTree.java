package trees;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {

    private class Node {
        int value;
        int height;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.height = 0;
            this.left = null;
            this.right = null;
        }
    }

    Node root;

    // Create AVL Tree
    public void createAVLTree() {
        root = null;
    }

    public boolean search(int value) {
        Node searchedNode = search(root, value);
        if (searchedNode != null) {
            return searchedNode.value == value;
        }
        return false;
    }

    private Node search(Node node, int value) {
        if (node == null) {
            return null;
        } else if (node.value == value) {
            return node;
        } else if (node.value > value) {
            return search(node.left, value);
        } else {
            return search(node.right, value);
        }
    }

    /** Insert in AVL Tree **/
    public void insert(int value) {
        root = insert(root, value);
    }

    /** Insertion in AVL Tree **/
    public Node insert(Node node, int value) {
        /** BST Condition **/
        if (node == null)
            return (new Node(value));
        if (value < node.value)
            node.left = insert(node.left, value);
        else if (value > node.value)
            node.right = insert(node.right, value);
        else
            return node;

        /** AVL Tree Specific Algorithm for Insertion **/
        int balanceFactor = getBalanceFactor(node.left, node.right);
        if (balanceFactor > 1) {
            if (value < node.left.value) {
                return rightRotate(node); // Left-Left Condition
            } else if (value > node.left.value) {
                node.left = leftRotate(node.left); // Left-Right Condition
                return rightRotate(node);
            }
        }
        if (balanceFactor < -1) {
            if (value > node.right.value) {
                return leftRotate(node); // Right-Right Condition
            } else if (value < node.right.value) {
                node.right = rightRotate(node.right); // Right-Left Condition
                return leftRotate(node);
            }
        }

        if (node.left != null)
            node.left.height = calculateHeight(node.left);
        if (node.right != null)
            node.right.height = calculateHeight(node.right);
        node.height = calculateHeight(node);
        return node;
    } // end of method

    /** Right rotation **/
    public Node rightRotate(Node currNode) {
        Node newRoot = currNode.left;
        currNode.left = currNode.left.right;
        newRoot.right = currNode;
        currNode.height = calculateHeight(currNode);
        newRoot.height = calculateHeight(newRoot);
        return newRoot;
    }// end of method

    /** Left rotation **/
    public Node leftRotate(Node currNode) {
        Node newRoot = currNode.right;
        currNode.right = currNode.right.left;
        newRoot.left = currNode;
        currNode.height = calculateHeight(currNode);
        newRoot.height = calculateHeight(newRoot);
        return newRoot;
    }// end of method

    // Calculate height of Node
    public int calculateHeight(Node currentNode) {
        if (currentNode == null)
            return 0;
        return 1 + Math.max((currentNode.left != null ? currentNode.left.height : -1),
                (currentNode.right != null ? currentNode.right.height : -1));

    }// end of method

    // get balance factor
    public int getBalanceFactor(Node rootLeft, Node rootRight) {
        if (rootLeft == null && rootRight == null) { //if current node is a leaf node then no need to check balance of its children
            return 0;
        } else if (rootLeft == null) {
            return -1 * (rootRight.height + 1); // if left node is not there then simply return right node's
            // height + 1
            // we need to make it -1 because blank height is considered
            // having height as '-1'
        } else if (rootRight == null) {
            return rootLeft.height + 1;
        } else {
            return rootLeft.height - rootRight.height; // +1 is not required, as both right and left child
            // exits and 1 gets nullified
        }
    }// end of method

    /* Deleting a node from AVL Tree */
    public void deleteNode(int value) {
        root = deleteNode(root, value);
    }

    /* deleteNode Helper Method */
    public Node deleteNode(Node currentNode, int value) {
        // THIS ELSE_IF BLOCK IS BST CONDITION
        if (currentNode == null)
            return null;
        if (value < currentNode.value) {
            currentNode.left = deleteNode(currentNode.left, value);
        } else if (value > currentNode.value) {
            currentNode.right = deleteNode(currentNode.right, value);
        } else { // If currentNode is the node to be deleted
            // if currNode has both child
            if (currentNode.left != null && currentNode.right != null) {
                Node tmp = currentNode;
                Node minRight = minNode(tmp.right); // Minimum node from right subtree
                currentNode.value = minRight.value; // Replacing currNode with minimum node from right subtree
                deleteNode(currentNode.right, minRight.value); // Deleting minimum node from right now
            } else if (currentNode.left != null) {// if currNode has only left child
                currentNode = currentNode.left;
            } else if (currentNode.right != null) {// if currNode has only right child
                currentNode = currentNode.right;
            } else { // if currNode do not have child (Leaf node)
                currentNode = null;
            }
            return currentNode;// if it is a leaf node,then no need to do balancing for this node, do only for its ancestors
        }

        // THIS IS WHERE WE WILL DO AVL SPECIFIC WORK
        int balance = getBalanceFactor(currentNode.left, currentNode.right);
        if (balance > 1) {
            if (getBalanceFactor(currentNode.left, currentNode.right) > 0)
                currentNode = rightRotate(currentNode);// LL Condition
            else {
                currentNode.left = leftRotate(currentNode.left); // LR Condition
                currentNode = rightRotate(currentNode);
            }
        } else if (balance < -1) {
            if (getBalanceFactor(currentNode.left, currentNode.right) > 0)
                currentNode = leftRotate(currentNode);// RR Condition
            else {
                currentNode.right = rightRotate(currentNode.right);// RL Condition
                currentNode = leftRotate(currentNode);
            }
        }

        if (currentNode.left != null) {
            currentNode.left.height = calculateHeight(currentNode.left);
        }
        if (currentNode.right != null) {
            currentNode.right.height = calculateHeight(currentNode.right);
        }
        currentNode.height = calculateHeight(currentNode);
        return currentNode;

    }// end of method

    /* Get minNode */
    public static Node minNode(Node root) {
        if (root.left == null)
            return root;
        else {
            return minNode(root.left);
        }
    }// end of method

    // Level order traversal of BST
    public void levelOrderTraversal() {

        if (root == null) {
            System.out.println("Root is null!");
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node currNode = queue.remove();
            System.out.println(currNode.value);
            if (currNode.left != null)
                queue.add(currNode.left);
            if (currNode.right != null)
                queue.add(currNode.right);
        }
    }// end of method


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
        tree.createAVLTree();
        // insert node 1, 2, 3, 4, 5, 6, 7, 8, 9
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(5);
        tree.insert(6);
        tree.insert(7);
        tree.insert(8);
        tree.insert(9);
        // delete node
        tree.deleteNode(3);
        tree.levelOrderTraversal();
    }

}

/*
Example AVL Tree:

		 5
	  /     \
	 2       7
	/       / \
   1       6   8
    		    \
    		     9
*/
