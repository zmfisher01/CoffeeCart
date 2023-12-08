package customer;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.*;
import models.Product;

public class ProductListPage extends JFrame {

  private JPanel productListPanel;

  public ProductListPage(List<Product> products) {
    setTitle("Product List Page");
    setSize(800, 600);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JToolBar toolBar = new JToolBar("Still draggable");

    toolBar = new JToolBar();
    JButton viewCartButton = new JButton("View Cart");
    viewCartButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // CartPage cartPage = new CartPage();
          // cartPage.setVisible(true);
        }
      }
    );
    toolBar.add(viewCartButton);

    // Create a panel with GridLayout
    productListPanel = new JPanel(new GridLayout(0, 3, 10, 10)); // 3 columns, 10 pixels horizontal and vertical gap
    addProductsToPanel(products);

    // Add the panel to the frame
    JScrollPane scrollPane = new JScrollPane(productListPanel);
    add(scrollPane);

    setVisible(true);
  }

  private void addProductsToPanel(List<Product> products) {
    for (Product product : products) {
      JPanel productCard = createProductCard(product);
      productListPanel.add(productCard);
    }
  }

  private JPanel createProductCard(Product product) {
    JPanel card = new JPanel();
    card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));

    JLabel nameLabel = new JLabel(product.getProductName());
    JLabel priceLabel = new JLabel("Price: $" + product.getPrice());
    JLabel sellerLabel = new JLabel("Seller: " + product.getSeller());

    JButton addToCartButton = new JButton("Add to Cart");
    addToCartButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Perform add to cart action
          // addToCart(product);
        }
      }
    );

    JButton viewButton = new JButton("View");
    viewButton.addActionListener(
      new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
          // Perform view action
          // viewProduct(product);
        }
      }
    );
    card.add(new JLabel(new ImageIcon(product.getPictureUrl())));
    card.add(nameLabel);
    card.add(priceLabel);
    card.add(sellerLabel);
    card.add(addToCartButton);
    card.add(viewButton);

    return card;
  }

  public static void main(String[] args) {
    List<Product> productList = List.of(
      new Product(
        1,
        "Laptop",
        "https://picsum.photos/200/300",
        999.99,
        "John Doe",
        "High-performance laptop with SSD."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      ),
      new Product(
        2,
        "Smartphone",
        "https://picsum.photos/200/300",
        499.99,
        "Jane Smith",
        "5G smartphone with dual cameras."
      )
    );

    SwingUtilities.invokeLater(() -> new ProductListPage(productList));
  }
}
