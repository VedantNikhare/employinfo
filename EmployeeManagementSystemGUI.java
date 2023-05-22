import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class EmployeeManagementSystemGUI extends JFrame implements ActionListener {

    // Define UI components
    private JTextField nameTextField, idTextField, departmentTextField, salaryTextField;
    private JButton addButton, viewButton, clearButton, exitButton;
    private JTextArea employeeTextArea;
    // Constructor
    public EmployeeManagementSystemGUI() {
        super("Employee Management System");

        // Set layout
        setLayout(new BorderLayout());

        // Create panels
        JPanel inputPanel = new JPanel(new GridLayout(4, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JPanel outputPanel = new JPanel(new BorderLayout());

        // Create input fields
        JLabel nameLabel = new JLabel("Name: ");
        nameTextField = new JTextField(10);
        inputPanel.add(nameLabel);
        inputPanel.add(nameTextField);

        JLabel idLabel = new JLabel("ID: ");
        idTextField = new JTextField(10);
        inputPanel.add(idLabel);
        inputPanel.add(idTextField);

        JLabel departmentLabel = new JLabel("Department: ");
        departmentTextField = new JTextField(10);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentTextField);

        JLabel salaryLabel = new JLabel("Salary: ");
        salaryTextField = new JTextField(10);
        inputPanel.add(salaryLabel);
        inputPanel.add(salaryTextField);

        // Create buttons
        addButton = new JButton("Add Employee");
        addButton.addActionListener(this);
        buttonPanel.add(addButton);

        viewButton = new JButton("View Employees");
        viewButton.addActionListener(this);
        buttonPanel.add(viewButton);

        clearButton = new JButton("Clear");
        clearButton.addActionListener(this);
        buttonPanel.add(clearButton);

        exitButton = new JButton("Exit");
        exitButton.addActionListener(this);
        buttonPanel.add(exitButton);

        // Create text area
        employeeTextArea = new JTextArea(10, 30);
        employeeTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(employeeTextArea);
        outputPanel.add(scrollPane);

        // Add components to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER);
        add(outputPanel, BorderLayout.SOUTH);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            addEmployee();
        } else if (e.getSource() == viewButton) {
            viewEmployees();
        } else if (e.getSource() == clearButton) {
            clearFields();
        } else if (e.getSource() == exitButton) {
            System.exit(0);
        }
    }

    // Add a new employee to the system
    private void addEmployee() {
        String name = nameTextField.getText();
        String id = idTextField.getText();
        String department = departmentTextField.getText();
        String salary = salaryTextField.getText();

        // Validate input
        if (name.equals("") || id.equals("") || department.equals("") || salary.equals("")) {
            JOptionPane.showMessageDialog(this, "Please enter all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Add employee to text area
        employeeTextArea.append("Name: " + name + "\n");
        employeeTextArea.append("ID: " + id + "\n");
        employeeTextArea.append("Department: " + department + "\n");
        employeeTextArea.append("Salary: " + salary + "\n\n");

        // Clear input fields

        clearFields();
    }

    // View all employees in the system
    private void viewEmployees() {
        String employees = employeeTextArea.getText();

        // Check if there are any employees
        if (employees.equals("")) {
            JOptionPane.showMessageDialog(this, "There are no employees to display", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Display employees in a message dialog
        JOptionPane.showMessageDialog(this, employees, "Employees", JOptionPane.PLAIN_MESSAGE);
    }

    // Clear input fields
    private void clearFields() {
        nameTextField.setText("");
        idTextField.setText("");
        departmentTextField.setText("");
        salaryTextField.setText("");
    }

    // Main method to start the program
    public static void main(String[] args) {
        new EmployeeManagementSystemGUI();
    }
}