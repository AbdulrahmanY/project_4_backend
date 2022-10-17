package com.example.prolect4_test1.user;


import com.example.prolect4_test1.Role.Role;
import com.example.prolect4_test1.review.Review;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_User;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
    @Column(unique = true)
    private String email;
    private String profileImage;

    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;

    @JsonIgnoreProperties("user")
    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL)
    private List<Review> reviews;

    public User() {
    }

    public User(Long id_User, String name, String username, String password, String email, String profileImage, Role role, List<Review> reviews) {
        this.id_User = id_User;
        this.name = name;
        this.username = username;
        this.password = password;
        this.email = email;
        this.profileImage = profileImage;
        this.role = role;
        this.reviews = reviews;
    }

    public Long getId_User() {
        return id_User;
    }

    public void setId_User(Long id_User) {
        this.id_User = id_User;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
