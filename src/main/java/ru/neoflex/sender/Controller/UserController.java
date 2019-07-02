package ru.neoflex.sender.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.neoflex.sender.Model.User;
import ru.neoflex.sender.Service.MailScheduler;
import ru.neoflex.sender.Service.UserService;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    public UserController(UserService userService){
        this.userService = userService;
    }
//Получение списка всех пользователей
    @GetMapping("/list")
    public String listUser(Model model){
        List<User> users = userService.listUsers();
        model.addAttribute("users",users);
        return "user/list";
    }
//Добавление пользователя
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("user",new User());
        return "user/form";
    }
//Сохранение пользователя
    @PostMapping("/save")
    public String save(User user)
    {
        userService.addUser(user);
        return "redirect://localhost:8080/user/list";
    }
//Удаление пользователя
    @GetMapping("/{id}/delete")
    public String delete(@PathVariable long id){
        userService.deleteUser(userService.getUser(id));
        return "redirect://localhost:8080/user/list";
    }
}
