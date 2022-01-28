import Controllers.UserController;

import static spark.Spark.port;

public class UserService {
    public static void main(String[] args) {
        port(4568);
        UserController userController = new UserController();
        userController.apis();
    }
}
