
/**
 * Name: Rashawn Hill
 * Title: CoffeeCart
 * Class: COP 4331
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductDetailsView extends JFrame {
    private Product product;
    private Cart cart;

    // UI Components
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JTextArea descriptionArea;
    private JLabel imageLabel;
    private JButton addToCartButton;

    public ProductDetailsView(Product product, Cart cart) {
        this.product = product;
        this.cart = cart;
        initializeComponents();
        layoutComponents();
        addEventListeners();
    }

    private void initializeComponents() {
        nameLabel = new JLabel(product.getName());
        priceLabel = new JLabel("Price: $" + product.getPrice());
        descriptionArea = new JTextArea(product.getDescription());
        descriptionArea.setEditable(false);
        imageLabel = new JLabel(new ImageIcon(product.getImageUrl())); // Adjust as needed for image handling
        addToCartButton = new JButton("Add to Cart");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());
        add(nameLabel, BorderLayout.NORTH);
        add(imageLabel, BorderLayout.CENTER);
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.add(descriptionArea, BorderLayout.CENTER);
        bottomPanel.add(priceLabel, BorderLayout.SOUTH);
        add(bottomPanel, BorderLayout.SOUTH);
        add(addToCartButton, BorderLayout.AFTER_LAST_LINE);

        setTitle("Product Details");
        setSize(300, 400); // Adjust size as needed
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void addEventListeners() {
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cart.addProduct(product);
                JOptionPane.showMessageDialog(ProductDetailsView.this,
                        product.getName() + " added to cart!",
                        "Product Added",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });
    }

    // Main method for testing
    public static void main(String[] args) {
        Product sampleProduct = new Product("Sample Product", "This is a description", 19.99, "path/to/image.jpg",
                "Sample Seller");
        Cart sampleCart = new Cart();
        ProductDetailsView view = new ProductDetailsView(sampleProduct, sampleCart);
        view.setVisible(true);
    }
}
