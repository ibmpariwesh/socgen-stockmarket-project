package socgen.iiht.userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import socgen.iiht.userservice.model.User;
import socgen.iiht.userservice.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }
    @PostMapping("/add_user")
    public void addUser(@RequestBody User user){
        userService.addUser(user);
    }
}
