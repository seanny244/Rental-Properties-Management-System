import java.util.Scanner;

// Comments section
// Name: Sean
// Surname: Botsheane
// Student number: 4202626
// Project name: Rental Property Marketplace

public class RentalPropertyMarketplace {

  public static void main(String[] args) {
    System.out.println("This project is a rental property marketplace.");
    System.out.println("Users can search for rental properties, book rental properties, and manage their user accounts.");

    
    Scanner scanner = new Scanner(System.in);

   
    System.out.println("Enter your name: ");
    String name = scanner.nextLine();

    System.out.println("Enter your surname: ");
    String surname = scanner.nextLine();

    System.out.println("Enter your email address: ");
    String email = scanner.nextLine();

    System.out.println("Enter your password: ");
    String password = scanner.nextLine();

    System.out.println("User registered information is as follows:");
    System.out.println("Name: " + name);
    System.out.println("Surname: " + surname);
    System.out.println("Email: " + email);
    System.out.println("Password: " + password);
  }
}
