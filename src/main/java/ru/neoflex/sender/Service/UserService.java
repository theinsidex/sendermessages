package ru.neoflex.sender.Service;

import org.springframework.stereotype.Service;
import ru.neoflex.sender.Model.User;
import ru.neoflex.sender.Repository.UserRepo;

import java.util.List;

@Service
public class UserService {
    private UserRepo userRepo;

    public UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public void addUser(User user){
        userRepo.addUser(user);
    }
    public List<User> listUsers(){
        List<User> users = userRepo.listUsers();
        return users;
    }
    public User getUser(long id){
        User user = userRepo.getUser(id);
        return user;
    }
    public void deleteUser(User user){
        userRepo.deleteUser(user);
    }
}
