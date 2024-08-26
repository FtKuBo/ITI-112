public class OrderedList implements OrderedStructure {

    // Implementation of the doubly linked nodes (nested-class)

    private static class Node {

        private Comparable value;
        private Node previous;
        private Node next;

        private Node(Comparable value, Node previous, Node next) {
            this.value = value;
            this.previous = previous;
            this.next = next;
        }
    }

    // Instance variables

    private Node head;

    // Representation of the empty list.

    public OrderedList() {
        this.head = null;
    }

    public int size() {
        int size = 0;
        Node node = this.head;
        if (node == null) {
            return size;
        }
        while (!(node.next == null)) {
            size++;
            node = node.next;
        }
        return ++size;
    }

    public Object get(int pos) throws IllegalArgumentException {
        if (pos < 0 || pos >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Node node = this.head;
        for (int i = 0; i < pos; i++) {
            node = node.next;
        }
        return node.value;
    }

    // Adding an element while preserving the order

    public boolean add(Comparable o) {
        if (o == null) {
            throw new NullPointerException();
        }

        Node node = this.head;
        if (this.size() <= 0) { // if the list is empty
            this.head = new Node(o, null, null);
            return true;
        }
        while (!(node.next == null)) { // if the element has to ne inserted in the middle of the list
            if (o.compareTo(node.value) <= 0) {
                node.next = new Node(node.value, node, node.next);
                node.value = o;
                if (node.next.next != null) {
                    node.next.next.previous = node.next;
                }
                return true;
            }
            node = node.next;
        }
        if (o.compareTo(node.value) <= 0) { // if the element has to be inserted at the beginning of the list
            node.next = new Node(node.value, node, node.next);
            node.value = o;
            if (node.next.next != null) {
                node.next.next.previous = node.next;
            }
            return true;
        }

        node.next = new Node(o, node, null); // if the element has to be inserted at the end of the list
        return true;
    }

    // Removes one item from the position pos.

    public void remove(int pos) {
        if (pos < 0 || pos >= this.size()) {
            throw new IndexOutOfBoundsException();
        }

        Node node = this.head;
        for (int i = 0; i < pos; i++) {
            node = node.next;
        }
        if (node.next == null) {
            node.previous.next = null;
        } else if (pos == 0) {
            this.head = new Node(node.next.value, node.previous, node.next.next);
        } else {
            node = new Node(node.next.value, node.previous, node.next.next);
            node.previous.next = node;
        }

    }

    // Knowing that both lists store their elements in increasing
    // order, both lists can be traversed simultaneously.

    public void merge(OrderedList other) throws NullPointerException {

        if (other == null) {
            throw new NullPointerException();
        }

        if (this.size() <= 0) { // if the list is empty
            this.head = other.head;
        }

        else {

            int i = 0;
            Node node = this.head;

            while (!(i >= other.size() || node.next == null)) {
                Comparable comparable = (Comparable) other.get(i);
                if (comparable.compareTo(node.value) <= 0) {
                    node.next = new Node(node.value, node, node.next);
                    node.value = comparable;
                    if (node.next.next != null) {
                        node.next.next.previous = node.next;
                    }
                    i++;
                } else
                    node = node.next;
            }

            if (i < other.size()) {
                Node otherNode = other.head;
                for (int ind = 0; ind < i; ind++) {
                    otherNode = otherNode.next;
                }

                while (node != null && otherNode != null && otherNode.value.compareTo(node.value) <= 0) {
                    node.next = new Node(node.value, node, node.next);
                    node.value = otherNode.value;
                    if (node.next.next != null) {
                        node.next.next.previous = node.next;
                    }
                    otherNode = otherNode.next;
                    node = node.next;
                }

                if (otherNode != null) {
                    node.next = otherNode;
                    node.next.previous = node;
                }
            }
        }
    }
}