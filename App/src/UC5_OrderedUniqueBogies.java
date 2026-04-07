import java.util.LinkedHashSet;
import java.util.Set;

public class UC5_OrderedUniqueBogies {

    public static void main(String[] args) {

        // Step 1: Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Step 2: Create LinkedHashSet for Train Formation
        Set<String> trainFormation = new LinkedHashSet<>();

        // Step 3: Add Bogies
        trainFormation.add("Engine");
        trainFormation.add("Sleeper");
        trainFormation.add("Cargo");
        trainFormation.add("Guard");

        // Step 4: Attempt to Add Duplicate
        trainFormation.add("Sleeper"); // Duplicate (ignored)

        // Step 5: Display Formation
        System.out.println("\nTrain formation (in insertion order):");
        System.out.println(trainFormation);

        // Step 6: Display Total Count
        System.out.println("\nTotal bogies: " + trainFormation.size());

        // Step 7: Continue Program
        System.out.println("\nSystem is ready for further operations...");
    }
}