import com.sun.jdi.Value;

import java.security.Key;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;

// Use the same Entry<K, V> and MapADT<K, V> as in Project 1
// --- 1. Entry ADT ---
class MapEntry<K, V> {
    private final K key;
    private V value;

    public MapEntry(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public V setValue(V value) {
        V old = this.value;
        this.value = value;
        return old;
    }

    public String toString() {
        return "(" + key + "," + value + ")";
    }
}

// --- 2. Common Map Interface ---
interface MapADT<K, V> {
    V get(K key);

    V put(K key, V value);

    V remove(K key);

    int size();

    boolean isEmpty();
}


// --- 4. Implementation: Separate Chaining Hash Map ---
// Time Complexity: get/put/remove are O(1) expected (Amortized)
class SeparateChainingMap<K, V> implements MapADT<K, V> {
    private ArrayList<LinkedList<MapEntry<K, V>>> table;
    private int size = 0;
    private final int N = 11; // Use a prime number for table capacity

    public SeparateChainingMap() {
        table = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            table.add(new LinkedList<MapEntry<K, V>>());
        }
    }

    public int hash(K key) {
        return Math.abs(key.hashCode() % N);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    // TODO: Complete this method (O(1) expected time)
    public V get(K key) {
        // 1. Calculate the hash index (bucket).
        int h = hash(key);
        LinkedList<MapEntry<K, V>> bucket = table.get(h);
        // 2. Search linearly within the bucket's linked list for the key.
        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        // 3. If key is not found in the bucket, return null.
        return null;
    }

    public V put(K key, V value) {
        int h = hash(key);
        LinkedList<MapEntry<K, V>> bucket = table.get(h);
        // Check if key already exists in the bucket
        for (MapEntry<K, V> entry : bucket) {
            if (entry.getKey().equals(key)) {
                // update old value
                return entry.setValue(value);
            }
        }
        // Key is new: add to the front of the list
        bucket.addFirst(new MapEntry<>(key, value));
        size++;
        return null;
    }

    public V remove(K key) {
        int h = hash(key);
        LinkedList<MapEntry<K, V>> bucket = table.get(h);

        MapEntry<K, V> toRemove = null;
        for (MapEntry<K, V> entry : bucket) {
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

class SeparateChainingMapDriver {
    public static void main(String[] args) {
        SeparateChainingMap<Integer, String> map = new SeparateChainingMap<>();
        Integer N = 11;
        System.out.println("=== SeparateChainingMap Demo (N = 11) ===");

        System.out.println("\n--- Keys / Buckets ---");

        Integer k0 = 1000;
        Integer k1 = 1001;
        Integer k2 = 1002;
        Integer k3 = 1003;
        Integer k4 = 1004;      // expected bucket 3
        Integer k5 = 1005;
        Integer k15 = 1015;     // expected bucket 3
        Integer k26 = 1026;     // expected bucket 3
        Integer k50 = 1050;

        System.out.println("\t" + k0 + " % " + N + " = " + (k0 % N));
        System.out.println("\t" + k1 + " % " + N + " = " + (k1 % N));
        System.out.println("\t" + k2 + " % " + N + " = " + (k2 % N));
        System.out.println("\t" + k3 + " % " + N + " = " + (k3 % N));
        System.out.println("\t" + k4 + " % " + N + " = " + (k4 % N));
        System.out.println("\t" + k5 + " % " + N + " = " + (k5 % N));
        System.out.println("\t" + k15 + " % " + N + " = " + (k15 % N));
        System.out.println("\t" + k26 + " % " + N + " = " + (k26 % N));
        System.out.println("\t" + k50 + " % " + N + " = " + (k50 % N));

        System.out.println("\n--- Insertions ---");
        System.out.println("\tput(" + k0 + ", Data - 00): " + map.put(k0, "Data - 00"));
        System.out.println("\tput(" + k1 + ", Data - 01): " + map.put(k1, "Data - 01"));
        System.out.println("\tput(" + k2 + ", Data - 02): " + map.put(k2, "Data - 02"));
        System.out.println("\tput(" + k3 + ", Data - 03): " + map.put(k3, "Data - 03"));
        System.out.println("\tput(" + k4 + ", Data - 04): " + map.put(k4, "Data - 04"));
        System.out.println("\tput(" + k5 + ", Data - 05): " + map.put(k5, "Data - 05"));
        System.out.println("\tput(" + k15 + ", Data - 15): " + map.put(k15, "Data - 15"));
        System.out.println("\tput(" + k26 + ", Data - 26): " + map.put(k26, "Data - 26"));
        System.out.println("\tput(" + k50 + ", Data - 50): " + map.put(k50, "Data - 50"));

        System.out.println("\n--- Map Size ---");
        System.out.println("\tsize: " + map.size());
        System.out.println("\tisEmpty: " + map.isEmpty());

        System.out.println("\n--- Retrieval Test ---");
        System.out.println("\tget(" + k0 + "): " + map.get(k0) + " ==> bucket: " + (k0 % N));
        System.out.println("\tget(" + k1 + "): " + map.get(k1)+ " ==> bucket: " + (k1 % N));
        System.out.println("\tget(" + k2 + "): " + map.get(k2)+ " ==> bucket: " + (k2 % N));
        System.out.println("\tget(" + k3 + "): " + map.get(k3)+ " ==> bucket: " + (k3 % N));
        System.out.println("\tget(" + k4 + "): " + map.get(k4)+ " ==> bucket: " + (k4 % N));
        System.out.println("\tget(" + k5 + "): " + map.get(k5)+ " ==> bucket: " + (k5 % N));
        System.out.println("\tget(" + k15 + "): " + map.get(k15)+ " ==> bucket: " + (k15 % N));
        System.out.println("\tget(" + k26 + "): " + map.get(k26)+ " ==> bucket: " + (k26 % N));
        System.out.println("\tget(" + k50 + "): " + map.get(k50)+ " ==> bucket: " + (k50 % N));

        System.out.println("\n--- Update Test ---");
        System.out.println("\tUpdate k1: \n\tput(" + k1 + ", Updated Data - 01): " + map.put(k1, "Updated Data - 01"));
        System.out.println("\t\tget(" + k1 + "): " + map.get(k1)+ " ==> bucket: " + (k1 % N));

        System.out.println("\tUpdate k15: \n\tput(" + k15 + ", Updated Data - 15): " + map.put(k15, "Updated Data - 15"));
        System.out.println("\t\tget(" + k15 + "): " + map.get(k15)+ " ==> bucket: " + (k15 % N));

        System.out.println("\n--- Remove Test ---");
        System.out.println("\tRemove k1\n\t\tremove(" + k1 + "): " + map.remove(k1));
        System.out.println("\t\tget(" + k1 + "): " + map.get(k1));
        System.out.println("\tRemove k3\n\t\tremove(" + k3 + "): " + map.remove(k3));
        System.out.println("\t\tget(" + k3 + "): " + map.get(k3));

        System.out.println("\n--- Final Map Size ---");
        System.out.println("\tsize: " + map.size());
        System.out.println("\tisEmpty: " + map.isEmpty());

    }
}
