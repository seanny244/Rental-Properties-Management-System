
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseConnection extends JFrame {

    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phoneNumberTextField;
    private JTextField addressTextField;
    private JButton submitButton;

    private Connection connection;

    public DatabaseConnection() {
        super("Rental Property Registration");

        // Connect to the MySQL database
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/myRentalProperty", "root", "Larxa244@2002");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add the name label and text field
        addLabelAndTextField(panel, gbc, "Name:", nameTextField = new JTextField(20));

        // Add the email label and text field
        addLabelAndTextField(panel, gbc, "Email address:", emailTextField = new JTextField(20));

        // Add the phone number label and text field
        addLabelAndTextField(panel, gbc, "Phone number:", phoneNumberTextField = new JTextField(20));

        // Add the address label and text field
        addLabelAndTextField(panel, gbc, "Address:", addressTextField = new JTextField(20));

        // Add the submit button centered in a separate panel
        JPanel submitPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmission();
            }
        });
        submitPanel.add(submitButton);

        // Add the components to the main panel
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(submitPanel, gbc);

        this.add(panel);
        this.setSize(400, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    private void addLabelAndTextField(JPanel panel, GridBagConstraints gbc, String labelText, JTextField textField) {
        JLabel label = new JLabel(labelText);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 1;
        panel.add(label, gbc);

        gbc.gridx = 1;
        panel.add(textField, gbc);
    }

    private void handleSubmission() {
        // Get the user's registration information
        String name = nameTextField.getText();
        String emailAddress = emailTextField.getText();
        String phoneNumber = phoneNumberTextField.getText();
        String address = addressTextField.getText();

        // Check if all of the fields are complete
        if (name.isEmpty() || emailAddress.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
            // Display an error message
            JOptionPane.showMessageDialog(this, "Please fill out all of the required fields.");
        } else {
            try {
                // Create a statement to insert the user's registration information into the database
                PreparedStatement statement = connection.prepareStatement("INSERT INTO users (name, email_address, phone_number, address) VALUES (?, ?, ?, ?)");
                statement.setString(1, name);
                statement.setString(2, emailAddress);
                statement.setString(3, phoneNumber);
                statement.setString(4, address);

                // Execute the statement
                statement.executeUpdate();

                // Close the statement
                statement.close();

                // Display a success message
                JOptionPane.showMessageDialog(this, "You have been successfully registered for a Rental Property Marketplace account!");

                // Clear the text fields
                nameTextField.setText("");
                emailTextField.setText("");
                phoneNumberTextField.setText("");
                addressTextField.setText("");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new DatabaseConnection());
    }
}
