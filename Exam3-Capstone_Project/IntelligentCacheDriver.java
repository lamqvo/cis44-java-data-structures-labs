import java.util.Scanner;

// CacheDemo tests the IntelligentCache class using a menu system.
// The menu is separated into its own method for better organization.
public class IntelligentCacheDriver {

    // Displays the menu options.
    public static void displayMenu() {
        System.out.println("\n==============================");
        System.out.println(" Intelligent Cache Menu");
        System.out.println("==============================");
        System.out.println("1. Add / Update Cache Item");
        System.out.println("2. Search Cache Item");
        System.out.println("3. Display Cache");
        System.out.println("4. Show Cache Size");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // Create cache with maximum capacity of 3 items.
        IntelligentCache<Integer, String> cache =
                new IntelligentCache<>(3);

        int choice = 0;
        System.out.println("=== Intelligent Cache Demo ===");
        System.out.println("Cache capacity is 3 items.");

        while (choice != 5) {
            displayMenu();
            while (!input.hasNextInt()){
                System.out.println("Invalid input.  Please enter again ");
                input.nextLine();
            }
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    int addKey = 0;
                    while(true){
                        System.out.print("Enter key number: ");
                        if (input.hasNextInt()){
                            addKey = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid key.  Please enter again ");
                            input.nextLine();
                        }
                    }
                    System.out.print("Enter value: ");
                    String addValue = input.nextLine();
                    cache.put(addKey, addValue);
                    System.out.println("Item added/updated successfully.");
                    cache.displayCache();
                    break;

                case 2:
                    int searchKey = 0;
                    while (true){
                        System.out.print("Enter key number to search: ");
                        if (input.hasNextInt()){
                            searchKey = input.nextInt();
                            input.nextLine();
                            break;
                        } else {
                            System.out.println("Invalid key.  Please enter again ");
                            input.nextLine();
                        }
                    }
                    String result = cache.get(searchKey);
                    if (result == null) {
                        System.out.println("Key not found in cache.");
                    } else {
                        System.out.println("Found value: " + result);
                        System.out.println("Item moved to most recently used.");
                    }
                    cache.displayCache();
                    break;

                case 3:
                    cache.displayCache();
                    break;

                case 4:
                    System.out.println("Current cache size: " + cache.size());
                    break;

                case 5:
                    System.out.println("Exiting Intelligent Cache Demo.");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        input.close();
    }
}