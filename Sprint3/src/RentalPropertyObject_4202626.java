
import java.util.Scanner;

public class RentalPropertyObject_4202626 {

    private String address;
    private int numberOfBedrooms;
    private int numberOfBathrooms;
    private double rentPrice;
    private boolean isAvailable;

    public RentalPropertyObject_4202626(String address, int numberOfBedrooms, int numberOfBathrooms, double rentPrice, boolean isAvailable) {
        this.address = address;
        this.numberOfBedrooms = numberOfBedrooms;
        this.numberOfBathrooms = numberOfBathrooms;
        this.rentPrice = rentPrice;
        this.isAvailable = isAvailable;
    }

    public void rentalPropertyInfo() {
        System.out.println("Address: " + address);
        System.out.println("Number of bedrooms: " + numberOfBedrooms);
        System.out.println("Number of bathrooms: " + numberOfBathrooms);
        System.out.println("Rent price: " + rentPrice);
        System.out.println("Is available: " + isAvailable);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter address: ");
            String address = scanner.nextLine();

            System.out.print("Enter number of bedrooms: ");
            int numberOfBedrooms = scanner.nextInt();

            System.out.print("Enter number of bathrooms: ");
            int numberOfBathrooms = scanner.nextInt();

            System.out.print("Enter rent price: ");
            double rentPrice = scanner.nextDouble();

            System.out.print("Is available (true/false): ");
            boolean isAvailable = scanner.nextBoolean();

            RentalPropertyObject_4202626 property = new RentalPropertyObject_4202626(address, numberOfBedrooms, numberOfBathrooms, rentPrice, isAvailable);
            property.rentalPropertyInfo();

            System.out.print("Do you want to enter another property (yes/no)? ");
            String continueInput = scanner.next();
            if (!continueInput.equalsIgnoreCase("yes")) {
                break; 
            }
            scanner.nextLine();
        }
        
        scanner.close();
    }
}