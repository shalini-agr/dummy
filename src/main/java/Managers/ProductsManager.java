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
        return morphiaHandler.insert(p);
    }

    public List<Object> getProducts() {
        return morphiaHandler.getAllDocs(Product.class);
    }

    public List<Object> getProductById(int id) {
        return morphiaHandler.getObjById(id, Product.class);
    }

    public String deleteProductById(int id) {
        morphiaHandler.delete(id, Product.class);
        return "product deleted";
    }

    public String updatePrice(int id, int price) {
        return morphiaHandler.updateProduct(id, "price", price);
    }

    public String updateStock(int id, int stock) {
        return morphiaHandler.updateProduct(id, "stock", stock);
    }

    public String updateStockandPrice(int id, int stock, int price) {
        morphiaHandler.updateProduct(id, "price", price);
        morphiaHandler.updateProduct(id, "stock", stock);
        return "update successful";
    }

}
