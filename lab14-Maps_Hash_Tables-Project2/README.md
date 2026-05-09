Project 2: Hash Map using Separate Chaining

 

Objective: Implement the fundamental Map operation of get(k) for a Hash Map using the Separate Chaining collision resolution technique. This implementation targets O(1) expected time complexity for core operations.

Requirements:

The map uses an ArrayList of LinkedLists (buckets).
The hash function is defined as: h(k) = Math.abs(key.hashCode() % N).
Separate Chaining: Entries are stored in the linked list at the calculated hash index (bucket).
Code Template:  Copy and paste the code below into your IDE. You must complete the get(K key) method. It must calculate the hash, access the correct bucket, and linearly search the bucket's linked list for the key.
import java.util.ArrayList;
import java.util.LinkedList;

// Use the same Entry<K, V> and MapADT<K, V> as in Project 1

// --- 4. Implementation: Separate Chaining Hash Map ---
// Time Complexity: get/put/remove are O(1) expected (Amortized)
class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<Entry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // Use a prime number for table capacity

    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<Entry<K, V>>());
        }
    }

    private int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() { return size; }
    public boolean isEmpty() { return size == 0; }

    // TODO: Complete this method (O(1) expected time)
    public V get(K key) {
        // 1. Calculate the hash index (bucket).
        

        // 2. Search linearly within the bucket's linked list for the key.
        
        }

        // 3. If key is not found in the bucket, return null.
        
    }

    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        // Check if key already exists in the bucket
        

        // Key is new: add to the front of the list
        
      }

    public V remove(K key) {
        int h = hash(key);
        LinkedList<Entry<K, V>> bucket = table.get(h);

        Entry<K, V> toRemove = null;
        for (Entry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                toRemove = entry;
                break;
            }
        }

        if (toRemove != null) {
            V oldValue = toRemove.getValue();
            bucket.remove(toRemove);
            size--;
            return oldValue;
        }
        return null;
    }
}

Paste the direct link to your lab14-Maps_Hash_Tables directory that includes your completed Java files on GitHub. 


 Upload a screenshot (image file) showing the console output verifying the core operations of your SeparateChainingMap. The output should include insertions that demonstrate collision handling by inserting at least three String keys that are expected to hash to the same bucket (or near the same bucket) in a small table (like N=11). Show the re
