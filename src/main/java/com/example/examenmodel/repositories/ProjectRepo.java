package com.example.examenmodel.repositories;

import com.example.examenmodel.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
