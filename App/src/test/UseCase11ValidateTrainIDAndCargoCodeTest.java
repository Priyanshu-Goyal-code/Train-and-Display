import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UseCase11ValidateTrainIDAndCargoCodeTest
 *
 * Test class for UseCase11ValidateTrainIDAndCargoCode
 * Tests for regex validation, format enforcement, and data integrity
 */
public class UseCase11ValidateTrainIDAndCargoCodeTest {

    private UseCase11ValidateTrainIDAndCargoCode validator;

    @BeforeEach
    public void setUp() {
        validator = new UseCase11ValidateTrainIDAndCargoCode();
    }

    // ==================== Train ID Validation Tests ====================

    /**
     * Test 1: Valid Train ID Format
     * Verifies that a correctly formatted Train ID is accepted
     */
    @Test
    public void testRegex_ValidTrainID() {
        assertTrue(validator.isValidTrainID("TRN-1234"));
    }

    /**
     * Test 2: Invalid Train ID - Missing Hyphen
     * Verifies that Train ID without hyphen is rejected
     */
    @Test
    public void testRegex_InvalidTrainIDMissingHyphen() {
        assertFalse(validator.isValidTrainID("TRN1234"));
    }

    /**
     * Test 3: Invalid Train ID - Wrong Prefix
     * Verifies that Train ID with wrong prefix is rejected
     */
    @Test
    public void testRegex_InvalidTrainIDWrongPrefix() {
        assertFalse(validator.isValidTrainID("TRAIN-1234"));
    }

    /**
     * Test 4: Invalid Train ID - Alphabetic Characters in Numbers
     * Verifies that Train ID with letters in numeric part is rejected
     */
    @Test
    public void testRegex_InvalidTrainIDAlphabeticNumbers() {
        assertFalse(validator.isValidTrainID("TRN-12A4"));
    }

    /**
     * Test 5: Train ID Digit Length Validation - Too Few
     * Verifies that Train ID with fewer than 4 digits is rejected
     */
    @Test
    public void testRegex_TrainIDTooFewDigits() {
        assertFalse(validator.isValidTrainID("TRN-123"));
    }

    /**
     * Test 6: Train ID Digit Length Validation - Too Many
     * Verifies that Train ID with more than 4 digits is rejected
     */
    @Test
    public void testRegex_TrainIDTooManyDigits() {
        assertFalse(validator.isValidTrainID("TRN-12345"));
    }

    /**
     * Test 7: Invalid Train ID - Case Sensitivity
     * Verifies that lowercase train ID is rejected
     */
    @Test
    public void testRegex_InvalidTrainIDLowercase() {
        assertFalse(validator.isValidTrainID("trn-1234"));
    }

    /**
     * Test 8: Invalid Train ID - Reversed Format
     * Verifies that reversed format is rejected
     */
    @Test
    public void testRegex_InvalidTrainIDReversed() {
        assertFalse(validator.isValidTrainID("1234-TRN"));
    }

    /**
     * Test 9: Valid Train ID - Multiple Examples
     * Verifies multiple valid Train ID formats
     */
    @Test
    public void testRegex_ValidTrainIDMultipleExamples() {
        assertTrue(validator.isValidTrainID("TRN-0000"));
        assertTrue(validator.isValidTrainID("TRN-9999"));
        assertTrue(validator.isValidTrainID("TRN-5678"));
    }

    // ==================== Cargo Code Validation Tests ====================

    /**
     * Test 10: Valid Cargo Code Format
     * Verifies that a correctly formatted Cargo Code is accepted
     */
    @Test
    public void testRegex_ValidCargoCode() {
        assertTrue(validator.isValidCargoCode("PET-AB"));
    }

    /**
     * Test 11: Invalid Cargo Code - Lowercase Letters
     * Verifies that Cargo Code with lowercase letters is rejected
     */
    @Test
    public void testRegex_InvalidCargoCodeLowercase() {
        assertFalse(validator.isValidCargoCode("PET-ab"));
    }

