This project requires you to build an itinerary manager using a Positional List and a custom Iterator. A positional list is ideal because the order of destinations matters, and you might want to insert a new stop relative to an existing one (e.g., "add a visit to the museum after visiting the Eiffel Tower").

Instructions:
  1. Implement a LinkedPositionalList class using a doubly linked list, as described in the lecture notes. It must support `Position` objects.
  2. Your LinkedPositionalList class must also implement the Iterable interface.
  3. Implement the following methods in your list:
      * first(), last(), before(p), after(p)
      * addFirst(e), addLast(e), addBefore(p, e), addAfter(p, e)
      * set(p, e), remove(p)
      * iterator(): This method must return a new instance of your custom iterator class.
  4. Create a private inner class that implements the Iterator interface. It will need to manage its state to traverse the list.
  5. Create a main application to manage a travel itinerary (a list of Strings). Demonstrate adding stops, inserting a stop between two others, and traversing the final itinerary using a for-each loop (which will prove your iterator works).

Deliverables:
  * A link to the lab6-positional-list directory on GitHub.
  * Screenshots showing your application's output, including the final itinerary printed using a for-each loop.

Conceptual Hints
  * Position vs. Node: The `Node` class is your internal implementation detail. Your public methods should only accept and return `Position` objects, never `Node`s. Your `Position` can simply be your `Node` class if you implement the `Position` interface.
  * Iterator State: Your iterator class will need a variable, like `Position cursor`, to keep track of where it is in the list. The `next()` method will return the cursor's element and then advance the cursor using the `after()` method.

Starter Code Template

import java.util.Iterator;

// You'll need a Position interface
public interface Position { E getElement(); }

public class LinkedPositionalList implements Iterable {
    // --- Nested Node Class (implements Position) ---
    private static class Node implements Position {
        // ... element, prev, next pointers and methods ...
    }
    
    private Node header;
    private Node trailer;
    private int size = 0;

    public LinkedPositionalList() {
        // ... constructor to create sentinel nodes ...
    }
    
    // ... Implement all the Positional List methods ...

    // --- Nested Iterator Class ---
    private class ElementIterator implements Iterator {
        Position cursor = first(); // Start at the first element
        
        public boolean hasNext() {
            return cursor != null;
        }
        
        public E next() {
            // Store the element at the current cursor
            // Advance the cursor to the next position using after()
            // Return the stored element
        }
    }
    
    @Override
    public Iterator iterator() {
        return new ElementIterator();
    }
}
