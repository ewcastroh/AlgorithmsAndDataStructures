package linkedlist;

public class SimplyLinkedList {

    // Node of the singly linked list
    class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    // head and tail of the singly linked list
    Node head = null;
    Node tail = null;
    int size = 0;

    // addAtHead() will add a new node to the head of the linked list
    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
        } else {
            newNode.nextNode = head;
            head = newNode;
        }
        size++;
    }

    // addAtTail() append a node of value val to the end of the linked list.
    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (size == 0) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            tail = newNode;
        }
        size++;
    }

    private Node getNode(int index) {
        Node node = head;
        if (index < 0) {
            System.out.println("Index lower than zero.");
        } else if (index >= size) {
            System.out.println("Index greater than size.");
        } else {
            for (int i = 0; i < index; ++i) {
                node = node.nextNode;
            }
        }
        return node;
    }

    // addAtIndex() will add note at a given index
    public void addAtIndex(int index, int data) {
        if (index < 0) {
            System.out.println("Index lower than zero.");
        }
        if (index > size) {
            System.out.println("Index greater than size.");
        }
        if (index == 0) {
            addAtHead(data);
        } else if (index == size) {
            addAtTail(data);
        } else {
            Node previousNode = getNode(index - 1);
            Node newNode = new Node(data);
            newNode.nextNode = previousNode.nextNode;
            previousNode.nextNode = newNode;
            size++;
        }
    }

    // traverse() will traverse the linked list from left to right
    public void traverse() {
        if (head == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.nextNode;
        }
    }

    // search() will return the index of given node or -1
    public int search(int value) {
        if (head == null) {
            return -1;
        }
        Node currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if(currentNode.data == value) {
                return index;
            }
            index++;
            currentNode = currentNode.nextNode;
        }
        return -1;
    }

    // deleteEntireList() method will remove references to all nodes in list.
    public void deleteEntireList() {
        head = tail = null;
    }

    // deleteAtIndex() method will remove the node from a given index
    public void deleteAtIndex(int index) {
        if (index < 0) {
            System.out.println("Index lower than zero.");
        }
        if (index > size) {
            System.out.println("Index greater than size.");
        }
        if (index == 0) {
            head = head.nextNode;
        } else {
            Node previousNode = getNode(index - 1);
            previousNode.nextNode = previousNode.nextNode.nextNode;
            if (index == size - 1) {
                tail = previousNode;
            }
        }
        size--;
    }

    // print() will the all the nodes present in the list
    public void print() {
        // initially current point will point to the first node
        Node currentNode = head;
        if (head == null) {
            System.out.println("Empty list.");
        } else {
            System.out.println("Nodes of the singly linked list:");
            while (currentNode != null) {
                // print node and move current pointer to the next node
                System.out.println(currentNode.data);
                currentNode = currentNode.nextNode;
            }
        }
    }

    public static void main(String[] args) {
        SimplyLinkedList linkedList = new SimplyLinkedList();

        // Add 1, 2, 3, 4 nodes to the linkedList
        linkedList.addAtHead(1);
        linkedList.addAtHead(0);
        linkedList.addAtTail(4);
        linkedList.addAtIndex(2,2);
        linkedList.addAtIndex(3,3);
        linkedList.addAtTail(5);

        /* 0->1->2->3->4->5->null */

        // linkedList = 0->1->2->3->4->5->null

        // print the nodes of the linked list
        linkedList.print();
        //output: 0 1 2 3 4 5

        // print the nodes of the linked list
        System.out.println("Traversing list:");
        linkedList.traverse();
        //output: 0 1 2 3 4 5
        System.out.println("search result(Index of value 4):");
        System.out.println(linkedList.search(4));
        System.out.println("search result(Index of value 6):");
        System.out.println(linkedList.search(6));


        // Delete a specific node
        linkedList.deleteAtIndex(3);

        // print the nodes of the linked list
        linkedList.print();
        // output: 0 1 2 4 5

        System.out.println("deleteEntireList() Operation:");
        // linkedList = 0->1->2->3->4->5->null
        linkedList.deleteEntireList();
        // after deletion, linkedList = null
        // print the nodes of the linked list
        linkedList.print();
        // output: Linked List is Empty.
    }
}
