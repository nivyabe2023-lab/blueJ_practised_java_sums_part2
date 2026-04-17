import java.util.ArrayList;
import java.util.Scanner;

class Product {
    // Made these private to follow encapsulation best practices
    private int id;
    private String name;
    private double price;

    public Product(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    // Added getters since variables are now private and not directly accessible
    public String getName() { return name; }
    public double getPrice() { return price; }
    public int getId() { return id; }
}

class CartItem {
    private Product product;
    private int quantity; // Moved quantity here because it belongs to the selection, not the product itself

    public CartItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public double getSubtotal() {
        // Fetching price via getter from the Product object
        return product.getPrice() * quantity;
    }

    public void display() {
        // Used printf for better alignment and to keep decimals to 2 places
        System.out.printf("ID: %d | %-15s | Qty: %d | Subtotal: %.2f%n", 
            product.getId(), product.getName(), quantity, getSubtotal());
    }
}

class Cart {
    // Marked as final to ensure the list reference doesn't change
    private final ArrayList<CartItem> items = new ArrayList<>();

    public void addItem(Product p, int qty) {
        items.add(new CartItem(p, qty));
    }

    public void displayCart() {
        System.out.println("\n--- Your Shopping Cart ---");
        for (CartItem item : items) {
            item.display();
        }
    }

    public double calculateTotal() {
        // Using Stream API to sum up subtotals; much cleaner than a manual loop
        return items.stream().mapToDouble(CartItem::getSubtotal).sum();
    }

    public double applyDiscount(double total, double percentage) {
        // Changed to take a percentage parameter so it's not stuck at 10%
        return total * (1 - (percentage / 100));
    }
}
