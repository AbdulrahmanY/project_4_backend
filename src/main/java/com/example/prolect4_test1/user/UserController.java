package com.example.prolect4_test1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path="users")
@CrossOrigin("*")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getUsers(){return userService.getUsers();}

    @GetMapping("/{username}")
    public User getUser(@PathVariable String username){
        return userService.getUser(username);
    }


    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable String id, @RequestBody User data){
        return userService.updateUser(id, data);
    }

    @PutMapping("/user/image/{id}")
    public User updateProfileImage(@PathVariable String id, @RequestBody User data){
        return userService.updateProfileImage(id, data);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody User data){
        return userService.register(data);
    }

    @PostMapping("/admin")
    public User adminRegister(@RequestBody User user){
        return userService.adminRegister(user);
    }

}
class Form{
    private User user;

    private Long id_Role;

    public User getUser() {
        return user;
    }

    public Long getId_Role() {
        return id_Role;
    }
}