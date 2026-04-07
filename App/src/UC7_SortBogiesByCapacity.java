import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Step 1: Create Bogie Class
class Bogie {
    String name;
    int capacity;

    // Constructor
    Bogie(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // toString() for clean output
    @Override
    public String toString() {
        return name + " (Capacity: " + capacity + ")";
    }
}

public class UC7_SortBogiesByCapacity {

    public static void main(String[] args) {

        // Step 2: Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Step 3: Create List of Bogies
        List<Bogie> bogies = new ArrayList<>();

        // Step 4: Add Bogie Objects
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 40));

        System.out.println("\nBefore Sorting:");
        System.out.println(bogies);

        // Step 5: Sort using Comparator (by capacity)
        bogies.sort(Comparator.comparingInt(b -> b.capacity));

        System.out.println("\nAfter Sorting (by capacity ascending):");
        System.out.println(bogies);

        // Step 6: Continue Program
        System.out.println("\nSystem is ready for further operations...");
    }
}