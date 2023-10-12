import javax.swing.*;
import java.awt.*;

public class WelcomeScreenGUI extends JPanel {

    public WelcomeScreenGUI() {
        // Create the RentAPlace logo
        JLabel logoLabel = new JLabel("                                                 RentAPlace");
        logoLabel.setFont(new Font("Arial", Font.BOLD, 48));

        // Create the text 
        JLabel textLabel = new JLabel("The best move that you'll ever make");
        textLabel.setFont(new Font("Arial", Font.PLAIN, 24));

        // Create the VIEW PROPERTY LISTINGS button
        JButton viewPropertyListingsButton = new JButton("VIEW PROPERTY LISTINGS");
        viewPropertyListingsButton.setFont(new Font("Arial", Font.PLAIN, 18));
        viewPropertyListingsButton.setPreferredSize(new Dimension(150, 50)); // Make the button smaller

        // Create the centered paragraph
        String paragraphText = "<html><center>We have more real estate listings than any other in this town.<br> We know that biggest and best are the same thing.<br> Look no further than RentAPlace.<br> Don't think of us as youtr realtor, think of us as your friend.<br> View NOW!</center></html>";
        JLabel paragraphLabel = new JLabel(paragraphText);
        paragraphLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        // Add all of the components to the panel
        setLayout(new BorderLayout());
        add(logoLabel, BorderLayout.NORTH);
        add(textLabel, BorderLayout.CENTER);
        add(viewPropertyListingsButton, BorderLayout.SOUTH);
        add(paragraphLabel, BorderLayout.EAST);
    }

    public static void main(String[] args) {
        // Create a new instance of the WelcomeScreen class
        WelcomeScreenGUI welcomeScreen = new WelcomeScreenGUI();

        // Create a new JFrame object and add the WelcomeScreen object to it
        JFrame frame = new JFrame();
        frame.add(welcomeScreen);

        // Set the size of the JFrame object and make it visible
        frame.setSize(1000, 800); // Make the window bigger
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Put the window in big windowed mode
        frame.setVisible(true);
    }
}
