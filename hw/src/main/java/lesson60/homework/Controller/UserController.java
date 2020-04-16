package lesson60.homework.Controller;


import lesson60.homework.Model.Publication;
import lesson60.homework.Model.User;
import lesson60.homework.Services.UserAuthService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserAuthService userService;

    public UserController(UserAuthService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PostMapping("/login")
    public User login(){
        return userService.getUser();
    }

    @GetMapping("/username/{username}")
    public User getUserByUsername(@PathVariable String username){
        return userService.getByUsername(username);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email){
        return userService.getByEmail(email);
    }

    @GetMapping("/name/{name}")
    public User getUserByName(@PathVariable String name){
        return userService.getByName(name);
    }

    @GetMapping("/publications/{userId}")
    public List<Publication> getPublicationsOfUser(@PathVariable String userId){
        return userService.getPublicationsByUserId(userId);
    }
}