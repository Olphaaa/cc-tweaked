package fr.iut.cctweaked.controller;

import fr.iut.cctweaked.config.SpringFoxConfig;
import fr.iut.cctweaked.domain.User;
import fr.iut.cctweaked.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@Api(tags = {SpringFoxConfig.USER_TAG})
public class    UserController {

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
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}