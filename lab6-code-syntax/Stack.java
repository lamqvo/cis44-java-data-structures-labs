/**
 * An interface for a stack, defining the core LIFO operations.
 * This contract ensures any class implementing it will behave like a stack.
 */
public interface Stack<E> {
    /**
     * Returns the number of elements in the stack.
     */
    int size();

    /**
     * Tests whether the stack is empty.
     */
    boolean isEmpty();

    /**
     * Inserts an element at the top of the stack.
     */
    void push(E element);

    /**
     * Returns, but does not remove, the element at the top of the stack.
     */
    E top();

    /**
     * Removes and returns the top element from the stack.
     */
    E pop();
}