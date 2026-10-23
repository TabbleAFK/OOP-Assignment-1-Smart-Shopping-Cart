
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        // 1. Create an object using the default constructor
        SmartShoppingCart defaultCart = new SmartShoppingCart();

        System.out.println("Default Cart ID: " + defaultCart.getCartID());

        // 2. Get information from the user
        System.out.println("\n=== Smart Shopping Cart ===");

        System.out.print("Enter cart ID: ");
        String cartID = input.nextLine();

        System.out.print("Enter customer name: ");
        String customerName = input.nextLine();

        System.out.print("Enter item name: ");
        String itemName = input.nextLine();

        System.out.print("Enter quantity: ");
        int quantity = input.nextInt();

        System.out.print("Enter item price: RM");
        double itemPrice = input.nextDouble();

        System.out.print("Enter discount rate (%): ");
        double discountRate = input.nextDouble();

        System.out.print("Is the customer a member? (true/false): ");
        boolean member = input.nextBoolean();

        // 3. Create an object using the parameterized constructor
        SmartShoppingCart cart = new SmartShoppingCart(
                cartID, customerName, itemName, quantity,
                itemPrice, discountRate, member);

        // 4. Selection structure: if statement
        if (cart.getMember()) {
            System.out.println("Member discount is available.");
        } else {
            System.out.println("No member discount is available.");
        }

        // 5. Looping structure: while loop
        int choice = 0;

        while (choice != 4) {

            System.out.println("\n=== Shopping Cart Menu ===");
            System.out.println("1. Display Cart");
            System.out.println("2. Update Quantity");
            System.out.println("3. Calculate Final Total");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            choice = input.nextInt();

            // 6. Selection structure: switch statement
            switch (choice) {

                case 1:
                    cart.displayCart();
                    break;

                case 2:
                    System.out.print("Enter new quantity: ");
                    int newQuantity = input.nextInt();

                    // Use setter to modify an attribute
                    if (newQuantity >= 0) {
                        cart.setQuantity(newQuantity);
                        System.out.println("Quantity updated.");
                    } else {
                        System.out.println("Invalid quantity.");
                    }
                    break;

                case 3:
                    // Use getter and calculation method
                    System.out.println("Item: " + cart.getItemName());

                    System.out.printf("Final Total: RM%.2f%n",
                            cart.calculateFinalTotal());
                    break;

                case 4:
                    System.out.println("Thank you for shopping!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }

        input.close();
    }
}

