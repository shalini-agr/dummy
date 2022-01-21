import com.google.gson.Gson;

import static spark.Spark.*;

public class UserController {
    Gson gson;
    UsersManager usersManager;

    public UserController() {
        gson = new Gson();
        usersManager = new UsersManager();
    }

    public void apis() {

        get("/users", (req, res) -> {
            res.type("application/json");
            return usersManager.getUsers();
        }, gson::toJson);

        get("/user/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            return usersManager.getUserById(id);
        }, gson::toJson);

        post("/addUser", (req, res) -> {
            res.type("application/json");
            User user = gson.fromJson(req.body(), User.class);
            return usersManager.insert(user);
        }, gson::toJson);

        delete("/delete/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            return usersManager.deleteUserById(id);
        }, gson::toJson);

        put("/updateUserName/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            User u = gson.fromJson(req.body(), User.class);
            return usersManager.updateName(id, u.getName());
        }, gson::toJson);

        put("/updateUserEmail/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            User u = gson.fromJson(req.body(), User.class);
            return usersManager.updateEmail(id, u.getEmail());
        }, gson::toJson);

        put("/updateUserPhoneNo/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            User u = gson.fromJson(req.body(), User.class);
            return usersManager.updatePhoneNo(id, u.getPhoneNo());
        }, gson::toJson);

        put("/updateUserNameAndEmail/:id", (req, res) -> {
            res.type("application/json");
            int id = Integer.parseInt(req.params(":id"));
            User u = gson.fromJson(req.body(), User.class);
            return usersManager.updateNameAndEmail(id, u.getName(), u.getEmail());
        }, gson::toJson);

    }
}


