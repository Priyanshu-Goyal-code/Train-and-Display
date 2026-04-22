import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UseCase10CountTotalSeatsTest
 *
 * Test class for UseCase10CountTotalSeats
 * Tests for stream aggregation, capacity extraction, and numeric analytics
 */
public class UseCase10CountTotalSeatsTest {

    private UseCase10CountTotalSeats calculator;
    private List<Bogie> testBogies;

    @BeforeEach
    public void setUp() {
        calculator = new UseCase10CountTotalSeats();
        testBogies = new ArrayList<>();
    }

    /**
     * Test 1: Total Seat Calculation
     * Verifies that reduce() correctly calculates total seating capacity
     */
    @Test
    public void testReduce_TotalSeatCalculation() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertEquals(168, totalSeats);
    }

    /**
     * Test 2: Multiple Bogies Aggregation
     * Verifies that when multiple bogies exist, capacities are correctly summed
     */
    @Test
    public void testReduce_MultipleBogiesAggregation() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertEquals(72 + 72 + 56 + 56 + 56 + 40, totalSeats);
        assertEquals(352, totalSeats);
    }

    /**
     * Test 3: Single Bogie Handling
     * Verifies behavior when only one bogie exists
     */
    @Test
    public void testReduce_SingleBogieCapacity() {
        testBogies.add(new Bogie("Sleeper", 72));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertEquals(72, totalSeats);
    }

    /**
     * Test 4: Empty Collection Handling
     * Verifies that empty list returns identity value (0)
     */
    @Test
    public void testReduce_EmptyBogieList() {
        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertEquals(0, totalSeats);
    }

    /**
     * Test 5: Capacity Extraction Using map()
     * Verifies that map() correctly extracts capacity values
     */
    @Test
    public void testReduce_CorrectCapacityExtraction() {
        testBogies.add(new Bogie("Sleeper", 100));
        testBogies.add(new Bogie("AC Chair", 80));
        testBogies.add(new Bogie("First Class", 50));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        // Verify correct extraction: 100 + 80 + 50 = 230
        assertEquals(100 + 80 + 50, totalSeats);
        assertEquals(230, totalSeats);
    }

    /**
     * Test 6: All Bogies Included
     * Verifies that all bogies in collection are included in aggregation
     */
    @Test
    public void testReduce_AllBogiesIncluded() {
        testBogies.add(new Bogie("Sleeper", 10));
        testBogies.add(new Bogie("AC Chair", 20));
        testBogies.add(new Bogie("First Class", 30));
        testBogies.add(new Bogie("Sleeper", 40));
        testBogies.add(new Bogie("AC Chair", 50));

        int totalSeats = calculator.calculateTotalSeats(testBogies);
        int expectedTotal = 10 + 20 + 30 + 40 + 50;

        assertEquals(expectedTotal, totalSeats);
        assertEquals(150, totalSeats);
    }

    /**
     * Test 7: Original List Unchanged
     * Verifies that original list remains unchanged after aggregation
     */
    @Test
    public void testReduce_OriginalListUnchanged() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));

        int originalSize = testBogies.size();
        calculator.calculateTotalSeats(testBogies);

        assertEquals(originalSize, testBogies.size());
        assertTrue(testBogies.stream().anyMatch(b -> b.getName().equals("Sleeper")));
        assertTrue(testBogies.stream().anyMatch(b -> b.getCapacity() == 72));
    }

    /**
     * Test 8: Zero Capacity Bogies
     * Verifies handling of bogies with zero capacity
     */
    @Test
    public void testReduce_ZeroCapacityHandling() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("Goods", 0));
        testBogies.add(new Bogie("AC Chair", 56));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertEquals(72 + 0 + 56, totalSeats);
        assertEquals(128, totalSeats);
    }

    /**
     * Test 9: Large Capacity Values
     * Verifies aggregation with large capacity numbers
     */
    @Test
    public void testReduce_LargeCapacityValues() {
        testBogies.add(new Bogie("Sleeper", 1000));
        testBogies.add(new Bogie("AC Chair", 2000));
        testBogies.add(new Bogie("First Class", 3000));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertEquals(1000 + 2000 + 3000, totalSeats);
        assertEquals(6000, totalSeats);
    }

    /**
     * Test 10: Many Bogies Collection
     * Verifies aggregation with large number of bogies
     */
    @Test
    public void testReduce_ManyBogiesCollection() {
        for (int i = 0; i < 100; i++) {
            testBogies.add(new Bogie("Sleeper", 10));
        }

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertEquals(100 * 10, totalSeats);
        assertEquals(1000, totalSeats);
    }

    /**
     * Test 11: Mixed Capacity Values
     * Verifies aggregation with varied capacity values
     */
    @Test
    public void testReduce_MixedCapacityValues() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));
        testBogies.add(new Bogie("Economy", 100));
        testBogies.add(new Bogie("Premium", 30));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertEquals(72 + 56 + 40 + 100 + 30, totalSeats);
        assertEquals(298, totalSeats);
    }

    /**
     * Test 12: Result Greater Than Zero
     * Verifies that result is positive for non-empty collections
     */
    @Test
    public void testReduce_ResultGreaterThanZero() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertTrue(totalSeats > 0);
    }

    /**
     * Test 13: Alternative Method Consistency
     * Verifies that alternative implementation produces same result
     */
    @Test
    public void testReduce_AlternativeMethodConsistency() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));

        int totalSeats = calculator.calculateTotalSeats(testBogies);
        int alternativeTotal = calculator.calculateTotalSeatsAlternative(testBogies);

        assertEquals(totalSeats, alternativeTotal);
    }

    /**
     * Test 14: Capacity Sum Verification
     * Verifies aggregation result matches manual calculation
     */
    @Test
    public void testReduce_CapacitySumVerification() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));
        testBogies.add(new Bogie("Sleeper", 72));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        // Manual verification
        int manualSum = 0;
        for (Bogie bogie : testBogies) {
            manualSum += bogie.getCapacity();
        }

        assertEquals(manualSum, totalSeats);
    }

    /**
     * Test 15: Identical Bogies Aggregation
     * Verifies aggregation when all bogies have same capacity
     */
    @Test
    public void testReduce_IdenticalBogiesAggregation() {
        testBogies.add(new Bogie("Standard", 50));
        testBogies.add(new Bogie("Standard", 50));
        testBogies.add(new Bogie("Standard", 50));
        testBogies.add(new Bogie("Standard", 50));

        int totalSeats = calculator.calculateTotalSeats(testBogies);

        assertEquals(4 * 50, totalSeats);
        assertEquals(200, totalSeats);
    }
}