    /**
     * Test 12: Invalid Cargo Code - Numeric Characters
     * Verifies that Cargo Code with numbers is rejected
     */
    @Test
    public void testRegex_InvalidCargoCodeNumeric() {
        assertFalse(validator.isValidCargoCode("PET-12"));
    }

    /**
     * Test 13: Invalid Cargo Code - Mixed Case
     * Verifies that Cargo Code with mixed case is rejected
     */
    @Test
    public void testRegex_InvalidCargoCodeMixedCase() {
        assertFalse(validator.isValidCargoCode("PET-Ab"));
    }

    /**
     * Test 14: Cargo Code Uppercase Validation
     * Verifies that only uppercase letters are accepted
     */
    @Test
    public void testRegex_CargoCodeUppercaseValidation() {
        assertTrue(validator.isValidCargoCode("PET-XY"));
        assertTrue(validator.isValidCargoCode("PET-AA"));
        assertTrue(validator.isValidCargoCode("PET-ZZ"));
        assertFalse(validator.isValidCargoCode("PET-xy"));
    }

    /**
     * Test 15: Invalid Cargo Code - Too Few Letters
     * Verifies that Cargo Code with fewer than 2 letters is rejected
     */
    @Test
    public void testRegex_InvalidCargoCodeTooFewLetters() {
        assertFalse(validator.isValidCargoCode("PET-A"));
    }

    /**
     * Test 16: Invalid Cargo Code - Too Many Letters
     * Verifies that Cargo Code with more than 2 letters is rejected
     */
    @Test
    public void testRegex_InvalidCargoCodeTooManyLetters() {
        assertFalse(validator.isValidCargoCode("PET-ABC"));
    }

    /**
     * Test 17: Invalid Cargo Code - Wrong Prefix
     * Verifies that Cargo Code with wrong prefix is rejected
     */
    @Test
    public void testRegex_InvalidCargoCodeWrongPrefix() {
        assertFalse(validator.isValidCargoCode("PETRO-AB"));
    }

    /**
     * Test 18: Invalid Cargo Code - Reversed Format
     * Verifies that reversed format is rejected
     */
    @Test
    public void testRegex_InvalidCargoCodeReversed() {
        assertFalse(validator.isValidCargoCode("AB-PET"));
    }

    /**
     * Test 19: Valid Cargo Code - Multiple Examples
     * Verifies multiple valid Cargo Code formats
     */
    @Test
    public void testRegex_ValidCargoCodeMultipleExamples() {
        assertTrue(validator.isValidCargoCode("PET-AA"));
        assertTrue(validator.isValidCargoCode("PET-ZZ"));
        assertTrue(validator.isValidCargoCode("PET-MN"));
    }

    // ==================== Empty Input Handling Tests ====================

    /**
     * Test 20: Empty Train ID
     * Verifies that empty Train ID string is rejected
     */
    @Test
    public void testRegex_EmptyTrainID() {
        assertFalse(validator.isValidTrainID(""));
    }

    /**
     * Test 21: Empty Cargo Code
     * Verifies that empty Cargo Code string is rejected
     */
    @Test
    public void testRegex_EmptyCargoCode() {
        assertFalse(validator.isValidCargoCode(""));
    }

    /**
     * Test 22: Null Train ID
     * Verifies that null Train ID is handled without exception
     */
    @Test
    public void testRegex_NullTrainID() {
        assertFalse(validator.isValidTrainID(null));
    }

    /**
     * Test 23: Null Cargo Code
     * Verifies that null Cargo Code is handled without exception
     */
    @Test
    public void testRegex_NullCargoCode() {
        assertFalse(validator.isValidCargoCode(null));
    }

    // ==================== Exact Pattern Matching Tests ====================

    /**
     * Test 24: Train ID with Extra Characters - Prefix
     * Verifies that Train ID with extra prefix characters is rejected
     */
    @Test
    public void testRegex_TrainIDExtraPrefix() {
        assertFalse(validator.isValidTrainID("XTRN-1234"));
    }

