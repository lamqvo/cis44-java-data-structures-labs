Assignment: Ecosystem Simulation

This project will test your ability to model dynamic systems with interacting objects.

Instructions:
The ecosystem is a river, modeled as a large array of Animal objects. Each cell can hold a Bear, a Fish, or be null.
Create an abstract Animal class, and have Bear and Fish extend it.
In each time step, every animal randomly attempts to move to an adjacent cell or stay put.
Interaction Rules: If two identical animals collide, a new one is born in a random empty cell. If a bear and fish collide, the fish disappears.
After each step, provide a text-based visualization of the river (e.g., using 'B' for Bear, 'F' for Fish, and '-' for null).






Conceptual Hints

Turn Logic: How do you process a turn? If you move animals one by one, an animal might move multiple times in one turn. Consider creating a new array for the next state of the river based on the current state, and then replacing the old one.
Randomness: java.util.Random will be your best friend. You'll need it for initial placement, for deciding movement, and for placing new animals.
Object Identity: How can you check if an animal in a cell is a Bear or a Fish? The instanceof operator is perfect for this.
Starter Code Template


import java.util.Random;

// Step 1: Create the abstract parent class
abstract class Animal {
    // You can add shared attributes or methods here if needed
    // An abstract method for toString() can be helpful for visualization
    public abstract String toString();
}

// Step 2: Create the concrete animal classes
class Bear extends Animal {
    @Override
    public String toString() {
        return "B";
    }
}

class Fish extends Animal {
    @Override
    public String toString() {
        return "F";
    }
}

// Main class to run the simulation
public class Ecosystem {
    private Animal[] river;
    private Random random;

    public Ecosystem(int riverSize) {
        this.river = new Animal[riverSize];
        this.random = new Random();
        // You can add logic here to initially populate the river
    }

    public void runStep() {
        // This is the core logic for a single time step.
        // 1. Create a new array for the next state.
        // 2. Iterate through the current river array.
        // 3. For each animal, decide its next move.
        // 4. Handle collisions and place animals in the new array.
        // 5. Replace the old river with the new one.
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
    }
}
              


