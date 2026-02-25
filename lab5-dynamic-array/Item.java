public class Item {
    String name;    // attribute name
    // Constructor Item
    public Item(String name){
        this.name = name;
    }
    // getter getName as String
    public String getName() {
        return name;
    }
    // setter setName with name as parameter
    public void setName(String name) {
        this.name = name;
    }

    // Override toString() to return name
    @Override
    public String toString() {
        return name;
    }
}
