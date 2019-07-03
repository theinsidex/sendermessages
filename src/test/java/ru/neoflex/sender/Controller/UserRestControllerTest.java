package ru.neoflex.sender.Controller;

import com.google.common.collect.ImmutableList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.neoflex.sender.Model.User;
import ru.neoflex.sender.Service.UserService;

import java.util.List;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRestControllerTest {
    @InjectMocks
    private UserRestController userController;
    @Mock
    private UserService userService;

    @Test
    public void listUser() {
        when(userService.listUsers()).thenReturn(ImmutableList.of());
        List<User> users = userController.listUsers();
        verify(userService).listUsers();
    }

    @Test
    public void addUser(){
        User user = new User();
        user.setId(2);
        user.setName("Unnamed");
        user.setEmail("unnamed@bk.ru");
        userController.addUser(user);
        when(userService.listUsers()).thenReturn(ImmutableList.of());
    }
}