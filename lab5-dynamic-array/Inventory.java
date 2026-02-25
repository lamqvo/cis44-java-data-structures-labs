import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class Inventory {
    private List<Item> items;
    public Inventory() {
        this.items = new ArrayList<>();
    }

    /**
     * Method to add item into the ArrayList items
     * @param item
     */
    public void addItem(Item item) {
        this.items.add(item);
        System.out.println("Added " +item);
    }

    /**
     * Method to display all inventory items from ArrayList
     */
    public void display() {
        System.out.println("Inventory items:");
        if (items.isEmpty()) {
            System.out.println("Inventory is empty!");
        }
        // use for-each loop to traverse through the items array to print all inventory item
        for (Item item : items) {
            System.out.println(item);
        }
    }
    // Combining Logic: You will likely need to iterate through the list once to find the items.
    // You can use boolean flags or store the items to be removed.
    // After the loop finishes, if both items were found, you can then add the new combined item.

    /**
     * Method to combineItems if both items found.
     *  Both items will be removed from ArrayList
     *  combinedName will be added at the end of the ArrayList
     * @param name1
     * @param name2
     */
    public void combineItems(String name1, String name2) {
        System.out.println("Combine: " + name1 + " && " + name2);
        boolean found1 = false;                 // initial first found name is false
        boolean found2 = false;                 // initial second found name is false
        Iterator<Item> it1 = items.iterator();  // get an iterator from the collection
        // loop as long as there are more elements
        while (it1.hasNext()) {
            Item current = it1.next();          // set current points to next element
            // check if found1 is false && found matched first name with current element's name
            if (!found1 && current.getName().equals(name1)) {
                found1 = true;                  // set found1 = true
            }
            // check if found2 is false && found matched second name with current element's name
            else if (!found2 && current.getName().equals(name2)) {
                found2 = true;                  // set found2 = true
            }
            // if found both 2 names
            if (found1 && found2) {
                System.out.println("\tFound both 2 names!");
                String combinedName = name1 + " " + name2;
                // Cannot add item inside the iterator loop.  Nothing was added!
//                System.out.println("Start adding combined Name: " +  combinedName);
//                items.add(new Item(combinedName));
//                System.out.println("Break after adding combined Name");
                break;                          // get out of the while loop
            }
        }
        // if not both 2 names are found, then return
        if (!(found1 && found2)){
            System.out.println("\tCannot combine 2 names!");
            return;
        }
        // if both 2 names are found, then loop again to remove both 2 names & add combined name
        else {
            boolean removed1 = false;                   // initial 1st removed name is false
            boolean removed2 = false;                   // initial 2nd removed name is false
            Iterator<Item> it2 = items.iterator();      // get an iterator from the collection
            // loop as long as there are more elements
            while (it2.hasNext()) {
                Item cur = it2.next();                  // set cur to next element
                // check if 1st removed name is false && first name matched the current element's name
                if (!removed1 && cur.getName().equals(name1)) {
                    removed1 = true;                    // set removed1 = true
                    it2.remove();                       // use iterator to safely remove this element
                    System.out.println("\tRemoved: " + cur.getName());
                }
                // check if 1st removed name is false && first name matched the current element's name
                else if (!removed2 && cur.getName().equals(name2)) {
                    removed2 = true;                    // set removed2 = true
                    it2.remove();                       // use iterator to safely remove this element
                    System.out.println("\tRemoved: " + cur.getName());
                }
                // once both found, break the loop
                if (removed1 && removed2){
                    break;
                }
            }
            // if both names are removed successfully, then add combined names into the ArrayList items
            if (removed1 && removed2) {
                String combinedName = name1 + " " + name2;
                System.out.println("\tStart adding combined Name: " +  combinedName);
                items.add(new Item(combinedName));
            }
        }
    }
}