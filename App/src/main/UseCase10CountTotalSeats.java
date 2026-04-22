import java.util.ArrayList;
import java.util.List;

/**
 * UseCase10CountTotalSeats
 *
 * This class demonstrates stream aggregation using map() and reduce()
 * to calculate the total seating capacity of all bogies in the train.
 * Introduces functional aggregation for quantitative analysis.
 */

class Bogie {
    String name;
    int capacity;

    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class UseCase10CountTotalSeats {

    /**
     * Calculates total seating capacity using map() and reduce()
     * map() extracts capacity values from each bogie
     * reduce() sums all capacities into a single total
     *
     * @param bogies the list of bogies
     * @return total seating capacity
     */
    public int calculateTotalSeats(List<Bogie> bogies) {
        return bogies.stream()
                .map(Bogie::getCapacity)          // Extract capacity values
                .reduce(0, Integer::sum);          // Sum all capacities
    }

    /**
     * Alternative implementation using method reference
     * Demonstrates different aggregation approaches
     */
    public int calculateTotalSeatsAlternative(List<Bogie> bogies) {
        return bogies.stream()
                .mapToInt(Bogie::getCapacity)     // Map to IntStream
                .sum();                           // Direct sum operation
    }

    /**
     * Main method to demonstrate UC10 functionality
     */
    public static void main(String[] args) {

        // Step 1: Welcome Message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Use Case 10: Count Total Seats in Train");

        // Step 2: Create List of Bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        System.out.println("\nOriginal Bogie List:");
        bogies.forEach(System.out::println);

        // Step 3: Display individual capacities
        System.out.println("\nBogie Capacities:");
        bogies.forEach(b -> System.out.println("  " + b.getName() + ": " + b.getCapacity() + " seats"));

        // Step 4: Create instance and calculate total
        UseCase10CountTotalSeats calculator = new UseCase10CountTotalSeats();
        int totalSeats = calculator.calculateTotalSeats(bogies);

        // Step 5: Display Total Seating Capacity
        System.out.println("\n--- Stream Aggregation Result ---");
        System.out.println("Total Seating Capacity of Train: " + totalSeats + " seats");

        // Step 6: Demonstrate stream pipeline
        System.out.println("\n--- Stream Pipeline Breakdown ---");
        System.out.println("Step 1: Convert list to stream");
        System.out.println("Step 2: map() - Extract capacity values");
        System.out.println("Step 3: reduce(0, Integer::sum) - Sum all capacities");
        System.out.println("Result: " + totalSeats);

        // Step 7: Calculate capacity breakdown
        System.out.println("\n--- Capacity Analysis ---");
        int sleepersCapacity = bogies.stream()
                .filter(b -> b.getName().equals("Sleeper"))
                .mapToInt(Bogie::getCapacity)
                .sum();

        int acChairCapacity = bogies.stream()
                .filter(b -> b.getName().equals("AC Chair"))
                .mapToInt(Bogie::getCapacity)
                .sum();

        int firstClassCapacity = bogies.stream()
                .filter(b -> b.getName().equals("First Class"))
                .mapToInt(Bogie::getCapacity)
                .sum();

        System.out.println("Sleeper Capacity: " + sleepersCapacity + " seats");
        System.out.println("AC Chair Capacity: " + acChairCapacity + " seats");
        System.out.println("First Class Capacity: " + firstClassCapacity + " seats");
        System.out.println("Total: " + (sleepersCapacity + acChairCapacity + firstClassCapacity) + " seats");

        // Step 8: Verify Original List Unchanged
        System.out.println("\nOriginal Bogie List After Aggregation (unchanged):");
        bogies.forEach(System.out::println);

        // Step 9: Continue Program
        System.out.println("\nSystem is ready for further operations...");
    }
}
