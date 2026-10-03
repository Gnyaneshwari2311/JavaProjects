public class Main {

    public static void main(String[] args) {

        InventoryService service = new InventoryService();

        Product laptop = new Product(
                101,
                "Dell Laptop",
                Category.LAPTOP,
                55000,
                10
        );

        service.addProduct(laptop);

        service.showAllProducts();
    }
}
