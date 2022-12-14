package com.example.examenmodel.services;

import com.example.examenmodel.entities.User;
import com.example.examenmodel.repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserServiceInterface{

    final UserRepo userRepo;

    public UserServiceImp(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public User addUser(User user) {
     return  userRepo.save(user);
    }
}
