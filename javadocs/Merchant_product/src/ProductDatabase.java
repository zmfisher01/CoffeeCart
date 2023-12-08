
/**
 * Name: Rashawn Hill
 * Title: CoffeeCart
 * Class: COP 4331
 */
import java.util.HashMap;
import java.util.Map;
import java.util.Collection;

public class ProductDatabase {
    private Map<String, Product> products; // Using product name as the key for simplicity

    // Constructor
    public ProductDatabase() {
        products = new HashMap<>();
    }

    // Adds a new product to the database
    public void addProduct(Product product) {
        products.put(product.getName(), product);
    }

    // Updates an existing product
    public void updateProduct(String productName, Product updatedProduct) {
        products.put(productName, updatedProduct);
    }

    // Removes a product from the database
    public void removeProduct(String productName) {
        products.remove(productName);
    }

    // Retrieves a product by name
    public Product getProduct(String productName) {
        return products.get(productName);
    }

    // Retrieves all products
    public Collection<Product> getAllProducts() {
        return products.values();
    }

    // Main method for testing
    public static void main(String[] args) {
        ProductDatabase database = new ProductDatabase();

        // Adding sample products
        database.addProduct(new Product("Coffee Mug", "A large coffee mug", 12.99, "img/mug.jpg", "MugCo"));
        database.addProduct(new Product("T-Shirt", "A plain white T-Shirt", 15.99, "img/shirt.jpg", "ShirtCo"));

        // Fetch and print all products
        for (Product product : database.getAllProducts()) {
            System.out.println(product);
        }
    }
}
