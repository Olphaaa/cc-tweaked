package fr.iut.cctweaked.controller;

import fr.iut.cctweaked.config.SpringFoxConfig;
import fr.iut.cctweaked.domain.User;
import fr.iut.cctweaked.dto.UserSitesDTO;
import fr.iut.cctweaked.dto.UsersSuppliersAndStorages;
import fr.iut.cctweaked.service.UserService;
import io.swagger.annotations.Api;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/user")
@Api(tags = {SpringFoxConfig.USER_TAG})
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * Get all users
     *
     * @return List of users
     */
    @GetMapping
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(userService.getAll(), HttpStatus.OK);
    }

    /**
     * Get a user by id
     *
     * @param id User id
     * @return User
     */
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") String id) {
        User user = userService.getById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    /**
     * Add a user
     *
     * @param user User to add
     * @return Add user
     */
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    /**
     * Edit a user
     *
     * @param user User to edit
     * @return Edited user
     */
    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.OK);
    }

    /**
     * Delete a user
     *
     * @param id User id
     * @return Deleted user
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable("id") String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Get user's sites
     *
     * @param id User id
     * @return User's suppliers and storages
     */
    @GetMapping("/{id}/sites/expanded")
    public ResponseEntity<List<UsersSuppliersAndStorages>> getUsersSitesExpanded(@PathVariable("id") String id) {
        List<UsersSuppliersAndStorages> usersSitesExpanded = userService.getUsersSitesExpanded(id);
        return new ResponseEntity<>(usersSitesExpanded, HttpStatus.OK);
    }

    /**
     * Get user's sites expanded version
     *
     * @param id User id
     * @return User's sites
     */
    @GetMapping("/{id}/sites")
    public ResponseEntity<List<UserSitesDTO>> getUsersSites(@PathVariable("id") String id) {
        List<UserSitesDTO> usersSites = userService.getUsersSites(id);
        return new ResponseEntity<>(usersSites, HttpStatus.OK);
    }
}