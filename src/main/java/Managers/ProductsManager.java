package Managers;

import Entities.Product;
import Handlers.MorphiaHandler;

import java.util.List;

public class ProductsManager {
    MorphiaHandler morphiaHandler;

    public ProductsManager() {
        morphiaHandler = new MorphiaHandler();
    }

    public String insert(Product p) {
        return morphiaHandler.insertProduct(p);
    }

    public List<Product> getProducts() {
        return morphiaHandler.getProducts();
    }

    public List<Product> getProductById(int id) {
        return morphiaHandler.getProductById(id);
    }

    public String deleteProductById(int id) {
        morphiaHandler.deleteProductById(id);
        return "product deleted";
    }

    public String updatePrice(int id, int price) {
        return morphiaHandler.updateProductPrice(id, price);
    }

    public String updateStock(int id, int stock) {
        return morphiaHandler.updateProductStock(id, stock);
    }

    public String updateStockandPrice(int id, int stock, int price) {
        morphiaHandler.updateProductPrice(id, price);
        morphiaHandler.updateProductStock(id, stock);
        return "update successful";
    }

}
