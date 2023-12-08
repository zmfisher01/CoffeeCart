
/**
 * Name: Rashawn Hill
 * Title: CoffeeCart
 * Class: COP 4331
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductEditView extends JFrame {
    private Product product;
    private ProductDatabase database;

    // UI Components
    private JTextField nameField;
    private JTextArea descriptionArea;
    private JTextField priceField;
    private JTextField imageUrlField;
    private JTextField sellerField;
    private JButton saveButton;
    private JButton cancelButton;

    public ProductEditView(Product product, ProductDatabase database) {
        this.product = product;
        this.database = database;
        initializeComponents();
        layoutComponents();
        addEventListeners();
        populateFields();
    }

    private void initializeComponents() {
        nameField = new JTextField(20);
        descriptionArea = new JTextArea(5, 20);
        priceField = new JTextField(20);
        imageUrlField = new JTextField(20);
        sellerField = new JTextField(20);
        saveButton = new JButton("Save Changes");
        cancelButton = new JButton("Cancel");
    }

    private void layoutComponents() {
        setLayout(new BorderLayout());

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(5, 2));
        formPanel.add(new JLabel("Name:"));
        formPanel.add(nameField);
        formPanel.add(new JLabel("Description:"));
        formPanel.add(new JScrollPane(descriptionArea));
        formPanel.add(new JLabel("Price:"));
        formPanel.add(priceField);
        formPanel.add(new JLabel("Image URL:"));
        formPanel.add(imageUrlField);
        formPanel.add(new JLabel("Seller:"));
        formPanel.add(sellerField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(cancelButton);

        add(formPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);

        setTitle("Edit Product Details");
        setSize(350, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void populateFields() {
        nameField.setText(product.getName());
        descriptionArea.setText(product.getDescription());
        priceField.setText(String.valueOf(product.getPrice()));
        imageUrlField.setText(product.getImageUrl());
        sellerField.setText(product.getSeller());
    }

    private void addEventListeners() {
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                saveProduct();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ProductEditView.this.dispose();
            }
        });
    }

    private void saveProduct() {
        product.setName(nameField.getText());
        product.setDescription(descriptionArea.getText());
        product.setPrice(Double.parseDouble(priceField.getText()));
        product.setImageUrl(imageUrlField.getText());
        product.setSeller(sellerField.getText());
        database.updateProduct(product.getName(), product);
        JOptionPane.showMessageDialog(this, "Product details updated successfully.", "Success",
                JOptionPane.INFORMATION_MESSAGE);
    }

    // Main method for testing
    public static void main(String[] args) {
        Product sampleProduct = new Product("Sample Product", "This is a description", 19.99, "path/to/image.jpg",
                "Sample Seller");
        ProductDatabase database = new ProductDatabase();
        database.addProduct(sampleProduct);
        ProductEditView view = new ProductEditView(sampleProduct, database);
        view.setVisible(true);
    }
}
