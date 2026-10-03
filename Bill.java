public class Bill {

    public double calculateTotal(Product product, int quantity) {

        if (quantity <= 0) {

            throw new IllegalArgumentException(
                    "Quantity must be greater than zero");
        }

        double total;

        total = product.getPrice() * quantity;

        return total;
    }
}