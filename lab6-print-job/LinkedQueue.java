class LinkedQueue<E> implements Queue<E> {
    // Nested class Node
    private static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }

        public E getElement(){
            return element;
        }

        public Node<E> getNext(){
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
    }

    // Instant variables
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    // constructor for empty queue
    public LinkedQueue() {
    }

    /**
     * Returns the number of elements in the queue.
     *
     * @return the number of elements
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Checks if the queue is empty.
     *
     * @return true if the queue is empty, false otherwise
     */
    @Override
    public boolean isEmpty() {
        return size == 0;
    }


    /**
     * Inserts an element at the rear of the queue.
     * This is an O(1) operation.
     *
     * @param e the element to be added
     */
    @Override
    public void enqueue(E e) {
        Node<E> newest = new Node<>(e, null); // Create a new node
        if (isEmpty()) {
            head = newest; // If the queue is empty, the new node is both head and tail
        } else {
            tail.next = newest; // Otherwise, the old tail points to the new node
        }
        tail = newest; // The new node becomes the new tail
        size++;
    }

    /**
     * Removes and returns the first element from the queue.
     * This is an O(1) operation.
     *
     * @return the removed element, or null if the queue is empty
     */
    @Override
    public E dequeue() {
        if (isEmpty()) {
            return null;
        }
        E answer = head.getElement(); // Get the element from the head
        head = head.getNext();       // Move the head pointer to the next node
        size--;
        if (isEmpty()) {
            tail = null; // Special case: if the queue is now empty, the tail must also be null
        }
        return answer;
    }

    /**
     * Returns the first element of the queue without removing it.
     *
     * @return the first element, or null if the queue is empty
     */
    @Override
    public E first() {
        if (isEmpty()) {
            return null;
        }
        return head.getElement();
    }

    /**
     * Returns a string representation of the queue.
     * @return a string showing the queue's contents
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("(");
        Node<E> walk = head;
        while (walk != null) {
            sb.append(walk.getElement());
            if (walk.getNext() != null) {
                sb.append(", ");
            }
            walk = walk.getNext();
        }
        sb.append(")");
        return sb.toString();
    }
}
