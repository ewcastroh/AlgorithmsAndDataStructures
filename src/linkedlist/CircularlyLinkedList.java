package linkedlist;

public class CircularlyLinkedList {

    // Node of the circularly linked list
    class Node {
        int data;
        Node nextNode;

        public Node(int data) {
            this.data = data;
            this.nextNode = null;
        }
    }

    // head and tail of the circularly linked list
    Node head = null;
    Node tail = null;
    int size = 0;


    // addNode(int data) will add node at the end
    public void addNode(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            tail.nextNode = head;
        } else {
            tail.nextNode = newNode;
            newNode.nextNode = head;
            tail = newNode;
        }
        size++;
    }

    // print() will the all the nodes present in the list
    public void print() {
        if (head == null) {
            System.out.println("Empty list.");
        } else {
            // initially current point will point to the first node
            Node current = head;
            do {
                System.out.println(current.data);
                current = current.nextNode;
            } while (current != head);
        }
    }

    // search() method will return the index of a given node
    public int search(int value) {
        if (head == null) {
            return -1;
        }
        Node current = head;
        int index = 0;
        do {
            if (current.data == value) {
                return index;
            }
            current = current.nextNode;
            index++;
        } while (current != head);
        return -1;
    }

    /*
	addAtHead()
	addAtTail()
	addAtIndex()
	*/
    // addAtHead() method will add node at the beginning
    public void addAtHead(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.nextNode = head;
            tail.nextNode = newNode;
            head = newNode;
        }
        size++;
    }

    // addAtTail() method will add node at the end
    public void addAtTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.nextNode = newNode;
            newNode.nextNode = head;
            tail = newNode;
        }
        size++;
    }

    public Node getNode(int index) {
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.nextNode;
        }
        return current;
    }

    // addAtIndex() method will add node at a specific index
    public void addAtIndex(int index, int data) {
        if (index < 0) {
            System.out.println("Index lower than zero.");
        } else if (index > size) {
            System.out.println("Index greater than size.");
        } else {
            if (index == 0) {
                addAtHead(data);
            } else if (index == size) {
                addAtTail(data);
            } else {
                Node newNode = new Node(data);
                Node previousNode = getNode(index - 1);
                newNode.nextNode = previousNode.nextNode;
                previousNode.nextNode = newNode;
            }
            size++;
        }
    }

    // traverse() will traverse the linked list from left to right
    public void traverse() {
        if (head == null) {
            System.out.println("Empty list.");
        } else {
            // initially current point will point to the first node
            Node current = head;
            do {
                System.out.println(current.data);
                current = current.nextNode;
            } while (current != head);
        }
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

    public static void main(String[] args) {
        CircularlyLinkedList linkedList = new CircularlyLinkedList();

        linkedList.addNode(1);
        linkedList.addNode(2);
        linkedList.addNode(3);
        linkedList.addNode(4);
        linkedList.addAtHead(0);
        linkedList.addAtTail(5);
        linkedList.addAtIndex(6, 6);

        System.out.println("--------------");
        System.out.println(linkedList.search(3));
        System.out.println("--------------");

        // cll = 1->2->3->4->null
        linkedList.print();
		/* It will print 1 2 3 4 endlessly because of circle
		output: 1 2 3 4 ...*/

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
