package fr.iut.cctweaked.user;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        User user = userService.getById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
//        return userService.addUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
//        return userService.updateUser(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    
}