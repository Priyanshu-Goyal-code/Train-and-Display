import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 * UseCase11ValidateTrainIDAndCargoCode
 *
 * This class demonstrates input validation using Regular Expressions (Regex).
 * Validates Train ID and Cargo Code formats to ensure data integrity before processing.
 * Uses Pattern and Matcher classes for robust format enforcement.
 */
public class UseCase11ValidateTrainIDAndCargoCode {

    // Regex patterns for validation
    private static final String TRAIN_ID_PATTERN = "TRN-\\d{4}";      // TRN- followed by exactly 4 digits
    private static final String CARGO_CODE_PATTERN = "PET-[A-Z]{2}";  // PET- followed by exactly 2 uppercase letters

    // Compiled patterns for reuse
    private final Pattern trainIdPattern;
    private final Pattern cargoCodePattern;

    /**
     * Constructor - Compiles regex patterns for efficient reuse
     */
    public UseCase11ValidateTrainIDAndCargoCode() {
        this.trainIdPattern = Pattern.compile(TRAIN_ID_PATTERN);
        this.cargoCodePattern = Pattern.compile(CARGO_CODE_PATTERN);
    }

    /**
     * Validates Train ID format
     * Valid format: TRN-1234 (TRN- followed by exactly 4 digits)
     *
     * @param trainId the train ID to validate
     * @return true if Train ID matches the pattern, false otherwise
     */
    public boolean isValidTrainID(String trainId) {
        if (trainId == null || trainId.isEmpty()) {
            return false;
        }
        Matcher matcher = trainIdPattern.matcher(trainId);
        return matcher.matches();
    }

    /**
     * Validates Cargo Code format
     * Valid format: PET-AB (PET- followed by exactly 2 uppercase letters)
     *
     * @param cargoCode the cargo code to validate
     * @return true if Cargo Code matches the pattern, false otherwise
     */
    public boolean isValidCargoCode(String cargoCode) {
        if (cargoCode == null || cargoCode.isEmpty()) {
            return false;
        }
        Matcher matcher = cargoCodePattern.matcher(cargoCode);
        return matcher.matches();
    }

    /**
     * Validates both Train ID and Cargo Code
     *
     * @param trainId the train ID to validate
     * @param cargoCode the cargo code to validate
     * @return true if both are valid, false otherwise
     */
    public boolean isValidTrainAndCargo(String trainId, String cargoCode) {
        return isValidTrainID(trainId) && isValidCargoCode(cargoCode);
    }

    /**
     * Gets the Train ID regex pattern for reference
     */
    public String getTrainIdPatternInfo() {
        return "Train ID Pattern: " + TRAIN_ID_PATTERN + " (Example: TRN-1234)";
    }

    /**
     * Gets the Cargo Code regex pattern for reference
     */
    public String getCargoCodePatternInfo() {
        return "Cargo Code Pattern: " + CARGO_CODE_PATTERN + " (Example: PET-AB)";
    }

    /**
     * Main method to demonstrate UC11 functionality
     */
    public static void main(String[] args) {

        // Step 1: Welcome Message
        System.out.println("=== Train Consist Management App ===");
        System.out.println("Use Case 11: Validate Train ID & Cargo Codes");

        // Step 2: Create validator instance
        UseCase11ValidateTrainIDAndCargoCode validator = new UseCase11ValidateTrainIDAndCargoCode();

        // Step 3: Display regex patterns
        System.out.println("\n--- Validation Patterns ---");
        System.out.println(validator.getTrainIdPatternInfo());
        System.out.println(validator.getCargoCodePatternInfo());

        // Step 4: Test valid inputs
        System.out.println("\n--- Valid Input Tests ---");
        String validTrainID = "TRN-1234";
        String validCargoCode = "PET-AB";

        System.out.println("Testing Train ID: " + validTrainID);
        System.out.println("  Valid: " + validator.isValidTrainID(validTrainID));

        System.out.println("Testing Cargo Code: " + validCargoCode);
        System.out.println("  Valid: " + validator.isValidCargoCode(validCargoCode));

        // Step 5: Test invalid inputs
        System.out.println("\n--- Invalid Input Tests ---");
        String[] invalidTrainIDs = {"TRAIN12", "TRN12A", "1234-TRN", "TRN-123", "TRN-12345", "trn-1234"};
        for (String id : invalidTrainIDs) {
            System.out.println("Testing Train ID: " + id + " -> Valid: " + validator.isValidTrainID(id));
        }

        System.out.println();
        String[] invalidCargoCodes = {"PET-ab", "PET123", "AB-PET", "PET-A", "PET-ABC", "pet-AB"};
        for (String code : invalidCargoCodes) {
            System.out.println("Testing Cargo Code: " + code + " -> Valid: " + validator.isValidCargoCode(code));
        }

        // Step 6: Test combined validation
        System.out.println("\n--- Combined Validation ---");
        System.out.println("Train ID: " + validTrainID + ", Cargo Code: " + validCargoCode);
        System.out.println("  Both Valid: " + validator.isValidTrainAndCargo(validTrainID, validCargoCode));

        System.out.println("Train ID: INVALID, Cargo Code: " + validCargoCode);
        System.out.println("  Both Valid: " + validator.isValidTrainAndCargo("INVALID", validCargoCode));

        // Step 7: Test edge cases
        System.out.println("\n--- Edge Cases ---");
        System.out.println("Empty Train ID: " + validator.isValidTrainID(""));
        System.out.println("Null Train ID: " + validator.isValidTrainID(null));
        System.out.println("Empty Cargo Code: " + validator.isValidCargoCode(""));
        System.out.println("Null Cargo Code: " + validator.isValidCargoCode(null));

        // Step 8: Continue Program
        System.out.println("\nSystem validation complete. Ready for further operations...");
    }
}
