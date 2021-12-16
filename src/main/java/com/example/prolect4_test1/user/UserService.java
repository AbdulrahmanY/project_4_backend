package com.example.prolect4_test1.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getUsers (){return userRepo.findAll();}

    public User getUser (String username){return userRepo.findByUsername(username);}

    public void updateUser(String id, User data){
        Long user_id = Long.parseLong(id);
        User user = userRepo.findById(user_id).orElse(null);

        if (user != null){
            user.setName(data.getName());
            user.setPassword(data.getPassword());
            userRepo.save(user);
        }
    }

    public void deleteUser(String id){
        Long user_id = Long.parseLong(id);
        userRepo.deleteById(user_id);
    }

    public User register(User user){return userRepo.save(user);}

    public ResponseEntity<?> login(User data){
        User user=userRepo.findByUsername(data.getUsername());
        if (user != null) {
            if (user.getPassword().equals(data.getPassword())) {
                return ResponseEntity.ok().body(userRepo.findByUsername(data.getUsername()));
            }
            else{
                return ResponseEntity.status(404).body("Wrong Password");
            }
        }
        else {
            return ResponseEntity.status(404).body("User Not Found!");
        }

    }
}
