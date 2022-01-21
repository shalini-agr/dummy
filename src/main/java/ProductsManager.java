import java.util.List;

public class ProductsManager {
    MorphiaHandler morphiaHandler;

    public ProductsManager() {
        morphiaHandler = new MorphiaHandler();
    }

    public String insert(Product p) {
        return morphiaHandler.insert(p);
    }

    public List<Product> getProductByName(String name) {
        return morphiaHandler.getProductByName(name);
    }

    public String deleteProductByName(String name) {
        morphiaHandler.deleteByName(name);
        return "product deleted";
    }

    public String updatePrice(String name, int price) {
        return morphiaHandler.updatePrice(name, price);
    }

    public String updateStock(String name, int stock) {
        return morphiaHandler.updateStock(name, stock);
    }

    public String updateStockandPrice(String name, int stock, int price) {
        return morphiaHandler.updateStockAndPrice(name, stock, price);
    }

}
