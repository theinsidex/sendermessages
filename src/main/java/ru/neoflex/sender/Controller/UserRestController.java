package ru.neoflex.sender.Controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import ru.neoflex.sender.Model.User;
import ru.neoflex.sender.Service.UserService;

import java.util.List;


@RestController
@RequestMapping("/rest")
public class UserRestController {
    private UserService userService;

    public UserRestController(UserService userService){
        this.userService=userService;
    }

    @RequestMapping(value = "/list",
                    method = RequestMethod.GET,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public List<User> listUsers() {
        List<User> users=userService.listUsers();
        return users;
    }

    @RequestMapping(value = "/add",
                    method = RequestMethod.POST,
                    produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public void adduser(@RequestBody User user) {
        userService.addUser(user);
    }

    @RequestMapping(value = "/delete",
                    method = RequestMethod.DELETE,
                    produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    @ResponseBody
    public void deleteUser(@PathVariable("id") long id ){
        User user=userService.getUser(id);
        userService.deleteUser(user);
    }
}
