package com.example.examenmodel.repositories;

import com.example.examenmodel.entities.Project;
import com.example.examenmodel.entities.Sprint;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SprintRepo extends JpaRepository<Sprint,Integer> {

    public List<Sprint> findAllByProjet(Project project);
}
