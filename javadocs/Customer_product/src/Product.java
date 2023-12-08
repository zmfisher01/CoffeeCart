/**
 * Name: Rashawn Hill
 * Title: CoffeeCart
 * Class: COP 4331
 */
public class Product {
    // Attributes of a product
    private String name;
    private String description;
    private double price;
    private String imageUrl; // URL or path to the image
    private String seller;

    // Constructor
    public Product(String name, String description, double price, String imageUrl, String seller) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.imageUrl = imageUrl;
        this.seller = seller;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    // toString method for displaying product details
    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", imageUrl='" + imageUrl + '\'' +
                ", seller='" + seller + '\'' +
                '}';
    }
}
