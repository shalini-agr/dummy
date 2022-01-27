import Controllers.OrderController;
import Controllers.ProductController;

public class ProductAndOrderService {
    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.apis();
        OrderController orderController = new OrderController();
        orderController.apis();
    }
}
