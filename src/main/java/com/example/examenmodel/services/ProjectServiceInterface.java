package com.example.examenmodel.services;

import com.example.examenmodel.entities.Project;
import com.example.examenmodel.entities.Sprint;

import java.util.List;

public interface ProjectServiceInterface {
    public Project addProject(Project project, Sprint sprint);
    public void assignProjectToUser(int ProjectId,int userId);

    public void assignProjectToClient(int ProjectId,String firstName,String LastName);

    public List<Project> getAllCurrentProject();
    public List<Project> getProjectsByScrumMaster(String fName,String lName);

    public List<Project> getNbrSprintByCurrentProject();
}
