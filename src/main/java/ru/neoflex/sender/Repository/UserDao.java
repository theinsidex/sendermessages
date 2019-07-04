package ru.neoflex.sender.Repository;

import ru.neoflex.sender.Model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);
    List<User> listUsers();
    User getUser(long id);
    void deleteUser(long id);
}
