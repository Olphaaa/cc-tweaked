package fr.iut.cctweaked.user;

import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public HttpResponse<List<User>> getAll(){
        userService.addUser(new User("toto"));
        return userService.getAll();
    }
    
}