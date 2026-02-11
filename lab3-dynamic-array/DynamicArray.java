public class DynamicArray<T> {
    private T[] data;
    private int size;
    private static final int INITIAL_CAPACITY = 10;

    // A constructor that initializes the internal array with the initial capacity.
    public DynamicArray(){
        data = (T[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }
    // Adds an element to the end of the list.
    // If the internal array is full, this method must trigger a private resize() method before adding the new element.
    public void add(T element){
        if (size == data.length){
//            System.out.println("Size reaches max!  Extending!");
            resize();
        }
        data[size] = element;
        size++;
    }
    // Returns the element at the specified index.
    // Throws an IndexOutOfBoundsException if the index is invalid.
    public T get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        return data[index];
    }
    // Removes the element at the specified index.
    // All subsequent elements must be shifted to the left to fill the gap.
    // Returns the removed element.
    // Throws an IndexOutOfBoundsException if the index is invalid.
    public T remove(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Invalid index: " + index);
        }
        T removeVal = data[index];
        for (int j = index; j < size - 1; j++){
            data[j] = data[j+1];
        }
        data[size - 1] = null;
        size--;
        return removeVal;
    }

    // Returns the number of elements in the list.
    public int size(){
        return size;
    }

    // method that creates a new array with double the capacity of the old one and copies the elements over.
    private void resize(){
        T[] tmp = (T[]) new Object[data.length * 2];
        for (int i = 0; i < size; i++){
            tmp[i] = data[i];
        }
        data = tmp;
    }
}
