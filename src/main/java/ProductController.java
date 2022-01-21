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

        get("/product/:name", (req, res) -> {
            res.type("application/json");
            String name = req.params(":name");
            return productsManager.getProductByName(name);
        }, gson::toJson);

        post("/addProduct", (req, res) -> {
            res.type("application/json");
            Product product = gson.fromJson(req.body(), Product.class);
            return productsManager.insert(product);
        }, gson::toJson);

        delete("/delete/:name", (req, res) -> {
            res.type("application/json");
            String name = req.params(":name");
            return productsManager.deleteProductByName(name);
        }, gson::toJson);

        put("/updatePrice/:name", (req, res) -> {
            res.type("application/json");
            String name = req.params(":name");
            Product p = gson.fromJson(req.body(), Product.class);
            return productsManager.updatePrice(name, p.getPrice());
        }, gson::toJson);

        put("/updatePriceAndStock/:name", (req, res) -> {
            res.type("application/json");
            String name = req.params(":name");
            Product p = gson.fromJson(req.body(), Product.class);
            return productsManager.updateStockandPrice(name, p.getStock(), p.getPrice());
        }, gson::toJson);

        put("/updateStock/:name", (req, res) -> {
            res.type("application/json");
            String name = req.params(":name");
            Product p = gson.fromJson(req.body(), Product.class);
            return productsManager.updateStock(name, p.getStock());
        }, gson::toJson);

    }
}

