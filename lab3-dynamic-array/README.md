Lab Project 3: Arrays And Dynamic Arrays
While working on this assignment, you certify that you have neither given help to nor received help from any other person or AI tools. You can still use AI resources as a tutor. However, AI-generated submissions are not permitted and will be treated as a violation of the Mission College Academic Honesty Policy Links to an external site.. In submitting this lab project, you confirm that the work submitted is entirely your own work.

Note: Do not submit PDF or Word files. Only submit GitHub links to Java source files, screenshots (e.g., .png or .jpg), and the UML diagram in an image format (e.g., .png or .jpg).
Stimulus for question at position: 1
Generic DynamicArray Class

In this project, you will implement your own generic dynamic array class, mimicking the basic functionality of Java's ArrayList.

Instructions:

Create a generic class named DynamicArray.java.
The class must have the following private instance variables:
An array to store the elements: private T[] data;
An integer to track the number of elements: private int size;
An integer for the initial capacity (e.g., private static final int INITIAL_CAPACITY = 10;).
Implement the following public methods:
public DynamicArray(): A constructor that initializes the internal array with the initial capacity.
public void add(T element): Adds an element to the end of the list. If the internal array is full, this method must trigger a private resize() method before adding the new element.
public T get(int index): Returns the element at the specified index. Throws an IndexOutOfBoundsException if the index is invalid.
public T remove(int index): Removes the element at the specified index. All subsequent elements must be shifted to the left to fill the gap. Returns the removed element. Throws an IndexOutOfBoundsException if the index is invalid.
public int size(): Returns the number of elements in the list.
Implement a private resize() method that creates a new array with double the capacity of the old one and copies the elements over.
             

Submission:

Submit your DynamicArray.java file and a Main.java that demonstrates its functionality.

 

