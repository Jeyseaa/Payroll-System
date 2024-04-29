import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PayrollSystemGUI extends JFrame {
    private ArrayList<Employee> employees;
    private DefaultTableModel tableModel;
    private JTextField nameField, hourlyRateField, hoursWorkedField;

    public PayrollSystemGUI() {
        // Initialize employees list
        employees = new ArrayList<>();

        // Set up the main frame
        setTitle("Payroll System");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // Create JPanel for input fields and buttons
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(10);
        inputPanel.add(nameLabel);
        inputPanel.add(nameField);

        JLabel hourlyRateLabel = new JLabel("Hourly Rate:");
        hourlyRateField = new JTextField(5);
        inputPanel.add(hourlyRateLabel);
        inputPanel.add(hourlyRateField);

        JLabel hoursWorkedLabel = new JLabel("Hours Worked:");
        hoursWorkedField = new JTextField(5);
        inputPanel.add(hoursWorkedLabel);
        inputPanel.add(hoursWorkedField);

        JButton addEmployeeButton = new JButton("Add Employee");
        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addEmployee();
            }
        });
        inputPanel.add(addEmployeeButton);

        // Create JTable for displaying employee information
        tableModel = new DefaultTableModel();
        JTable table = new JTable(tableModel);
        tableModel.addColumn("Name");
        tableModel.addColumn("Hourly Rate");
        tableModel.addColumn("Hours Worked");
        tableModel.addColumn("Salary");
        JScrollPane scrollPane = new JScrollPane(table);
        add(scrollPane, BorderLayout.CENTER);

        // Add input panel to the frame
        add(inputPanel, BorderLayout.NORTH);

        // Make the frame visible
        setVisible(true);
    }

    private void addEmployee() {
        String name = nameField.getText();
        double hourlyRate = Double.parseDouble(hourlyRateField.getText());
        int hoursWorked = Integer.parseInt(hoursWorkedField.getText());

        // Create employee object
        Employee employee = new Employee(name, hourlyRate);
        employee.addHoursWorked(hoursWorked);

        // Add employee to the list
        employees.add(employee);

        // Update table
        updateTable();
    }

    private void updateTable() {
        // Clear existing data
        tableModel.setRowCount(0);

        // Add employees to the table
        for (Employee emp : employees) {
            Object[] rowData = {emp.getName(), emp.getHourlyRate(), emp.getHoursWorked(), emp.calculateSalary()};
            tableModel.addRow(rowData);
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the event dispatch thread
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new PayrollSystemGUI();
            }
        });
    }
}
