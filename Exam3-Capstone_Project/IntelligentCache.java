import java.util.HashMap;

// IntelligentCache implements a simple Least Recently Used (LRU) cache.
// uses:
//      1. HashMap for fast O(1) lookup by key.
//      2. Doubly Linked List to track most recently used and least recently used items.
class IntelligentCache<K, V> {

    private final int capacity;
    private final HashMap<K, CacheNode<K, V>> map;

    private CacheNode<K, V> head; // Most recently used
    private CacheNode<K, V> tail; // Least recently used

    public IntelligentCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    // Returns the value for a key.
    // If the key exists, move that node to the front because it was recently used.
    public V get(K key) {
        if (!map.containsKey(key)) {            // if key not found
            return null;                        //      return null
        }

        CacheNode<K, V> node = map.get(key);    // get key's value
        moveToFront(node);                      // move the node to the front after search

        return node.value;
    }

    // Inserts a new key-value pair or updates an existing key.
    // If the cache is full, remove the least recently used item first.
    public void put(K key, V value) {
        if (map.containsKey(key)) {
            CacheNode<K, V> existingNode = map.get(key);   // search for key
            existingNode.value = value;     // update new value
            moveToFront(existingNode);      // move the node to front after each update
            return;
        }

        CacheNode<K, V> newNode = new CacheNode<>(key, value);
        // If the cache is full, remove the least recently used item first.
        if (map.size() >= capacity) {
            removeLeastRecentlyUsed();
        }
        addToFront(newNode);        // move the node to front after adding new key
        map.put(key, newNode);
    }

    // Moves an existing node to the front of the list.
    private void moveToFront(CacheNode<K, V> node) {
        removeNode(node);       // first, remove the node
        addToFront(node);       // then, add this node to front
    }

    // Adds a node to the front of the doubly linked list.
    private void addToFront(CacheNode<K, V> node) {
        node.prev = null;       // point new front node.prev to null (this become head)
        node.next = head;       // point new front node.next to current head

        if (head != null) {     // if list is not empty
            head.prev = node;   // connect old head to new node
        }
        head = node;            // head points to new node now

        if (tail == null) {     // if the list was empty
            tail = node;        // point tail to this node
        }
    }

    // Removes a node from its current position in the doubly linked list.
    private void removeNode(CacheNode<K, V> node) {
        if (node.prev != null) {            // if there is a node before this node
            node.prev.next = node.next;     //      then update pointer node.prev.next to this node.next
        } else {                            // if no node before this node
            head = node.next;               //      then point head to next of this node
        }
        if (node.next != null) {            // if there is a next node after this node
            node.next.prev = node.prev;     //      then point the prev of next node to this node.prev
        } else {                            // if there is no next node after this node
            tail = node.prev;               //      then point tail to the node before this node
        }
        node.prev = null;                   // disconnect the removed node.prev
        node.next = null;                   // disconnect the removed node.next
    }

    // Removes the least recently used item from the cache.
    private void removeLeastRecentlyUsed() {
        if (tail == null) {         // if the list if empty
            return;                 // do nothing
        }
        map.remove(tail.key);       // remove the key from the tail
        removeNode(tail);           // remove this tail
    }

    // Displays the cache from most recently used to least recently used.
    public void displayCache() {
        CacheNode<K, V> current = head;
        System.out.print("Most Recent Cache -> ");
        while (current != null) {
            System.out.print("(" + current.key + ", " + current.value + ") ");
            current = current.next;
        }
        System.out.println("<- Least Recent Cache");
    }

    public int size() {
        return map.size();
    }

    public boolean isEmpty() {
        return map.isEmpty();
    }
}