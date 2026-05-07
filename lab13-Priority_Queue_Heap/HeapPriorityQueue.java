import java.util.ArrayList;

// --- Heap Implementation ---
public class HeapPriorityQueue<K extends Comparable<K>> {
    private ArrayList<K> heap = new ArrayList<>();

    // Helper methods
    protected int parent(int j) { return (j - 1) / 2; }
    protected int left(int j) { return 2 * j + 1; }
    protected int right(int j) { return 2 * j + 2; }

    public int size() { return heap.size(); }
    public boolean isEmpty() { return heap.isEmpty(); }

    private void swap(int i, int j) {
        K temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    public void insert(K key) {
        heap.add(key);
        upheap(heap.size() - 1);
    }

    public K removeMin() {
        if (isEmpty()) return null;
        K answer = heap.get(0);
        // Move last element to root
        K last = heap.remove(heap.size() - 1);
        if (!heap.isEmpty()) {
            heap.set(0, last);
            downheap(0);
        }
        return answer;
    }

    public K min() {
        return isEmpty() ? null : heap.get(0);
    }

    private void upheap(int j) {
        // TODO: While j > 0 and parent > child, swap and move up
        while (j > 0){
            int parent = (j - 1) / 2;
            if (heap.get(j).compareTo(heap.get(parent)) >=0 ){
                break;                  // heap-order restored
            }
            swap(j, parent);            // swap() with parent
            j = parent;                 // move up
        }
    }

    private void downheap(int j) {
        // TODO: While j has left child...
        // Find smaller child, swap if child < parent, move down
        int left = 2 * j + 1;
        while (left < heap.size()){     // while j has at least a left child
            int smallChild = left;
            int right = left + 1;

            // If right child exists and is smaller, use it instead
            if (right < heap.size() &&
                    heap.get(right).compareTo(heap.get(left)) < 0){
                smallChild = right;
            }

            if (heap.get(smallChild).compareTo(heap.get(j)) >= 0){
                break;                  // heap-order restored
            }

            swap(j, smallChild);        // swap downward
            j = smallChild;             // continue down
            left = 2 * j + 1;           // recompute left child index
        }
    }
}