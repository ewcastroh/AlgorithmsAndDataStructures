package linkedlist;

public class CircularlyDoublyLinkedList {

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

    // addAtHead() will add a new node to the head of the circularly doubly linked list
    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (size == 0 ) {
            head = tail = newNode;
            head.previousNode = tail;
            tail.nextNode = head;
        } else {
            newNode.nextNode = head;
            newNode.previousNode = tail;
            head.previousNode = newNode;
            tail.nextNode = newNode;
            head = newNode;
        }
        size++;
    }

    // addAtTail() append a node of value val to the end of the circularly doubled linked list.
    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            tail.nextNode = head;
            head.previousNode = tail;
        } else {
            newNode.nextNode = head;
            tail.nextNode = newNode;
            newNode.previousNode = tail;
            tail = newNode;
            head.previousNode = newNode;
        }
        size++;
    }

    public Node getNode(int index) {
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

    // search() will return the index of given node or -1
    public int search(int value) {
        if (head == null) {
            return -1;
        }
        Node currentNode = head;
        int index = 0;
        do {
            if(currentNode.data == value) {
                return index;
            }
            index++;
            currentNode = currentNode.nextNode;
        } while (currentNode != head);
        return -1;
    }

    // traverse() will traverse the circularly doubly linked list from left to right
    public void traverse() {
        if (head == null) {
            System.out.println("Empty List.");
            return;
        }
        Node current = head;
        do {
            System.out.println(current.data);
            current = current.nextNode;
        } while (current != head);
    }

    // print the nodes values
    public void print() {
        if (head == null) {
            System.out.println("Empty List.");
            return;
        }
        Node current = head;
        do {
            System.out.println(current.data);
            current = current.nextNode;
        } while (current != head);
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
            tail.nextNode = head;
            head.previousNode = tail;
        } else {
            Node previousNode = getNode(index - 1);
            previousNode.nextNode = previousNode.nextNode.nextNode;
            if (previousNode.nextNode.nextNode != null) {
                previousNode.nextNode.nextNode.previousNode = previousNode;
            }
            if (size == index - 1) {
                tail = previousNode;
            }
        }
        size--;
    }

    public static void main(String[] args) {
        CircularlyLinkedList circularlyLinkedList = new CircularlyLinkedList();

        circularlyLinkedList.addAtTail(1);
        circularlyLinkedList.addAtTail(2);
        circularlyLinkedList.addAtTail(3);
        circularlyLinkedList.addAtTail(4);
        circularlyLinkedList.addAtTail(5);
        circularlyLinkedList.addAtTail(6);
        // circularlyLinkedList  = 1->2->3->4->5->6->null

        // Play with all the methods

        circularlyLinkedList.print();


        // print the nodes of the linked list
        System.out.println("----------------");
        System.out.println("Traversing list:");
        circularlyLinkedList.traverse();
        //output: 0 1 2 3 4 5 6
        System.out.println("----------------");
        System.out.println("search result(Index of value 4):");
        System.out.println(circularlyLinkedList.search(4));
        System.out.println("----------------");
        System.out.println("search result(Index of value 6):");
        System.out.println(circularlyLinkedList.search(6));

        // Delete a specific node
        System.out.println("----------------");
        System.out.println("Delete a specific node: 3");
        circularlyLinkedList.deleteAtIndex(3);

        // print the nodes of the linked list
        System.out.println("----------------");
        System.out.println("print the nodes of the linked list");
        circularlyLinkedList.print();
        // output: 0 1 2 4 5 6

        System.out.println("deleteEntireList() Operation:");
        // circularlyLinkedList = 0<->1<->2<->3<->5<->6->null
        circularlyLinkedList.deleteEntireList();
        // after deletion, linkedList = null
        // print the nodes of the linked list
        circularlyLinkedList.print();
        // output: Linked List is Empty.
    }

}
