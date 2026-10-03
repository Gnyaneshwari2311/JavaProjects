public class Product {

    private final int productId;
    private final String productName;
    private final Category category;

    private double price;
    private int stock;

    public Product(int productId, String productName,
                   Category category, double price, int stock) {

        this.productId = productId;
        this.productName = productName;
        this.category = category;

        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Price must be greater than zero");
        }

        if (stock < 0) {
            throw new IllegalArgumentException(
                    "Stock cannot be negative");
        }

        this.price = price;
        this.stock = stock;
    }

    public int getProductId() {

        return productId;
    }

    public String getProductName() {

        return productName;
    }

    public Category getCategory() {

        return category;
    }

    public double getPrice() {

        return price;
    }

    public int getStock() {

        return stock;
    }

    public void setPrice(double price) {

        if (price <= 0) {
            throw new IllegalArgumentException(
                    "Price must be greater than zero");
        }

        this.price = price;
    }

    public void addStock(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero");
        }

        stock = stock + quantity;
    }

    public void sellProduct(int quantity) {

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "Quantity must be greater than zero");
        }

        if (stock == 0) {
            throw new IllegalArgumentException(
                    "Product is out of stock");
        }

        if (quantity > stock) {
            throw new IllegalArgumentException(
                    "Not enough stock available");
        }

        stock = stock - quantity;
    }

    @Override
    public String toString() {

        return "Product ID: " + productId
                + ", Name: " + productName
                + ", Category: " + category
                + ", Price: " + price
                + ", Stock: " + stock;
    }
}