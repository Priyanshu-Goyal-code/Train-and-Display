import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.*;

/**
 * UseCase9GroupBogiesByTypeTest
 *
 * Test class for UseCase9GroupBogiesByType
 * Tests for stream grouping behavior, category classification, and data integrity
 */
public class UseCase9GroupBogiesByTypeTest {

    private UseCase9GroupBogiesByType grouper;
    private List<Bogie> testBogies;

    @BeforeEach
    public void setUp() {
        grouper = new UseCase9GroupBogiesByType();
        testBogies = new ArrayList<>();
    }

    /**
     * Test 1: Stream Grouping Behavior
     * Verifies that bogies are correctly grouped based on their type
     */
    @Test
    public void testGrouping_BogiesGroupedByType() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("Sleeper", 72));

        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        assertNotNull(grouped);
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertEquals(2, grouped.get("Sleeper").size());
    }

    /**
     * Test 2: Multiple Bogies in Same Group
     * Verifies that multiple bogies with same type are grouped together
     */
    @Test
    public void testGrouping_MultipleBogiesInSameGroup() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("Sleeper", 72));

        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        assertEquals(1, grouped.size());
        assertEquals(3, grouped.get("Sleeper").size());
    }

    /**
     * Test 3: Different Bogie Types
     * Verifies that bogies with different types are separated into different groups
     */
    @Test
    public void testGrouping_DifferentBogieTypes() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));

        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        assertEquals(3, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
        assertTrue(grouped.containsKey("AC Chair"));
        assertTrue(grouped.containsKey("First Class"));
    }

    /**
     * Test 4: Empty Bogie List
     * Verifies that grouping an empty list returns empty map without errors
     */
    @Test
    public void testGrouping_EmptyBogieList() {
        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        assertNotNull(grouped);
        assertTrue(grouped.isEmpty());
        assertEquals(0, grouped.size());
    }

    /**
     * Test 5: Single Bogie Category
     * Verifies behavior when only one bogie type exists
     */
    @Test
    public void testGrouping_SingleBogieCategory() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("Sleeper", 72));

        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        assertEquals(1, grouped.size());
        assertTrue(grouped.containsKey("Sleeper"));
        assertEquals(2, grouped.get("Sleeper").size());
    }

    /**
     * Test 6: Map Contains Correct Keys
     * Verifies that the grouped map contains expected bogie type keys
     */
    @Test
    public void testGrouping_MapContainsCorrectKeys() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));

        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        assertTrue(grouped.keySet().contains("Sleeper"));
        assertTrue(grouped.keySet().contains("AC Chair"));
        assertTrue(grouped.keySet().contains("First Class"));
    }

    /**
     * Test 7: Group Size Validation
     * Verifies that the number of bogies within each group matches expected count
     */
    @Test
    public void testGrouping_GroupSizeValidation() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));

        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        assertEquals(2, grouped.get("Sleeper").size());
        assertEquals(3, grouped.get("AC Chair").size());
        assertEquals(1, grouped.get("First Class").size());
    }

    /**
     * Test 8: Original List Unchanged
     * Verifies that the original bogie list remains unchanged after grouping
     */
    @Test
    public void testGrouping_OriginalListUnchanged() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("First Class", 40));

        int originalSize = testBogies.size();
        grouper.groupBogiesByType(testBogies);

        assertEquals(originalSize, testBogies.size());
        assertTrue(testBogies.stream().anyMatch(b -> b.getName().equals("Sleeper")));
    }

    /**
     * Test 9: Map Structure Validation
     * Verifies that grouped result follows Map<String, List<Bogie>> structure
     */
    @Test
    public void testGrouping_MapStructureValidation() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));

        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        assertNotNull(grouped);
        for (Map.Entry<String, List<Bogie>> entry : grouped.entrySet()) {
            assertNotNull(entry.getKey());
            assertNotNull(entry.getValue());
            assertTrue(entry.getValue().stream().allMatch(b -> b.getName().equals(entry.getKey())));
        }
    }

    /**
     * Test 10: Grouping Result Non-Null
     * Verifies that grouping never returns null
     */
    @Test
    public void testGrouping_ResultNonNull() {
        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);
        assertNotNull(grouped);
    }

    /**
     * Test 11: Each Bogie in Correct Group
     * Verifies that each bogie is placed in the group corresponding to its name
     */
    @Test
    public void testGrouping_EachBogieInCorrectGroup() {
        testBogies.add(new Bogie("Sleeper", 72));
        testBogies.add(new Bogie("AC Chair", 56));
        testBogies.add(new Bogie("Sleeper", 72));

        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        for (String type : grouped.keySet()) {
            for (Bogie bogie : grouped.get(type)) {
                assertEquals(type, bogie.getName());
            }
        }
    }

    /**
     * Test 12: Large Bogie Collection
     * Verifies grouping works correctly with larger collections
     */
    @Test
    public void testGrouping_LargeBogieCollection() {
        for (int i = 0; i < 10; i++) {
            testBogies.add(new Bogie("Sleeper", 72));
        }
        for (int i = 0; i < 15; i++) {
            testBogies.add(new Bogie("AC Chair", 56));
        }
        for (int i = 0; i < 5; i++) {
            testBogies.add(new Bogie("First Class", 40));
        }

        Map<String, List<Bogie>> grouped = grouper.groupBogiesByType(testBogies);

        assertEquals(3, grouped.size());
        assertEquals(10, grouped.get("Sleeper").size());
        assertEquals(15, grouped.get("AC Chair").size());
        assertEquals(5, grouped.get("First Class").size());
    }
}
