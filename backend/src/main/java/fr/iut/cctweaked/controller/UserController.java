package fr.iut.cctweaked.controller;

import fr.iut.cctweaked.domain.User;
import fr.iut.cctweaked.dto.UserDTO;
import fr.iut.cctweaked.utils.mapper.UserMapper;
import fr.iut.cctweaked.service.UserService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDTO>> getAll(){
        return new ResponseEntity<>(UserMapper.userListToUserDTOList(userService.getAll()), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id){
        User user = userService.getById(new ObjectId(id));
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.addUser(UserMapper.userDTOtoUser(userDTO)), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.updateUser(UserMapper.userDTOtoUser(userDTO)), HttpStatus.OK);
    }
    
}