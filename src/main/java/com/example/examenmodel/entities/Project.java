package com.example.examenmodel.entities;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String title;
    private String description;

    @OneToMany(mappedBy = "projet",fetch = FetchType.EAGER)
    private List<Sprint> sprints;

    @ManyToMany(mappedBy ="projects")
    private List<User> users;
}
