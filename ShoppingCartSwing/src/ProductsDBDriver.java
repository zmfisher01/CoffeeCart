import java.io.*;
import java.util.ArrayList;
import java.util.List;
import models.Product;

public class ProductsDBDriver {

  private final String DATABASE_FILE = "./db/products.txt";
  private final String INTERPUNCT = "·";

  private List<Product> products;

  // Create operation
  public void addProduct(
    String itemName,
    String pictureUrl,
    double price,
    String seller,
    String description
  ) {
    int id = getNextId();
    products.add(
      new Product(id, itemName, pictureUrl, price, seller, description)
    );
  }

  public List<Product> getProductsBySeller(String sellerName) {
    try (
      BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))
    ) {
      String line;
      while ((line = reader.readLine()) != null) {
        Product product = new Product(line);
        if (product.getSeller().equals(sellerName)) {
          products.add(product);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return products;
  }

  public List<Product> getAllProducts() {
    try (
      BufferedReader reader = new BufferedReader(new FileReader(DATABASE_FILE))
    ) {
      String line;
      while ((line = reader.readLine()) != null) {
        products.add(new Product(line));
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
    return products;
  }

  public void updateProduct(
    int productId,
    String itemName,
    String pictureUrl,
    double price,
    String seller,
    String description
  ) {
    List<Product> products = getAllProducts();

    for (Product product : products) {
      if (product.getId() == productId) {
        product.setProductName(itemName);
        product.setPictureUrl(pictureUrl);
        product.setPrice(price);
        product.setSeller(seller);
        product.setDescription(description);

        products.set(products.indexOf(product), product);
        writeAllProducts(products);

        break;
      }
    }
  }

  public void deleteProduct(int productId) {
    for (Product product : products) {
      if (product.getId() == productId) {
        products.remove(product);
        writeAllProducts(products);
        break;
      }
    }
  }

  private int getNextId() {
    return products.get(products.size() - 1).getId() + 1;
  }

  private void writeAllProducts(List<Product> products) {
    try (
      BufferedWriter writer = new BufferedWriter(new FileWriter(DATABASE_FILE))
    ) {
      for (Product product : products) {
        writer.write(product.toSavableString());
        writer.newLine();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
