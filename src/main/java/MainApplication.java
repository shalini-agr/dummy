public class MainApplication {

    public static void main(String[] args) {
        ProductController productController = new ProductController();
        productController.apis();
        UserController userController = new UserController();
        userController.apis();
        OrderController orderController = new OrderController();
        orderController.apis();
    }

}
