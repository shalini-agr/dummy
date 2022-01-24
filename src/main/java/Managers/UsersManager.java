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
        return morphiaHandler.insert(p);
    }

    public List<Object> getUserById(int id) {
        return morphiaHandler.getObjById(id, User.class);
    }

    public String deleteUserById(int id) {
        morphiaHandler.delete(id, User.class);
        return "user deleted";
    }

    public String updateName(int id, String name) {
        return morphiaHandler.updateUser(id, "name", name);
    }

    public String updatePhoneNo(int id, String phoneNo) {
        return morphiaHandler.updateUser(id, "phoneNo", phoneNo);
    }

    public String updateEmail(int id, String email) {
        return morphiaHandler.updateUser(id, "email", email);
    }

    public String updateNameAndEmail(int id, String name, String email) {
        morphiaHandler.updateUser(id, "email", email);
        morphiaHandler.updateUser(id, "name", name);
        return "update successful";
    }
}
