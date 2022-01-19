public class MainApplication {
    private static MongoDBManager mongoDBManager = new MongoDBManager();
    private static ProductsManager productsManager = new ProductsManager();

    public static void main(String[] args) {

        mongoDBManager.connectMongoDB("localhost", 27018);

        System.out.println("List of Databases:");
        mongoDBManager.printListofDatabases();

        System.out.println("List of Collections in shop:");
        mongoDBManager.printListofCollections("shop");

        productsManager.insert("pen", 10, 20);
        productsManager.insert("pencil", 5, 25);

        System.out.println("List of all Documents in products:");
        mongoDBManager.printAlldocumentsInCollection("products", "shop");

        System.out.println("List of all Documents with name pen:");
        productsManager.printDocumentsByName("pen");

        productsManager.updatePrice("pen", 12);
        productsManager.updateStock("pencil", 14);
        productsManager.updatePriceAndStock("pen", 20, 23);
        System.out.println("List of Documents in products after update:");
        mongoDBManager.printAlldocumentsInCollection("products", "shop");

        productsManager.deleteDocByName("pen");
        System.out.println("List of Documents in products after deletion:");
        mongoDBManager.printAlldocumentsInCollection("products", "shop");

    }

}
