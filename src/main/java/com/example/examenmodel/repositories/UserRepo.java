package com.example.examenmodel.repositories;

import com.example.examenmodel.entities.Role;
import com.example.examenmodel.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepo extends JpaRepository<User,Integer> {

    User findByFirstNameAndLastName(String firstName, String lastName);

    List<User> findByFirstNameAndLastNameAndRole(String firstName, String lastName, Role role);
}
