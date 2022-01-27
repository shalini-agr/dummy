package Managers;

import Entities.User;
import Handlers.MorphiaHandler;

import java.util.List;

public class UsersManager {
    MorphiaHandler morphiaHandler;

    public UsersManager() {
        morphiaHandler = new MorphiaHandler();
    }

    public List<Object> getUsers() {
        return morphiaHandler.getAllDocs(User.class);
    }

    public String insert(User p) {
        morphiaHandler.insert(p);
        return "user added";
    }

    public List<Object> getUserById(int id) {
        return morphiaHandler.getObjById(id, User.class);
    }

    public String deleteUserById(int id) {
        morphiaHandler.delete(id, User.class);
        return "user deleted";
    }

    public String updateName(int id, String name) {
        return morphiaHandler.update(id, "name", name, User.class);
    }

    public String updatePhoneNo(int id, String phoneNo) {
        return morphiaHandler.update(id, "phoneNo", phoneNo, User.class);
    }

    public String updateEmail(int id, String email) {
        return morphiaHandler.update(id, "email", email, User.class);
    }

    public String updateNameAndEmail(int id, String name, String email) {
        morphiaHandler.update(id, "email", email, User.class);
        morphiaHandler.update(id, "name", name, User.class);
        return "update successful";
    }
}
