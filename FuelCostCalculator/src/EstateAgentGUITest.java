import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

/**
 * EstateAgentGUITest.java (Question 2 JUnit 5 Unit Tests)
 * Tests commission calculation logic and data validation rules for Q.2.8.
 */
public class EstateAgentGUITest {

    private EstateAgentGUI logic;

    @BeforeEach
    public void setUp() {
        logic = new EstateAgentGUI();
    }

    /**
     * Test Name: CalculateCommission_CalculatedSuccessfully
     * Test Purpose: Supply property price and commission percentage to CalculateCommission method.
     * Determines that the correct commission value (80,000.0) is returned.
     */
    @Test
    public void CalculateCommission_CalculatedSuccessfully() {
        String propertyPrice = "800000";
        String commissionPercentage = "10";
        double expectedCommission = 80000.0; // 800,000 * (10 / 100) = 80,000

        double actualCommission = logic.CalculateCommission(propertyPrice, commissionPercentage);

        assertEquals(expectedCommission, actualCommission, 0.001, "Calculated commission should equal 80000.0");
    }

    /**
     * Test Name: CalculateCommission_CalculatedUnSuccessfully
     * Test Purpose: Supply invalid/non-numeric strings to CalculateCommission method.
     * Determines if there is a calculation error (returns 0.0 default).
     */
    @Test
    public void CalculateCommission_CalculatedUnSuccessfully() {
        String propertyPrice = "invalid_price";
        String commissionPercentage = "10";
        double expectedCommission = 0.0;

        double actualCommission = logic.CalculateCommission(propertyPrice, commissionPercentage);

        assertEquals(expectedCommission, actualCommission, 0.001, "Calculated commission should return 0.0 for non-numeric input");
    }

    /**
     * Test Name: ValidationTest
     * Test Purpose: Verifies that ValidateData returns true for valid input data and false for invalid input.
     */
    @Test
    public void ValidationTest() {
        // Valid Data Test
        Data validData = new Data("Cape Town", "Joe Bloggs", "800000", "10");
        assertTrue(logic.ValidateData(validData), "Validation should pass for valid input data.");

        // Invalid Price Test (Price <= 0)
        Data invalidPriceData = new Data("Cape Town", "Joe Bloggs", "0", "10");
        assertFalse(logic.ValidateData(invalidPriceData), "Validation should fail when property price is <= 0.");

        // Invalid Empty Name Test
        Data emptyNameData = new Data("Cape Town", "", "800000", "10");
        assertFalse(logic.ValidateData(emptyNameData), "Validation should fail when agent name is empty.");
    }
}
