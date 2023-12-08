
/**
 * Name: Rashawn Hill
 * Title: CoffeeCart
 * Class: COP 4331
 */
import java.util.ArrayList;
import java.util.List;

public class Cart {
    // List of products in the cart
    private List<Product> products;

    // Constructor
    public Cart() {
        products = new ArrayList<>();
    }

    // Adds a product to the cart
    public void addProduct(Product product) {
        products.add(product);
    }

    // Removes a product from the cart
    public void removeProduct(Product product) {
        products.remove(product);
    }

    // Get the list of products in the cart
    public List<Product> getProducts() {
        return products;
    }

    // Clears all products from the cart
    public void clearCart() {
        products.clear();
    }

    // Returns the total price of all products in the cart
    public double getTotalPrice() {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice();
        }
        return total;
    }

    // Returns the number of items in the cart
    public int getItemCount() {
        return products.size();
    }

    // toString method for displaying cart contents
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Cart Contents:\n");
        for (Product product : products) {
            sb.append(product.toString()).append("\n");
        }
        sb.append("Total Price: ").append(getTotalPrice());
        return sb.toString();
    }
}
