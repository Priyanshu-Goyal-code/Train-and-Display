import java.util.HashSet;
import java.util.Set;

public class UC3_UniqueBogieIDs {

    public static void main(String[] args) {

        // Step 1: Welcome Message
        System.out.println("=== Train Consist Management App ===");

        // Step 2: Create HashSet for Bogie IDs
        Set<String> bogieIds = new HashSet<>();

        // Step 3: Add Bogie IDs (including duplicates)
        bogieIds.add("BG101");
        bogieIds.add("BG102");
        bogieIds.add("BG103");
        bogieIds.add("BG101"); // Duplicate
        bogieIds.add("BG102"); // Duplicate

        // Step 4: Display Unique Bogie IDs
        System.out.println("\nBogie IDs after insertion (duplicates ignored):");
        System.out.println(bogieIds);

        // Step 5: Display Total Unique Count
        System.out.println("\nTotal unique bogies: " + bogieIds.size());

        // Step 6: Continue Program
        System.out.println("\nSystem is ready for further operations...");
    }
}