interface Queue<E> {
    /** Returns the number of elements in the queue. */
    int size();
    /** Tests whether the queue is empty.*/
    boolean isEmpty();
    /** Inserts an element at the end of the queue.*/
    void enqueue(E element);
    /** Removes and returns the first element from the queue. */
    E dequeue();
    /** Returns, but does not remove, the element at the front of the queue. */
    E first();

}
