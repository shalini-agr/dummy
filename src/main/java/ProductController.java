import com.google.gson.Gson;

import static spark.Spark.*;

public class ProductController {

    public void apis() {
        Gson gson = new Gson();
        ProductsManager productsManager = new ProductsManager();

        get("/products/:name", (req, res) -> {
            res.type("application/json");
            String name = req.params(":name");
            return productsManager.getProductByName(name);
        }, gson::toJson);

        post("/addProduct", (req, res) -> {
            res.type("application/json");
            Product product = gson.fromJson(req.body(), Product.class);
            return productsManager.insert(product);
        }, gson::toJson);

        delete("/deleteById/:name", (req, res) -> {
            res.type("application/json");
            String name = req.params(":name");
            return productsManager.deleteProductByName(name);
        }, gson::toJson);

    }
}

