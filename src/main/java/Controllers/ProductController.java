package Controllers;

import Entities.Product;
import Managers.ProductsManager;
import com.google.gson.Gson;

import static spark.Spark.*;

public class ProductController {
    Gson gson;
    ProductsManager productsManager;

    public ProductController() {
        gson = new Gson();
        productsManager = new ProductsManager();
    }

    public void apis() {

        get("/products", (req, res) -> {
            res.type("application/json");
            return productsManager.getProducts();
        }, gson::toJson);

        get("/product/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            return productsManager.getProductById(id);
        }, gson::toJson);

        post("/addProduct", (req, res) -> {
            res.type("application/json");
            Product product = gson.fromJson(req.body(), Product.class);
            return productsManager.insert(product);
        }, gson::toJson);

        delete("/delete/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            return productsManager.deleteProductById(id);
        }, gson::toJson);

        put("/updatePrice/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            Product p = gson.fromJson(req.body(), Product.class);
            return productsManager.updatePrice(id, p.getPrice());
        }, gson::toJson);

        put("/updatePriceAndStock/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            Product p = gson.fromJson(req.body(), Product.class);
            return productsManager.updateStockandPrice(id, p.getStock(), p.getPrice());
        }, gson::toJson);

        put("/updateStock/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            Product p = gson.fromJson(req.body(), Product.class);
            return productsManager.updateStock(id, p.getStock());
        }, gson::toJson);

    }
}

