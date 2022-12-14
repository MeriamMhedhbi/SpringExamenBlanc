package com.example.examenmodel.services;

import com.example.examenmodel.entities.Sprint;

import java.util.List;

public interface SprintServiceInterface {
    public Sprint addSprint(Sprint sprint);
    public List<Sprint> addSprintAndAssignToProject(Sprint sprint,int idProject);
}
