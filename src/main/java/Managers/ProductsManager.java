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
        morphiaHandler.insert(p);
        return "product added";
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
        return morphiaHandler.update(id, "price", price, Product.class);
    }

    public String updateStock(int id, int stock) {
        return morphiaHandler.update(id, "stock", stock, Product.class);
    }

    public String updateStockandPrice(int id, int stock, int price) {
        morphiaHandler.update(id, "price", price, Product.class);
        morphiaHandler.update(id, "stock", stock, Product.class);
        return "update successful";
    }

}
