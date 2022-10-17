package com.example.prolect4_test1.Role;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Role;
    private String name;

    public Role() {
    }

    public Role(Long id_Role, String name) {
        this.id_Role = id_Role;
        this.name = name;
    }

    public Long getId_Role() {
        return id_Role;
    }

    public void setId_Role(Long id_Role) {
        this.id_Role = id_Role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
