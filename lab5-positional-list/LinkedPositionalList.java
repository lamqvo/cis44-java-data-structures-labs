import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedPositionalList<E> implements Iterable<E> {
    // --- Nested Node Class (implements Position) ---
    private static class Node<E> implements Position<E> {
        private E element;
        private Node<E> prev;
        private Node<E> next;

        /**
         * Constructor Node
         * @param element element value of the current node
         * @param prev node before current node
         * @param next node after current node
         */
        Node(E element, Node<E> prev, Node<E> next){
            this.element = element;
            this.prev = prev;
            this.next = next;
        }

        /**
         * This method is to get element value when the node is still valid
         * @return element value
         * @throws IllegalStateException throws errors for IllegalStateException
         */
        @Override
        public E getElement() throws IllegalStateException {
            if (next == null){
                throw new IllegalStateException("Position no longer valid!");
            }
            return element;
        }
    }
    // Instance variables
    private Node<E> header;
    private Node<E> trailer;
    private int size = 0;

    // construct a new empty list with sentinel nodes
    public LinkedPositionalList() {
        header = new Node<>(null, null, null);
        trailer = new Node<>(null, header, null);
        header.next = trailer;
        trailer.prev = header;
    }

    /**
     * This method is to get the first position of the list
     * @return first position of the list
     */
    public Position<E> first(){
        if (size == 0) return null;                         // validate the size of the list
        return header.next;                                 // return the position of the first node
    }

    /**
     * This method is to get the last position of the list
     * @return last position of the list
     */
    public Position<E> last(){
        if (size == 0) return null;                         // validate the size of the list
        return trailer.prev;                                // return the position of the last node
    }

    /**
     * This method is to returns the Position of the element immediately before p
     * @param p the marking position
     * @return the position of the element immediately before p
     */
    public Position<E> before(Position<E> p){
        Node<E> node = (Node<E>) p;                         // get node of element at position p
        if (node.prev == header) return null;               // validate if this is header
        return node.prev;                                   // return position of the node before p
    }

    /**
     * This method is to returns the Position of the element immediately after p
     * @param p the marking position
     * @return the position of the element immediately after p
     */
    public Position<E> after(Position<E> p){
        Node<E> node = (Node<E>) p;                         // get node of element at position p
        if (node.next == trailer) return null;              // validate if this is trailer
        return node.next;                                   // return position of the node after p
    }

    /**
     * This method is to add element e to the beginning of the list, returning its new Position.
     * @param e Element value
     * @return position of the new added element
     */
    public Position<E> addFirst(E e){
        Node<E> firstNode = header.next;                        // set firstNode is header.next
        Node<E> newNode = new Node<>(e, header, firstNode);     // create new node in between header and firstNode
        header.next = newNode;                                  // change pointer header.next to new node
        firstNode.prev = newNode;                               // change pointer of first node's previous to new node
        size++;                                                 // increase the list size
        return newNode;                                         // return position of new added node
    }
    /**
     * This method is to add element e to the end of the list, returning its new Position.
     * @param e Element value
     * @return position of the new added element
     */
    public Position<E> addLast(E e){
        Node<E> lastNode = trailer.prev;                        // set lastNode is trailer.prev
        Node<E> newNode = new Node<>(e, lastNode, trailer);     // create new node in between last node and trailer
        lastNode.next = newNode;                                // change pointer of lastNode.next to new node
        trailer.prev = newNode;                                 // change pointer of trailer's previous to new node
        size++;                                                 // increase the list size
        return newNode;                                         // return position of new added node
    }

    /**
     * This method is to Adds element e immediately before position p, returning its new Position.
     * @param p position to add element e before it
     * @param e element value to be added before position p
     * @return position of the new added element
     */
    public Position<E> addBefore(Position<E> p, E e){
        Node<E> node = (Node<E>) p;                             // get node of element at position p
        Node<E> previous = node.prev;                           // set previous points to node before of p
        Node<E> newNode = new Node<>(e,previous, node);         // create new node in between previous and node p
        previous.next = newNode;                                // change pointer of previous.next to new node
        node.prev = newNode;                                    // change pointer of node's previous to new node
        size++;                                                 // increase the list size
        return newNode;                                         // return position of new added node
    }
    /**
     * This method is to Adds element e immediately after position p, returning its new Position.
     * @param p position to add element e after it
     * @param e element value to be added after position p
     * @return position of the new added element
     */
    public Position<E> addAfter(Position<E> p, E e){
        Node<E> node = (Node<E>) p;                             // get node of element at position p
        Node<E> after = node.next;                              // set after points to node after of p
        Node<E> newNode = new Node<>(e, node, after);           // create new node in between node and after
        node.next = newNode;                                    // change pointer node.next to new node
        after.prev = newNode;                                   // change pointer after.prev to new node
        size++;                                                 // increase the list size;
        return newNode;                                         // return position of the new added node
    }

    /**
     * This method is to replaces the element at position p with e, returning the old element.
     * @param p Position to be updated
     * @param e new element to replace old element at p
     * @return old element what was updated
     */
    public E set(Position<E> p, E e){
        Node<E> node = (Node<E>) p;                             // get node of element at position p
        E oldVal = node.getElement();                           // set oldVal to store old value of the node
        node.element = e;                                       // replace with new value e
        return oldVal;                                          // return the old element value that was updated by e
    }

    /**
     * This method is to Removes the element at position p, invalidating p and returning the removed element.
     * @param p Position of the element to be removed
     * @return removed element
     */
    public E remove(Position<E> p){
        if (size == 0) return null;                             // validate list size
        Node<E> node = (Node<E>) p;                             // get node of element at position p
        E removedE = node.getElement();                         // set removedE to store old value that being removed
        Node<E> predecessor = node.prev;                        // set predecessor pointing to previous node
        Node<E> successor = node.next;                          // set successor pointing to next node
        predecessor.next = successor;                           // change pointer of predecessor.next to successor
        successor.prev = predecessor;                           // change pointer of successor.prev to predecessor
        size--;                                                 // decrease the size of the list

        // invalidate position.  Set all to null
        node.element = null;
        node.prev = null;
        node.next = null;
        return removedE;                                        // return the old element value that was removed

    }


    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator<E> {
        Position<E> cursor = first(); // Start at the first element

        public boolean hasNext() {
            return cursor != null;
        }

        public E next() {
            if (cursor == null) {
                throw new NoSuchElementException("No more element!");
            }
            // Store the element at the current cursor
            E cursorElement = cursor.getElement();
            // Advance the cursor to the next position using after()
            cursor = after(cursor);
            // Return the stored element
            return cursorElement;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ElementIterator();
    }
}