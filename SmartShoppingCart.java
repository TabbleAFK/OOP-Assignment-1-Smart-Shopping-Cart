
public class SmartShoppingCart {

    // 1. ATTRIBUTES (all private for encapsulation)
    private String cartID;
    private String customerName;
    private String itemName;
    private int quantity;
    private double itemPrice;
    private double discountRate;
    private boolean member;

    // 2. DEFAULT CONSTRUCTOR
    public SmartShoppingCart() {
        cartID = "C001";
        customerName = "Unknown";
        itemName = "None";
        quantity = 0;
        itemPrice = 0.0;
        discountRate = 0.0;
        member = false;
    }

    // 3. PARAMETERIZED CONSTRUCTOR
    public SmartShoppingCart(String cartID, String customerName,
            String itemName, int quantity, double itemPrice,
            double discountRate, boolean member) {

        this.cartID = cartID;
        this.customerName = customerName;
        this.itemName = itemName;
        this.quantity = quantity;
        this.itemPrice = itemPrice;
        this.discountRate = discountRate;
        this.member = member;
    }

    // 4. GETTERS
    public String getCartID() {
        return cartID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getItemName() {
        return itemName;
    }
    public int getQuantity() {
        return quantity;
    }
    public double getItemPrice() {
        return itemPrice;
    }
    public double getDiscountRate() {
        return discountRate;
    }
    public boolean getMember() {
        return member;
    }

    // 5. SETTERS
    public void setCartID(String cartID) {
        this.cartID = cartID;
    }
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setQuantity(int quantity) {
        if (quantity >= 0) {
            this.quantity = quantity;
        }
    }
    public void setItemPrice(double itemPrice) {
        if (itemPrice >= 0) {
            this.itemPrice = itemPrice;
        }
    }
    public void setDiscountRate(double discountRate) {
        if (discountRate >= 0 && discountRate <= 100) {
            this.discountRate = discountRate;
        }
    }
    public void setMember(boolean member) {
        this.member = member;
    }

    // 6. ADDITIONAL METHOD 1: Calculate subtotal
    public double calculateSubtotal() {
        return quantity * itemPrice;
    }

    // 7. ADDITIONAL METHOD 2: Calculate final total
    public double calculateFinalTotal() {
        double total = calculateSubtotal();

        if (member) {
            total = total - (total * discountRate / 100);
        }

        return total;
    }

    // 8. ADDITIONAL METHOD 3: Display cart information
    public void displayCart() {
        System.out.println("\n--- Shopping Cart Details ---");
        System.out.println("Cart ID: " + cartID);
        System.out.println("Customer: " + customerName);
        System.out.println("Item: " + itemName);
        System.out.println("Quantity: " + quantity);
        System.out.printf("Item Price: RM%.2f%n", itemPrice);
        System.out.println("Member: " + member);
        System.out.printf("Subtotal: RM%.2f%n", calculateSubtotal());
        System.out.printf("Final Total: RM%.2f%n",
                calculateFinalTotal());
    }
}

