/**
 * IEstateAgentGUI.java (Question 2 Interface)
 * Interface specifying contract for GUI commission calculations and data validation.
 */
public interface IEstateAgentGUI {
    double CalculateCommission(String propertyPrice, String agentCommission);
    boolean ValidateData(Data dataToValidate);
}
