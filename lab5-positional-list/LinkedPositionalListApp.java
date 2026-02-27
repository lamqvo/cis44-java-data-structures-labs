import java.util.Iterator;

public class LinkedPositionalListApp {
    public static void main (String[] args){
        LinkedPositionalList<String> list = new LinkedPositionalList<>();

        System.out.println("addLast(\"First Adding One\")");
        Position<String> firstNode = list.addLast("First Adding One");
        System.out.println("addLast(\"Second Adding Two\")");
        Position<String> secondNode = list.addLast("Second Adding Two");
        System.out.println("addLast(\"Third Adding Three\")");
        Position<String> thirdNode = list.addLast("Third Adding Three");

        System.out.println("addFirst(\"Zero Super Adding Super Zero\")");
        Position<String> superNode = list.addFirst("Zero Super Adding Super Zero ");

        System.out.println("addBefore(thirdNode, \"Add Before thirdNode\")");
        Position<String> addBeforeNode = list.addBefore(thirdNode, "Add Before thirdNode");

        System.out.println("addAfter(secondNode, \"Add After secondNode\")");
        Position<String> addAfterNode = list.addAfter(secondNode, "Add After secondNode");

        System.out.println("set(firstNode, \"New Value - First Adding One\")");
        String setFirstNode = list.set(firstNode, "New Value - First Adding One");
        System.out.println("remove(thirdNode)");
        String removeThirdNode = list.remove(thirdNode);

        System.out.println("\n-------- traverse list manual starting from 1st node ----------");
        Position<String> current = list.first();
        while (current != null){
            System.out.println("==> " +current.getElement());
            current = list.after(current);
        }
        System.out.println("\n-------- traverse list by iterator ----------");
        for (String item : list){
            System.out.println("==> " +item);
        }
        System.out.println("\n-------- get value from position ----------");
        System.out.println("First: " + list.first().getElement());
        System.out.println("Last: " + list.last().getElement());
        System.out.println("After First: " + list.after(list.first()).getElement());
        System.out.println("Before Last: " + list.before(list.last()).getElement());
    }
}
