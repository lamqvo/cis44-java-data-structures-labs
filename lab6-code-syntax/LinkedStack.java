import java.util.EmptyStackException;

class LinkedStack<E> implements Stack<E> {

    // Nested Node Class
    private static class Node<E>{
        private E element;
        private Node<E> next;

        public Node(E element, Node<E> next){
            this.element = element;
            this.next = next;
        }

        public E getElement(){ return element;}
        public Node<E> getNext(){ return next;}
    }
    // Instance variables
    private Node<E> head = null;
    private int size = 0;
    private int capacity;   // maximum allowed elements

    // Constructors
    public LinkedStack(){
        this.capacity = Integer.MAX_VALUE; // default: unbounded
    }
    public LinkedStack(int capacity){
        if (capacity <= 0) throw new IllegalArgumentException("Capacity must be > 0");
        this.capacity = capacity;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void push(E element) {
        if (size == capacity) throw new IllegalArgumentException("Stack is full" );
        head = new Node<E>(element, head);
        size++;
    }

    @Override
    public E top() {
        if (isEmpty()) return null;
        return head.getElement();
    }

    @Override
    public E pop() {
        if (isEmpty()) throw new EmptyStackException();
        E answer = head.getElement();
        head = head.getNext();
        size--;
        return answer;
    }
}
