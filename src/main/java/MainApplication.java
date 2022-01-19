public class MainApplication {
    private static ProductsManager productsManager = new ProductsManager();

    public static void main(String[] args) {

        productsManager.connectDB();

        Product p1 = new Product("pen", 16, 28);
        Product p2 = new Product("pencil", 55, 5);

        productsManager.insert(p1);
        productsManager.insert(p2);

        productsManager.printDocumentsByName("pen");

        productsManager.updatePrice("pen", 12);
        productsManager.updateStock("pencil", 14);
        productsManager.updatePriceAndStock("pen", 20, 23);
        productsManager.deleteDocByName("pen");

    }

}
