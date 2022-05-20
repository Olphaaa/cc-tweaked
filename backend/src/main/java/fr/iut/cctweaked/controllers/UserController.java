@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public HTTP getAll(){

    }

    @PostMapping
    public void addUser(@RequestBody User user){

    }
}