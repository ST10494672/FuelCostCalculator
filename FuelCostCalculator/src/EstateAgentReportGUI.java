import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;

/**
 * EstateAgentReportGUI.java (Question 2 Main Java Swing GUI Application)
 * Captures estate agent details, validates input, calculates commission,
 * displays the report in a JTextArea, and exports to report.txt.
 */
public class EstateAgentReportGUI extends JFrame {

    // GUI Components
    private JComboBox<String> cmbLocation;
    private JTextField txtAgentName;
    private JTextField txtPropertyPrice;
    private JTextField txtCommissionPercentage;
    private JTextArea txtReport;

    private JMenuBar menuBar;
    private JMenu menuFile;
    private JMenu menuTools;
    private JMenuItem menuItemExit;
    private JMenuItem menuItemProcessReport;
    private JMenuItem menuItemClear;
    private JMenuItem menuItemSaveReport;

    private EstateAgentGUI logic;

    public EstateAgentReportGUI() {
        logic = new EstateAgentGUI();

        // Window Setup
        setTitle("Estate Agent Report");
        setSize(420, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center on screen
        setLayout(new BorderLayout(10, 10));

        // --- MENU SYSTEM (Q.2.2) ---
        menuBar = new JMenuBar();

        // File Menu
        menuFile = new JMenu("File");
        menuItemExit = new JMenuItem("Exit");
        menuItemExit.addActionListener(e -> System.exit(0)); // Q.2.3: Exit application
        menuFile.add(menuItemExit);

        // Tools Menu
        menuTools = new JMenu("Tools");
        menuItemProcessReport = new JMenuItem("Process Report");
        menuItemClear = new JMenuItem("Clear");
        menuItemSaveReport = new JMenuItem("Save Report");

        menuItemProcessReport.addActionListener(e -> processReport());
        menuItemClear.addActionListener(e -> clearFields());
        menuItemSaveReport.addActionListener(e -> saveReportToFile());

        menuTools.add(menuItemProcessReport);
        menuTools.add(menuItemClear);
        menuTools.add(menuItemSaveReport);

        menuBar.add(menuFile);
        menuBar.add(menuTools);
        setJMenuBar(menuBar);

        // --- FORM PANEL (Q.2.1) ---
        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 10, 15));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(6, 6, 6, 6);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // 1. Agent Location Combo Box
        gbc.gridx = 0; gbc.gridy = 0;
        formPanel.add(new JLabel("AGENT LOCATION:"), gbc);

        gbc.gridx = 1;
        String[] locations = {"Cape Town", "Durban", "Pretoria"};
        cmbLocation = new JComboBox<>(locations);
        formPanel.add(cmbLocation, gbc);

        // 2. Estate Agent Name
        gbc.gridx = 0; gbc.gridy = 1;
        formPanel.add(new JLabel("ESTATE AGENT NAME:"), gbc);

        gbc.gridx = 1;
        txtAgentName = new JTextField(15);
        formPanel.add(txtAgentName, gbc);

        // 3. Property Price
        gbc.gridx = 0; gbc.gridy = 2;
        formPanel.add(new JLabel("PROPERTY PRICE:"), gbc);

        gbc.gridx = 1;
        txtPropertyPrice = new JTextField(15);
        formPanel.add(txtPropertyPrice, gbc);

        // 4. Commission Percentage
        gbc.gridx = 0; gbc.gridy = 3;
        formPanel.add(new JLabel("COMMISSION PERCENTAGE:"), gbc);

        gbc.gridx = 1;
        txtCommissionPercentage = new JTextField(15);
        formPanel.add(txtCommissionPercentage, gbc);

        add(formPanel, BorderLayout.NORTH);

        // --- REPORT DISPLAY PANEL (Q.2.1) ---
        JPanel reportPanel = new JPanel(new BorderLayout(5, 5));
        reportPanel.setBorder(BorderFactory.createEmptyBorder(0, 15, 15, 15));

        JLabel lblReportHeader = new JLabel("ESTATE AGENT REPORT:");
        reportPanel.add(lblReportHeader, BorderLayout.NORTH);

        txtReport = new JTextArea(8, 30);
        txtReport.setEditable(false); // Read-only display
        txtReport.setFont(new Font("Monospaced", Font.PLAIN, 12));
        JScrollPane scrollPane = new JScrollPane(txtReport);
        reportPanel.add(scrollPane, BorderLayout.CENTER);

        add(reportPanel, BorderLayout.CENTER);
    }

    /**
     * Q.2.4: Captures user input, validates data, calculates commission, and displays report.
     */
    private void processReport() {
        String location = (String) cmbLocation.getSelectedItem();
        String name = txtAgentName.getText().trim();
        String priceStr = txtPropertyPrice.getText().trim();
        String commStr = txtCommissionPercentage.getText().trim();

        Data inputData = new Data(location, name, priceStr, commStr);

        // Q.2.7: Validate Data
        if (!logic.ValidateData(inputData)) {
            JOptionPane.showMessageDialog(this,
                    "Validation Error: Please ensure all fields are filled, and price and percentage are numbers > 0.",
                    "Validation Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        double price = Double.parseDouble(priceStr);
        double percentage = Double.parseDouble(commStr);
        double calculatedCommission = logic.CalculateCommission(priceStr, commStr);

        // Format Report to match sample screenshot layout
        StringBuilder sb = new StringBuilder();
        sb.append("AGENT LOCATION: ").append(location).append("\n");
        sb.append("AGENT NAME: ").append(name).append("\n");
        sb.append("PROPERTY PRICE: R ").append(price).append("\n");
        sb.append("COMMISSION PERCENTAGE: ").append(percentage).append("%\n");
        sb.append("CALCULATED COMMISSION: R ").append(calculatedCommission);

        txtReport.setText(sb.toString());
    }

    /**
     * Q.2.5: Saves report content to report.txt file.
     */
    private void saveReportToFile() {
        if (txtReport.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "Please process a report first before saving!",
                    "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter("report.txt"))) {
            writer.println("ESTATE AGENT REPORT");
            writer.println("**********************************");
            writer.println(txtReport.getText());
            writer.println("**********************************");

            JOptionPane.showMessageDialog(this,
                    "Estate agent report saved to report.txt!",
                    "Report Saved", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this,
                    "Error saving report to file: " + ex.getMessage(),
                    "File Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Q.2.6: Clears input fields and report display text area.
     */
    private void clearFields() {
        cmbLocation.setSelectedIndex(0);
        txtAgentName.setText("");
        txtPropertyPrice.setText("");
        txtCommissionPercentage.setText("");
        txtReport.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new EstateAgentReportGUI().setVisible(true);
        });
    }
}
