import java.util.HashMap;
import java.util.Map;

public class InventoryService {

    private final Map<Integer, Product> products;

    public InventoryService() {

        products = new HashMap<>();
    }

    public void addProduct(Product product) {

        if (products.containsKey(product.getProductId())) {

            throw new IllegalArgumentException(
                    "Product ID already exists");
        }

        products.put(product.getProductId(), product);

        System.out.println("Product added successfully");
    }

    public void searchProduct(int productId) {

        Product product = products.get(productId);

        if (product == null) {

            System.out.println("Product not found");

        } else {

            System.out.println(product);
        }
    }

    public void updatePrice(int productId, double newPrice) {

        Product product = products.get(productId);

        if (product == null) {

            System.out.println("Product not found");
            return;
        }

        try {

            product.setPrice(newPrice);

            System.out.println("Price updated successfully");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }

    public void addStock(int productId, int quantity) {

        Product product = products.get(productId);

        if (product == null) {

            System.out.println("Product not found");
            return;
        }

        try {

            product.addStock(quantity);

            System.out.println("Stock added successfully");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }

    public void sellProduct(int productId, int quantity) {

        Product product = products.get(productId);

        if (product == null) {

            System.out.println("Product not found");
            return;
        }

        try {

            product.sellProduct(quantity);

            System.out.println("Product sold successfully");

        } catch (IllegalArgumentException e) {

            System.out.println(e.getMessage());
        }
    }

    public void showAllProducts() {

        if (products.isEmpty()) {

            System.out.println("No products available");
            return;
        }

        for (Product product : products.values()) {

            System.out.println(product);
        }
    }

    public void showLowStockProducts() {

        boolean found = false;

        for (Product product : products.values()) {

            if (product.getStock() < 5) {

                System.out.println(product);

                found = true;
            }
        }

        if (!found) {

            System.out.println(
                    "No products have stock below 5");
        }
    }

    public void deleteProduct(int productId) {

        Product product = products.remove(productId);

        if (product == null) {

            System.out.println("Product not found");

        } else {

            System.out.println(
                    "Product deleted successfully");
        }
    }
}