/**
 * IEstateAgent.java (Question 1 Interface)
 * Interface specifying contract for estate agent sales calculations.
 */
public interface IEstateAgent {
    double EstateAgentSales(double[] propertySales);
    double EstateAgentCommission(double propertySales);
    int TopEstateAgent(double[] totalSales);
}