    /**
     * Test 25: Train ID with Extra Characters - Suffix
     * Verifies that Train ID with extra suffix characters is rejected
     */
    @Test
    public void testRegex_TrainIDExtraSuffix() {
        assertFalse(validator.isValidTrainID("TRN-1234X"));
    }

    /**
     * Test 26: Train ID with Spaces
     * Verifies that Train ID with spaces is rejected
     */
    @Test
    public void testRegex_TrainIDWithSpaces() {
        assertFalse(validator.isValidTrainID("TRN- 1234"));
        assertFalse(validator.isValidTrainID("TRN -1234"));
    }

    /**
     * Test 27: Cargo Code with Extra Characters
     * Verifies that Cargo Code with extra characters is rejected
     */
    @Test
    public void testRegex_CargoCodeExtraCharacters() {
        assertFalse(validator.isValidCargoCode("PET-ABC"));
        assertFalse(validator.isValidCargoCode("XPET-AB"));
    }

    /**
     * Test 28: Cargo Code with Spaces
     * Verifies that Cargo Code with spaces is rejected
     */
    @Test
    public void testRegex_CargoCodeWithSpaces() {
        assertFalse(validator.isValidCargoCode("PET- AB"));
        assertFalse(validator.isValidCargoCode("PET -AB"));
    }

    // ==================== Combined Validation Tests ====================

    /**
     * Test 29: Valid Train ID and Cargo Code
     * Verifies that both valid formats pass combined validation
     */
    @Test
    public void testRegex_ValidBoth() {
        assertTrue(validator.isValidTrainAndCargo("TRN-1234", "PET-AB"));
    }

    /**
     * Test 30: Invalid Train ID, Valid Cargo Code
     * Verifies that invalid Train ID fails combined validation
     */
    @Test
    public void testRegex_InvalidTrainValidCargo() {
        assertFalse(validator.isValidTrainAndCargo("INVALID", "PET-AB"));
    }

    /**
     * Test 31: Valid Train ID, Invalid Cargo Code
     * Verifies that invalid Cargo Code fails combined validation
     */
    @Test
    public void testRegex_ValidTrainInvalidCargo() {
        assertFalse(validator.isValidTrainAndCargo("TRN-1234", "INVALID"));
    }

    /**
     * Test 32: Both Invalid
     * Verifies that invalid formats fail combined validation
     */
    @Test
    public void testRegex_InvalidBoth() {
        assertFalse(validator.isValidTrainAndCargo("INVALID", "INVALID"));
    }

    // ==================== Pattern Information Tests ====================

    /**
     * Test 33: Train ID Pattern Info
     * Verifies that pattern information is available
     */
    @Test
    public void testRegex_TrainIDPatternInfo() {
        String info = validator.getTrainIdPatternInfo();
        assertNotNull(info);
        assertTrue(info.contains("TRN"));
        assertTrue(info.contains("1234"));
    }

    /**
     * Test 34: Cargo Code Pattern Info
     * Verifies that pattern information is available
     */
    @Test
    public void testRegex_CargoCodePatternInfo() {
        String info = validator.getCargoCodePatternInfo();
        assertNotNull(info);
        assertTrue(info.contains("PET"));
        assertTrue(info.contains("AB"));
    }

    // ==================== Original Input Integrity Tests ====================

    /**
     * Test 35: Validation Does Not Modify Input
     * Verifies that validation operations don't modify original strings
     */
    @Test
    public void testRegex_OriginalInputIntegrity() {
        String trainID = "TRN-1234";
        String originalTrainID = trainID;
        validator.isValidTrainID(trainID);
        assertEquals(originalTrainID, trainID);

        String cargoCode = "PET-AB";
        String originalCargoCode = cargoCode;
        validator.isValidCargoCode(cargoCode);
        assertEquals(originalCargoCode, cargoCode);
    }
}
