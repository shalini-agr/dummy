package Managers;
import Entities.User;
import Handlers.MorphiaHandler;

import java.util.List;

public class UsersManager {
    MorphiaHandler morphiaHandler;

    public UsersManager() {
        morphiaHandler = new MorphiaHandler();
    }

    public List<User> getUsers() {
        return morphiaHandler.getUsers();
    }

    public String insert(User p) {
        return morphiaHandler.insertUser(p);
    }

    public List<User> getUserById(int id) {
        return morphiaHandler.getUserById(id);
    }

    public String deleteUserById(int id) {
        morphiaHandler.deleteUserById(id);
        return "user deleted";
    }

    public String updateName(int id, String name) {
        return morphiaHandler.updateUserName(id, name);
    }

    public String updatePhoneNo(int id, String phoneNo) {
        return morphiaHandler.updateUserPhoneNo(id, phoneNo);
    }

    public String updateEmail(int id, String email) {
        return morphiaHandler.updateUserEmail(id, email);
    }

    public String updateNameAndEmail(int id, String name, String email) {
        morphiaHandler.updateUserEmail(id, email);
        morphiaHandler.updateUserName(id, name);
        return "update successful";
    }
}
