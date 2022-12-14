package com.example.examenmodel.services;

import com.example.examenmodel.entities.Project;
import com.example.examenmodel.entities.Sprint;
import com.example.examenmodel.repositories.ProjectRepo;
import com.example.examenmodel.repositories.SprintRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintServiceImp implements SprintServiceInterface{

    final SprintRepo sprintRepo;
    final ProjectRepo projectRepo;

    public SprintServiceImp(SprintRepo sprintRepo, ProjectRepo projectRepo) {
        this.sprintRepo = sprintRepo;
        this.projectRepo = projectRepo;
    }

    @Override
    public Sprint addSprint(Sprint sprint) {
        return sprintRepo.save(sprint);
    }

    @Override
    public List<Sprint> addSprintAndAssignToProject(Sprint sprint, int idProject) {
        sprintRepo.save(sprint);
        Project project = projectRepo.findById(idProject).orElse(null);
        if(project!=null){
            project.getSprints().add(sprint);
        }
        return project.getSprints();
    }
}
