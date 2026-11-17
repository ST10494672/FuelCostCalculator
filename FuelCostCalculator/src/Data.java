/**
 * Data.java (Question 2 Data Model Class)
 * Stores input values captured from the GUI form for validation and processing.
 */
public class Data {
    private String agentLocation;
    private String agentName;
    private String propertyPrice;
    private String commissionPercentage;

    public Data(String agentLocation, String agentName, String propertyPrice, String commissionPercentage) {
        this.agentLocation = agentLocation;
        this.agentName = agentName;
        this.propertyPrice = propertyPrice;
        this.commissionPercentage = commissionPercentage;
    }

    public String getAgentLocation() { return agentLocation; }
    public void setAgentLocation(String agentLocation) { this.agentLocation = agentLocation; }

    public String getAgentName() { return agentName; }
    public void setAgentName(String agentName) { this.agentName = agentName; }

    public String getPropertyPrice() { return propertyPrice; }
    public void setPropertyPrice(String propertyPrice) { this.propertyPrice = propertyPrice; }

    public String getCommissionPercentage() { return commissionPercentage; }
    public void setCommissionPercentage(String commissionPercentage) { this.commissionPercentage = commissionPercentage; }
}
