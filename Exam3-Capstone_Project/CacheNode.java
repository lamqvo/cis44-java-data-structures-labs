class CacheNode<K, V> {
    // HashMap
    K key;
    V value;
    // Double Linked List
    CacheNode<K, V> prev;
    CacheNode<K, V> next;

    public CacheNode(K key, V value) {
        this.key = key;                // Map: Node: key
        this.value = value;            // Map: Node: value
        this.prev = null;              // Double Linked List: Node-> prev
        this.next = null;              // Double Linked List: Node-> next
    }
}