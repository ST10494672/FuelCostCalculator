/**
 * EstateAgent.java (Question 1 Business Logic Class)
 * Implements IEstateAgent interface to calculate total sales, 2% commission,
 * and determine the top-performing estate agent.
 */
public class EstateAgent implements IEstateAgent {

    private static final double COMMISSION_RATE = 0.02; // 2% commission

    /**
     * Calculates total property sales for an estate agent.
     * @param propertySales 1D array of monthly property sales
     * @return sum of sales
     */
    @Override
    public double EstateAgentSales(double[] propertySales) {
        if (propertySales == null) {
            return 0.0;
        }
        double total = 0.0;
        for (double sale : propertySales) {
            total += sale;
        }
        return total;
    }

    /**
     * Calculates 2% commission earned on total property sales.
     * @param propertySales total sales amount
     * @return 2% of total sales
     */
    @Override
    public double EstateAgentCommission(double propertySales) {
        return propertySales * COMMISSION_RATE;
    }

    /**
     * Determines the index of the top-performing estate agent.
     * @param totalSales array containing total sales for each agent
     * @return index (0 or 1) of the agent with highest sales
     */
    @Override
    public int TopEstateAgent(double[] totalSales) {
        if (totalSales == null || totalSales.length == 0) {
            return -1;
        }
        int topIndex = 0;
        double maxSales = totalSales[0];
        for (int i = 1; i < totalSales.length; i++) {
            if (totalSales[i] > maxSales) {
                maxSales = totalSales[i];
                topIndex = i;
            }
        }
        return topIndex;
    }
}
