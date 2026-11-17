import java.text.DecimalFormat;

/**
 * EstateAgentSalesReport.java (Question 1 Main Application Driver)
 * Demonstrates 2D array usage to store quarterly property sales for 2 estate agents,
 * displays total sales, 2% commission, and top-selling agent.
 */
public class EstateAgentSalesReport {

    public static void main(String[] args) {
        String[] agents = {"Joe Bloggs", "Jane Doe"};
        String[] months = {"JAN", "FEB", "MAR"};

        // 2D Array: 2 Agents x 3 Months
        double[][] propertySales = {
            {800000.0, 1500000.0, 2000000.0}, // Joe Bloggs: Jan, Feb, Mar
            {700000.0, 1200000.0, 1600000.0}  // Jane Doe: Jan, Feb, Mar
        };

        EstateAgent agentLogic = new EstateAgent();
        double[] totalSales = new double[agents.length];
        double[] commissions = new double[agents.length];

        // Calculate sales and commission for each agent
        for (int i = 0; i < agents.length; i++) {
            totalSales[i] = agentLogic.EstateAgentSales(propertySales[i]);
            commissions[i] = agentLogic.EstateAgentCommission(totalSales[i]);
        }

        // Determine top performing agent
        int topIndex = agentLogic.TopEstateAgent(totalSales);

        // Decimal formatting
        DecimalFormat currencyFormatter = new DecimalFormat("R #,##0");

        // Display Header
        System.out.println("ESTATE AGENTS SALES REPORT\n");
        System.out.printf("%-20s %-18s %-18s %-18s\n", "", months[0], months[1], months[2]);
        System.out.println("----------------------------------------------------------------------------------");

        // Display monthly sales matrix
        for (int i = 0; i < agents.length; i++) {
            System.out.printf("%-20s R %-16.1f R %-16.1f R %-16.1f\n",
                    agents[i],
                    propertySales[i][0],
                    propertySales[i][1],
                    propertySales[i][2]);
        }

        System.out.println();
        // Display total sales per agent
        for (int i = 0; i < agents.length; i++) {
            System.out.println("Total property sales for " + agents[i] + " = " + currencyFormatter.format(totalSales[i]));
        }

        System.out.println();
        // Display commission per agent
        for (int i = 0; i < agents.length; i++) {
            System.out.println("Sales Commission for " + agents[i] + " = " + currencyFormatter.format(commissions[i]));
        }

        System.out.println();
        // Display top performing agent
        System.out.println("Top performing estate agent: " + agents[topIndex]);
    }
}
