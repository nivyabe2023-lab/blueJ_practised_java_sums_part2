import java.util.Scanner;
import java.util.ArrayList;

class Product {
    public int product_id;
    public String product_name;
    public double product_price;
    public int product_quantity;

    public Product(int product_id, String product_name, double product_price, int product_quantity) {
        this.product_id = product_id;
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_quantity = product_quantity;
    }

    void display() {
        System.out.println("Product ID: " + this.product_id);
        System.out.println("Product Name: " + this.product_name);
        System.out.println("Product Price: " + this.product_price);
        System.out.println("Product Quantity: " + this.product_quantity);
    }
}

class CartItem {
    public Product p;

    public CartItem(Product p) {
        this.p = p;
    }

    double getTotal() {
        return p.product_price * p.product_quantity;
    }
}

class Cart {
    ArrayList<CartItem> items = new ArrayList<>();

    void addItem(Product p) {
        items.add(new CartItem(p));
    }

    void displayCart() {
        System.out.println("\n--- Cart Items ---");
        for (CartItem item : items) {
            item.p.display();
            System.out.println("Item Total: " + item.getTotal());
        }
    }

    double calculateTotal() {
        double total = 0;
        for (CartItem item : items) {
            total += item.getTotal();
        }
        return total;
    }

    double applyDiscount(double total) {
        return total * 0.9;
    }
}

public class ShoppingSystem {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter product details:");
        
        System.out.print("Product ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Product Name: ");
        String name = sc.nextLine();

        System.out.print("Product Price: ");
        double price = sc.nextDouble();

        System.out.print("Quantity: ");
        int qty = sc.nextInt();

        Product p1 = new Product(id, name, price, qty);

        Cart cart = new Cart();
        cart.addItem(p1);

        cart.displayCart();
        
        double total = cart.calculateTotal();
        System.out.println("\nTotal before discount: " + total);

        double finalAmount = cart.applyDiscount(total);
        System.out.println("Final after discount: " + finalAmount);
    }
}