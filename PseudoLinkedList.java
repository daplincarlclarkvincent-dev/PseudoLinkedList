package pseudolinkedlist;

public class PseudoLinkedList {

    private Node head = null;

    // Node class
    private static class Node {
        String data;
        Node next;

        Node(String data) {
            this.data = data;
        }
    }

    // Add to the end (used for both stack push and queue enqueue)
    public void add(String data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newNode;
    }

    // Poll (Queue behavior) - remove from front
    public String poll() {
        if (head == null) {
            return null;
        }

        String value = head.data;
        head = head.next;
        return value;
    }

    // Peek (Queue behavior) - view front
    public String peek() {
        return head != null ? head.data : null;
    }

    // Pop (Stack behavior) - remove from end
    public String pop() {
        if (head == null) return null;

        if (head.next == null) {
            String value = head.data;
            head = null;
            return value;
        }

        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }

        String value = current.next.data;
        current.next = null;
        return value;
    }

    // Helper method to view the list
    public void printList() {
        Node current = head;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // Main method to test
    public static void main(String[] args) {
        PseudoLinkedList list = new PseudoLinkedList();

        System.out.println("Adding A, B, C...");
        list.add("A");
        list.add("B");
        list.add("C");
        list.printList();

        System.out.println("\nPeek (front): " + list.peek()); // A

        System.out.println("Polling (removing front): " + list.poll()); // A
        list.printList(); // B -> C

        System.out.println("Popping (removing end): " + list.pop()); // C
        list.printList(); // B

        System.out.println("Adding D...");
        list.add("D");
        list.printList(); // B -> D
    }
}
