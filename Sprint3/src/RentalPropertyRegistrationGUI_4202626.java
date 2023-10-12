
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RentalPropertyRegistrationGUI_4202626 extends JFrame {

    private JTextField nameTextField;
    private JTextField emailTextField;
    private JTextField phoneNumberTextField;
    private JTextField addressTextField;
    private JButton submitButton;
    private JLabel logoLabel;
    private JLabel loginLabel;

    private List<String> userRegistrations = new ArrayList<>(); // Store user registrations

    public RentalPropertyRegistrationGUI_4202626() {
        super("RentAPlace Registration");
        this.setSize(400, 400); 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Create the logo label and set its properties
        logoLabel = new JLabel("RentAPlace");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        logoLabel.setHorizontalAlignment(JLabel.CENTER);
        logoLabel.setVerticalAlignment(JLabel.CENTER);
        logoLabel.setOpaque(true);
        logoLabel.setBackground(new Color(52, 152, 219)); // Customize the background color
        logoLabel.setForeground(Color.WHITE);

        // Create the login label
        loginLabel = new JLabel("Login or Create an Account");
        loginLabel.setFont(new Font("Arial", Font.BOLD, 18));
        loginLabel.setHorizontalAlignment(JLabel.CENTER);

        // Create the main panel
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Add the name label and text field
        addLabelAndTextField(mainPanel, gbc, "Name:", nameTextField = new JTextField(20));

        // Add the email label and text field
        addLabelAndTextField(mainPanel, gbc, "Email address:", emailTextField = new JTextField(20));

        // Add the phone number label and text field
        addLabelAndTextField(mainPanel, gbc, "Phone number:", phoneNumberTextField = new JTextField(20));

        // Add the address label and text field
        addLabelAndTextField(mainPanel, gbc, "Address:", addressTextField = new JTextField(20));

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

        // Add components to the main panel
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        mainPanel.add(submitPanel, gbc);

        // Set background colors for the main panel
        mainPanel.setBackground(Color.WHITE); // You can customize the background color

        // Add the logo label to the content pane at the top
        this.add(logoLabel, BorderLayout.NORTH);

        // Create a subpanel for the login label and main panel
        JPanel subPanel = new JPanel(new BorderLayout());

        // Set the background color of the subpanel
        subPanel.setBackground(Color.WHITE); // You can customize the background color

        // Add the login label to the subpanel at the top
        subPanel.add(loginLabel, BorderLayout.NORTH);

        // Add the main panel to the subpanel at the center
        subPanel.add(mainPanel, BorderLayout.CENTER);

        // Add the subpanel to the content pane
        this.add(subPanel, BorderLayout.CENTER);

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
        String name = nameTextField.getText().trim();
        String emailAddress = emailTextField.getText().trim();
        String phoneNumber = phoneNumberTextField.getText().trim();
        String address = addressTextField.getText().trim();

        // Check if all of the fields are complete
        if (name.isEmpty() || emailAddress.isEmpty() || phoneNumber.isEmpty() || address.isEmpty()) {
            // Display an error message
            JOptionPane.showMessageDialog(this, "Please fill out all of the required fields.");
            return;
        }

        // Store the user's registration information
        String registrationInfo = name + "," + emailAddress + "," + phoneNumber + "," + address;
        userRegistrations.add(registrationInfo);

        // Sort the registrations
        Collections.sort(userRegistrations);

        // Write the sorted user registrations to a text file
        try {
            FileWriter writer = new FileWriter("user_registrations.txt");
            for (String registration : userRegistrations) {
                writer.write(registration + System.lineSeparator());
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Display a success message
        JOptionPane.showMessageDialog(this, "You have been successfully registered for a RentAPlace account!");

        // Clear the text fields
        nameTextField.setText("");
        emailTextField.setText("");
        phoneNumberTextField.setText("");
        addressTextField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RentalPropertyRegistrationGUI_4202626());
    }
}
