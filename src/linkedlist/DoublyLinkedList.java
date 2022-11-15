package linkedlist;

public class DoublyLinkedList {

    class Node {
        int data;
        Node previousNode;
        Node nextNode;

        Node(int data) {
            this.data = data;
            this.previousNode = null;
            this.nextNode = null;
        }
    }

    Node head = null;
    Node tail = null;
    int size = 0;

    // addAtHead() will add a new node to the head of the doubly linked list
    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            head.previousNode = newNode;
            newNode.nextNode = head;
            head = newNode;
        }
    }

    // addAtTail() append a node of value val to the end of the doubled linked list.
    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.previousNode = tail;
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
            for (int i = 0; i < index; i++) {
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
            Node newNode = new Node(data);
            Node previousNode = getNode(index - 1);
            previousNode.nextNode.previousNode = newNode;
            previousNode.nextNode = newNode;
            newNode.previousNode = previousNode;
            newNode.nextNode = previousNode.nextNode;
            size++;
        }
    }

    // traverse() will traverse the doubly linked list from left to right
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
        Node currentNode = head;
        while (currentNode != null) {
            Node tmpNode = currentNode;
            currentNode = currentNode.nextNode;
            tmpNode.nextNode = null;
        }
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
            head.previousNode = null;
        } else {
            Node previousNode = getNode(index - 1);
            previousNode.nextNode = previousNode.nextNode.nextNode;
            if (previousNode.nextNode.nextNode != null) {
                previousNode.nextNode.nextNode.previousNode = previousNode;
            }
            if (index == size - 1) {
                tail = previousNode;
            }
        }
        size--;
    }

    // print the nodes values
    public void print() {
        if (head == null) {
            System.out.println("Empty List.");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.println(current.data);
            current = current.nextNode;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList doublyLinkedList = new DoublyLinkedList();

        doublyLinkedList.addAtTail(1);
        doublyLinkedList.addAtTail(2);
        doublyLinkedList.addAtTail(3);
        doublyLinkedList.addAtTail(4);
        doublyLinkedList.addAtTail(5);
        doublyLinkedList.addAtTail(6);

        /* 0<->1<->2<->3<->4<->5->6->null */

        // linkedList = 0->1->2->3->4->5->null

        // print the nodes of the linked list
        doublyLinkedList.print();
        //output: 0 1 2 3 4 5 6

        // print the nodes of the linked list
        System.out.println("----------------");
        System.out.println("Traversing list:");
        doublyLinkedList.traverse();
        //output: 0 1 2 3 4 5 6
        System.out.println("----------------");
        System.out.println("search result(Index of value 4):");
        System.out.println(doublyLinkedList.search(4));
        System.out.println("----------------");
        System.out.println("search result(Index of value 6):");
        System.out.println(doublyLinkedList.search(6));

        // Delete a specific node
        System.out.println("----------------");
        System.out.println("Delete a specific node: 3");
        doublyLinkedList.deleteAtIndex(3);

        // print the nodes of the linked list
        System.out.println("----------------");
        System.out.println("print the nodes of the linked list");
        doublyLinkedList.print();
        // output: 0 1 2 4 5 6

        System.out.println("deleteEntireList() Operation:");
        // doublyLinkedList = 0<->1<->2<->3<->5<->6->null
        doublyLinkedList.deleteEntireList();
        // after deletion, linkedList = null
        // print the nodes of the linked list
        doublyLinkedList.print();
        // output: Linked List is Empty.
    }
}
