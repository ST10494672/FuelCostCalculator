import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * EstateAgentTest.java (Question 1 JUnit 5 Unit Tests)
 * Tests total sales, 2% commission calculations, and top agent identification.
 */
public class EstateAgentTest {

    private EstateAgent estateAgent;

    @BeforeEach
    public void setUp() {
        estateAgent = new EstateAgent();
    }

    /**
     * Test Name: CalculateTotalSales_ReturnsTotalSales
     * Test Purpose: To supply property sales to EstateAgentSales method and verify total.
     */
    @Test
    public void CalculateTotalSales_ReturnsTotalSales() {
        double[] joeBloggsSales = {800000.0, 1500000.0, 2000000.0};
        double expectedTotal = 4300000.0; // 800,000 + 1,500,000 + 2,000,000
        double actualTotal = estateAgent.EstateAgentSales(joeBloggsSales);

        assertEquals(expectedTotal, actualTotal, 0.001, "Total sales for Joe Bloggs should equal 4300000.0");
    }

    /**
     * Test Name: CalculateTotalCommission_ReturnsCommission
     * Test Purpose: To supply total sales amount to EstateAgentCommission method and verify 2% commission.
     */
    @Test
    public void CalculateTotalCommission_ReturnsCommission() {
        double joeBloggsTotalSales = 4300000.0;
        double expectedCommission = 86000.0; // 4,300,000 * 0.02 = 86,000
        double actualCommission = estateAgent.EstateAgentCommission(joeBloggsTotalSales);

        assertEquals(expectedCommission, actualCommission, 0.001, "Commission for Joe Bloggs should equal 86000.0");
    }

    /**
     * Test Name: TopAgent_ReturnsTopPosition
     * Test Purpose: To supply total sales array to TopEstateAgent method and verify top agent index.
     */
    @Test
    public void TopAgent_ReturnsTopPosition() {
        double[] totalSales = {4300000.0, 3500000.0}; // Joe Bloggs = 4.3M, Jane Doe = 3.5M
        int expectedTopIndex = 0; // Joe Bloggs at index 0
        int actualTopIndex = estateAgent.TopEstateAgent(totalSales);

        assertEquals(expectedTopIndex, actualTopIndex, "Top performing estate agent index should be 0 (Joe Bloggs)");
    }
}
