public class InventoryApp {
    public static void main(String[] args){
        Inventory inv = new Inventory();
        inv.addItem(new Item("Item 1"));
        inv.addItem(new Item("Item 2"));
        inv.addItem(new Item("Item 3"));
        inv.addItem(new Item("Item 4"));
        inv.display();
        inv.combineItems("Item", "Item 4");
        inv.combineItems("Item 2", "Item 4");
        inv.display();

    }


}
