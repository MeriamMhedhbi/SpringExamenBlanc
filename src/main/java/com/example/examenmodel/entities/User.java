package com.example.examenmodel.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String email;
    private String pwd;
    private String firstName;
    private String lastName;
    @Enumerated(EnumType.STRING)
    private Role role;

    @ManyToMany
    private List<Project> projects;

    @OneToMany
    private  List<Project> projectList;
}
