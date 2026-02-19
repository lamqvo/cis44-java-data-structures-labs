import java.util.Arrays;
import java.util.Random;

// Main class to run the simulation
public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        // You can add logic here to initially populate the river
        river[random.nextInt(riverSize)] = new Bear();
        river[random.nextInt(riverSize)] = new Bear();
        river[random.nextInt(riverSize)] = new Bear();
        river[random.nextInt(riverSize)] = new Fish();
        river[random.nextInt(riverSize)] = new Fish();
        river[random.nextInt(riverSize)] = new Fish();
        System.out.println(Arrays.toString(river));
    }

    /// This is the core logic for a single time step.
    ///  1. Create a new array for the next state.
    ///  2. Iterate through the current river array.
    ///  3. For each animal, decide its next move.
    ///  4. Handle collisions and place animals in the new array.
    ///  5. Replace the old river with the new one.
    public void runStep() {
        // 1. Create a new array for the next state.
        Animal[] nextStateRiver = new Animal[river.length];
        // 2. Iterate through the current river array.
        for (int i = 0; i< river.length; i++){
            Animal animal = river[i];
            if (animal == null) {                           // if animal is null, then continue
                continue;
            }
//            System.out.println("\nRIVER[" +i + "]: " + river[i]);
//            System.out.println("animal: " + animal);
            // 3. For each animal, decide its next move.
            int move = random.nextInt(3) - 1;       // move = (0 or 1 or 2) - 1 = -1, 0, 1 ~ left, stay, right
            int moveTo = i + move;                         // moveTo is the new index that each animal moves to
            if (moveTo >= river.length || moveTo < 0) {    // check in case of ArrayIndexOutOfBounds, reset to original index
                moveTo = i;
            }
//            System.out.println("Index moveTo: " + moveTo);
//            System.out.println("\triver[" +moveTo + "]: " + river[moveTo]);
//            System.out.println("\tnextStateRiver[" +moveTo + "]: " + nextStateRiver[moveTo]);

            // 4. Handle collisions and place animals in the new array.
            //    If the cell is null, then just assign that animal to that slot
            if (nextStateRiver[moveTo] == null){
                nextStateRiver[moveTo] = animal;
//                System.out.println("MOVED: nextStateRiver[" +moveTo + "]: " + nextStateRiver[moveTo]);
            //    else, check the 2 cases:
            //      If two identical animals collide, a new one is born in a random empty cell.
            //      If a bear and fish collide, the fish disappears.
            } else {
                Animal existingAnimal = nextStateRiver[moveTo];

                // If two identical animals collide, a new one is born in a random empty cell
                if ((animal instanceof Bear && existingAnimal instanceof Bear) ||
                (animal instanceof Fish && existingAnimal instanceof Fish)){
//                    System.out.println("--> Identical Animal:\t" + animal);
                    int emptyCellCheckNum = 0;                                      // initialize the total empty cells on next State River
                    while (emptyCellCheckNum < river.length){                       // while the empty cells is less than the array length
                        int randomNewBornIndex = random.nextInt(river.length);      // assign a random index number for new born animal
                        if (nextStateRiver[randomNewBornIndex] == null){            // check if the element in that index is null or not
//                            System.out.println("\t==> Assign random empty cell slot: " + randomNewBornIndex);
                            if (animal instanceof Bear){                            // if animal is Bear, then assign a new bear at the random empty slot
//                                System.out.println("\t==> New Baby: " + animal);
                                nextStateRiver[randomNewBornIndex] = new Bear();
                            } else {
//                                System.out.println("\t==> New Baby: " + animal);
                                nextStateRiver[randomNewBornIndex] = new Fish();    // if animal is Fish, then assign a new bear at the random empty slot
                            }
                            break;
                        }
                        emptyCellCheckNum++;                                         // increate the counter after every check that is not matched (cell is not null)
                    }
                }

                //    If a bear and fish collide, the fish disappears.
                if ((animal instanceof Bear && existingAnimal instanceof Fish) || (animal instanceof Fish && existingAnimal instanceof Bear)) {
//                    System.out.println("--> Different Animal:\tanimal = " + animal + " vs existingAnimal = " + existingAnimal);
                    if (animal instanceof Bear){                        // if moving animal is bear, then assign bear to that slot on new river array
                        nextStateRiver[moveTo] = animal;
                    } else {
                        nextStateRiver[moveTo] = existingAnimal;        // if exist animal is bear, then keep bear to that slot on new river array
                    }
//                    System.out.println("--> Different Animal:\tanimal = " + animal + " vs existingAnimal = " + existingAnimal);
//                    System.out.println("--> MOVED: nextStateRiver[" +moveTo + "]: " + nextStateRiver[moveTo]);
                }
            }
//            System.out.println(Arrays.toString(nextStateRiver));
        }
        // 5. Replace the old river with the new one.
        river = nextStateRiver;
    }

    public void visualize() {
        for (Animal animal : river) {
            System.out.print(animal == null ? "-" : animal.toString());
            System.out.print(" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Ecosystem eco = new Ecosystem(20); // Create a river of size 20
        eco.visualize();
        // Loop to run multiple steps...
        for (int i = 0; i<10; i++){
            System.out.println("#########################");
            System.out.println("#Loop #" +i + "\t\t\t\t#");
//            System.out.println("#########################");
            eco.runStep();
            eco.visualize();
        }
    }
}