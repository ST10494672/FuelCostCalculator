/**
 * EstateAgentGUI.java (Question 2 Business Logic Class)
 * Implements IEstateAgentGUI interface to calculate commission and validate GUI inputs.
 */
public class EstateAgentGUI implements IEstateAgentGUI {

    /**
     * Calculates commission = propertyPrice * (commissionPercentage / 100).
     */
    @Override
    public double CalculateCommission(String propertyPrice, String agentCommission) {
        try {
            double price = Double.parseDouble(propertyPrice);
            double percentage = Double.parseDouble(agentCommission);
            return price * (percentage / 100.0);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }

    /**
     * Validates captured form data against rules:
     * - Agent Location cannot be empty
     * - Agent Name cannot be empty
     * - Property Price cannot be <= 0
     * - Commission Percentage cannot be <= 0
     */
    @Override
    public boolean ValidateData(Data dataToValidate) {
        if (dataToValidate == null) {
            return false;
        }

        // 1. Agent Location cannot be empty
        if (dataToValidate.getAgentLocation() == null || dataToValidate.getAgentLocation().trim().isEmpty()) {
            return false;
        }

        // 2. Agent Name cannot be empty
        if (dataToValidate.getAgentName() == null || dataToValidate.getAgentName().trim().isEmpty()) {
            return false;
        }

        // 3. Property Price must be numeric and > 0
        try {
            double price = Double.parseDouble(dataToValidate.getPropertyPrice());
            if (price <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        // 4. Commission Percentage must be numeric and > 0
        try {
            double percentage = Double.parseDouble(dataToValidate.getCommissionPercentage());
            if (percentage <= 0) {
                return false;
            }
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }
}
