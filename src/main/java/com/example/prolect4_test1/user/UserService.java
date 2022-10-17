package com.example.prolect4_test1.user;

import com.example.prolect4_test1.Role.Role;
import com.example.prolect4_test1.Role.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserService implements UserDetailsService {
    private final UserRepo userRepo;
    private final RoleRepo roleRepo;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepo userRepo, RoleRepo roleRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        if(user  == null){
            throw new UsernameNotFoundException("User not found in the database");
        }
        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        Role role = user.getRole();
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }

    public List<User> getUsers (){return userRepo.findAll();}

    public User getUser (String username){return userRepo.findByUsername(username);}

    public ResponseEntity<?> updateUser(String id, User data){
        Long user_id = Long.parseLong(id);
        User user = userRepo.findById(user_id).orElse(null);

        if (user != null){
            if(userRepo.findByUsername(data.getUsername())==null){
                if(userRepo.findByEmail(data.getEmail())==null){
                    user.setName(data.getName());
                    user.setUsername(data.getUsername());
                    user.setEmail(data.getEmail());
                    if(data.getProfileImage()!=null){
                        user.setProfileImage(data.getProfileImage());
                    }
                    return ResponseEntity.ok().body(userRepo.save(user));

                }
                else{
                    return ResponseEntity.status(404).body("Email is already exist");
                }
            }
            else {
                return ResponseEntity.status(404).body("Username is already exist");
            }

        }
        else{
            return ResponseEntity.status(404).body("The user does not exist");
        }
    }

    public void deleteUser(String id){
        Long user_id = Long.parseLong(id);
        userRepo.deleteById(user_id);
    }

    public User adminRegister(User user){
        Role role = roleRepo.findById(Long.valueOf(2)).orElse(null);
        user.setRole(role);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setEmail("admin@admin.com");
        user.setName("Admin");
        user.setProfileImage("https://icons.veryicon.com/png/o/miscellaneous/yuanql/icon-admin.png");
        return userRepo.save(user);}

    public ResponseEntity<?> register (User data){
        Role role = roleRepo.findById(Long.valueOf(1)).orElse(null);
        data.setRole(role);
          data.setPassword(passwordEncoder.encode(data.getPassword()));
        User user=userRepo.findByUsername(data.getUsername());
        if(user == null){
            if(userRepo.findByEmail(data.getEmail())==null){
                data.setProfileImage("https://icons-for-free.com/iconfiles/png/512/game+gamers+gaming+remote+icon-1320165659668637600.png");
                return ResponseEntity.ok().body(userRepo.save(data));
            }
            else{
                return ResponseEntity.status(404).body("Email is already exist");
            }
        }
        else {
            return ResponseEntity.status(404).body("Username is already exist");
        }
    }

//    public ResponseEntity<?> login(User data){
//        User user=userRepo.findByUsername(data.getUsername());
//        if (user != null) {
//            if (user.getPassword().equals(data.getPassword())) {
//                return ResponseEntity.ok().body(userRepo.findByUsername(data.getUsername()));
//            }
//            else{
//                return ResponseEntity.status(404).body("Wrong Password");
//            }
//        }
//        else {
//            return ResponseEntity.status(404).body("User Not Found!");
//        }
//
//    }

    public User updateProfileImage(String id, User data){
        Long user_id = Long.parseLong(id);
        User user = userRepo.findById(user_id).orElse(null);

        if(user != null){
            user.setProfileImage(data.getProfileImage());
            userRepo.save(user);
        }
        return null;
    }
}
