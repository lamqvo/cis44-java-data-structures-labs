import java.util.Random;

public class Main {
    public static void main(String[] args){
        DynamicArray<Integer> da = new DynamicArray<>();
        System.out.println("Initial Array size: " + da.size());
        int arraySize = 15;
        int indexToBeRemoved = 3;
        Random rand = new Random();
        System.out.println("Start adding values into array");
        rand.setSeed(123);
        for (int i = 0; i < arraySize; i++){
            int val =  rand.nextInt(100);
            da.add(val);
            System.out.println("da[" +i  +"] ==> " + da.get(i));
        }
        for (int i = 0; i < da.size(); i++){
            System.out.println("da[" +i  +"] ==> " + da.get(i));
        }
        System.out.println("Array size after adding elements: " + da.size());
        System.out.println("\nRemoving index "+ indexToBeRemoved);
        int removedVal = da.remove(indexToBeRemoved);
        System.out.println("Removed index " + indexToBeRemoved + "'s value => " + removedVal);
        System.out.println("\nArray size after remove index " + indexToBeRemoved + ": " + da.size());
        for (int i = 0; i < da.size(); i++){
            System.out.println("da[" +i  +"] ==> " + da.get(i));
        }
    }

}
