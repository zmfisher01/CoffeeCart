package models;

public class Product {

  private final String INTERPUNCT = "·";
  private int id;
  private String productName;
  private String pictureUrl;
  private double price;
  private String seller;
  private String description;

  public Product(String details) {
    decipherSentence(details);
  }

  public Product(
    int id,
    String productName,
    String pictureUrl,
    double price,
    String seller,
    String description
  ) {
    this.id = id;
    this.productName = productName;
    this.pictureUrl = pictureUrl;
    this.price = price;
    this.seller = seller;
    this.description = description;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public String getPictureUrl() {
    return pictureUrl;
  }

  public void setPictureUrl(String pictureUrl) {
    this.pictureUrl = pictureUrl;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public String getSeller() {
    return seller;
  }

  public void setSeller(String seller) {
    this.seller = seller;
  }

  // Getters and setters (omitted for brevity)

  @Override
  public String toString() {
    return (
      "Product{" +
      "productName='" +
      productName +
      '\'' +
      ", pictureUrl='" +
      pictureUrl +
      '\'' +
      ", price=" +
      price +
      ", seller='" +
      seller +
      '\'' +
      ", description='" +
      description +
      '\'' +
      '}'
    );
  }

  public Product decipherSentence(String sentence) {
    String[] parts = sentence.split("·");

    // Check if the sentence has the expected number of parts
    if (parts.length == 6) {
      try {
        this.id = Integer.parseInt(parts[0]);
        this.productName = parts[1];
        this.pictureUrl = parts[2];
        this.price = Double.parseDouble(parts[3]);
        this.seller = parts[4];
        this.description = parts[5];

        // Create and return a new Product object
        return new Product(
          id,
          productName,
          pictureUrl,
          price,
          seller,
          description
        );
      } catch (NumberFormatException e) {
        System.err.println("Error parsing numeric values in the sentence.");
      }
    } else {
      System.err.println("Invalid number of parts in the sentence.");
    }

    // Return null if the sentence couldn't be deciphered
    return null;
  }

  public String toSavableString() {
    return (
      id +
      INTERPUNCT +
      productName +
      INTERPUNCT +
      pictureUrl +
      INTERPUNCT +
      price +
      INTERPUNCT +
      seller +
      INTERPUNCT +
      description
    );
  }

  public void setDescription(String newDescription) {}
}
