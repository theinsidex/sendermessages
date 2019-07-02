package ru.neoflex.sender.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neoflex.sender.Model.User;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MailScheduler {
    private final String SUBJECT = "Пить чай";
    private final String TEXT = "Пора пить чай!";

    private MailSender mailSender;
    private UserService userService;

    @Autowired
    public MailScheduler(MailSender mailSender,UserService userService){
        this.mailSender = mailSender;
        this.userService = userService;
    }

    public void sendMessage(){
        List<User> users = userService.listUsers().stream() //проверка на наличие email
                .filter(x->!x.getEmail().equals(null))
                .collect(Collectors.toList());
        for(User user:users){
            mailSender.send(user.getEmail(),SUBJECT,TEXT);
        }
    }
}
