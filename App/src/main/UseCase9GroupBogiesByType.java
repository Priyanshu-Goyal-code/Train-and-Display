import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * UseCase9GroupBogiesByType
 *
 * This class demonstrates grouping bogies by type using Collectors.groupingBy()
 * Bogies are organized into categories based on their type/name for better reporting
 * and analysis in the Train Consist Management system.
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

public class UseCase9GroupBogiesByType {

    /**
     * Groups bogies by their type/name using Collectors.groupingBy()
     * @param bogies the list of bogies to group
     * @return Map with bogie type as key and list of bogies as value
     */
    public Map<String, List<Bogie>> groupBogiesByType(List<Bogie> bogies) {
        return bogies.stream()
                .collect(Collectors.groupingBy(Bogie::getName));
    }

    /**
     * Main method to demonstrate UC9 functionality
     */
    public static void main(String[] args) {

        // Step 1: Welcome Message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Use Case 9: Group Bogies by Type");

        // Step 2: Create List of Bogies
        List<Bogie> bogies = new ArrayList<>();
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));
        bogies.add(new Bogie("First Class", 40));
        bogies.add(new Bogie("Sleeper", 72));
        bogies.add(new Bogie("AC Chair", 56));

        System.out.println("\nOriginal Bogie List:");
        System.out.println(bogies);

        // Step 3: Create instance and group bogies
        UseCase9GroupBogiesByType grouper = new UseCase9GroupBogiesByType();
        Map<String, List<Bogie>> groupedBogies = grouper.groupBogiesByType(bogies);

        // Step 4: Display Grouped Result
        System.out.println("\nGrouped Bogies by Type:");
        groupedBogies.forEach((type, bogieList) -> {
            System.out.println("\n" + type + ":");
            bogieList.forEach(bogie -> System.out.println("  - " + bogie));
        });

        // Step 5: Display grouping statistics
        System.out.println("\n\nGrouping Statistics:");
        groupedBogies.forEach((type, bogieList) -> {
            System.out.println(type + ": " + bogieList.size() + " bogie(s)");
        });

        // Step 6: Verify Original List Unchanged
        System.out.println("\nOriginal Bogie List After Grouping (unchanged):");
        System.out.println(bogies);

        // Step 7: Continue Program
        System.out.println("\nSystem is ready for further operations...");
    }
}
