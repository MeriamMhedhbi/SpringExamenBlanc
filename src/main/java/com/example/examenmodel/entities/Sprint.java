package com.example.examenmodel.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Sprint {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Integer id;
    private String description;
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @ManyToOne
    private Project projet;

}
