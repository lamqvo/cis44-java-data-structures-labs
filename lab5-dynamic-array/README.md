This project requires you to build a simple inventory system for a text-based adventure game. The key challenge is to implement a "combine" feature that safely finds and removes two items to create a new one, demonstrating your understanding of Iterators and safe list modification.

Instructions:
  1. Create a simple Item class with a String name attribute.
  2. Create an Inventory class that uses an ArrayList<Item> to store the player's items.
  3. Implement the following methods in your Inventory class:
      * addItem(Item item): Adds an item to the inventory.
      * display(): Prints all items in the inventory.
      * combineItems(String name1, String name2): This is the core method. It must use an Iterator to search the list for items with names matching name1 and name2. If both are found, they must be removed using the iterator.remove() method, and a new combined item (e.g., "Magic Staff") is added to the inventory.
  4. Create a main application class that tests your inventory system. Show the process of adding initial items, displaying the inventory, combining two items, and displaying the final inventory.

Deliverables:
  * A link to the lab5-iterator-inventory directory on GitHub containing your Item.java , Inventory.java, and test application files.
  * Screenshots of your test application's output, clearly demonstrating he inventory before and after a successful item combination.


Conceptual Hints
  * Safe Removal: The main point of this lab is to avoid using inventory.remove() inside a loop. You must use iterator.remove() to avoid a ConcurrentModificationException.
  * Combining Logic: You will likely need to iterate through the list once to find the items. You can use boolean flags or store the items to be removed. After the loop finishes, if both items were found, you can then add the new combined item.

Starter Code Template

import java.util.ArrayList; 

import java.util.Iterator; 

import java.util.List; 

public class Item { 
    String name; 
    
    // Constructor, getter, toString... 
} 

public class Inventory { 

     private List<Item> items; 
     
     public Inventory() { 
     
         this.items = new ArrayList<>(); 
     } 
     public void addItem(Item item) { /* ... */ } 

     public void display() { /* ... */ } 

     public void combineItems(String name1, String name2) { 
           boolean found1 = false; 
           boolean found2 = false; 

           Iterator<Item> iter = items.iterator(); 
           while (iter.hasNext()) { 
                 Item current = iter.next(); 
                 if (current.getName().equals(name1) || current.getName().equals(name2)) { 
                     // How do you track which item you found? 
                     // How do you remove it safely? 
                     iter.remove(); 
                 } 
             } 

             // After the loop, check if both were found. 
             // If so, add the new combined item. 
             // What happens if you add the new item inside the loop? 
        } 
}
