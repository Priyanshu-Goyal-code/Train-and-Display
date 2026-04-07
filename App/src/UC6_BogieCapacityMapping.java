import java.util.HashMap;
import java.util.Map;

public class UC6_BogieCapacityMapping {

    public static void main(String[] args) {

        // Step 1: Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Step 2: Create HashMap (Bogie → Capacity)
        Map<String, Integer> bogieCapacityMap = new HashMap<>();

        // Step 3: Insert Bogie-Capacity Data
        bogieCapacityMap.put("Sleeper", 72);
        bogieCapacityMap.put("AC Chair", 60);
        bogieCapacityMap.put("First Class", 40);

        // Step 4: Display Bogie Capacity Details
        System.out.println("\nBogie Capacity Details:");

        for (Map.Entry<String, Integer> entry : bogieCapacityMap.entrySet()) {
            String bogie = entry.getKey();
            int capacity = entry.getValue();

            System.out.println(bogie + " -> Capacity: " + capacity);
        }

        // Step 5: Continue Program
        System.out.println("\nSystem is ready for further operations...");
    }
}