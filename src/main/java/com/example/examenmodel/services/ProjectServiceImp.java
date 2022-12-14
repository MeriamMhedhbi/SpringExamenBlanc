package com.example.examenmodel.services;

import com.example.examenmodel.entities.Project;
import com.example.examenmodel.entities.Role;
import com.example.examenmodel.entities.Sprint;
import com.example.examenmodel.entities.User;
import com.example.examenmodel.repositories.ProjectRepo;
import com.example.examenmodel.repositories.SprintRepo;
import com.example.examenmodel.repositories.UserRepo;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.query.criteria.internal.expression.function.CurrentDateFunction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ProjectServiceImp implements ProjectServiceInterface {
    final ProjectRepo projectRepo;
    final SprintRepo sprintRepo;

    final UserRepo userRepo;

    public ProjectServiceImp(UserRepo userRepo, ProjectRepo projectRepo, SprintRepo sprintRepo) {
        this.userRepo = userRepo;
        this.projectRepo = projectRepo;
        this.sprintRepo = sprintRepo;
    }

    @Override
    @Transactional
    public Project addProject(Project project,Sprint sprint) {
        //List<Sprint> sprints = sprintRepo.findAllByProjet(project);
        sprint.setProjet(project);
        sprintRepo.save(sprint);
        return  projectRepo.save(project);
    }

    @Override
    public void assignProjectToUser(int ProjectId, int userId) {
        User user = userRepo.findById(userId).orElse(null);
        Project project = projectRepo.findById(ProjectId).orElse(null);
        if(project!=null && user != null){
            project.getUsers().add(user);
        }
    }

    @Override
    public void assignProjectToClient(int ProjectId, String firstName, String LastName) {
        User user = userRepo.getUserByFNameAndLName(firstName,LastName);
        Project project = projectRepo.findById(ProjectId).orElse(null);

        if(project!=null && user != null){
            user.getProjectList().add(project);
            project.getUsers().add(user);
        }
    }

    @Override
    public List<Project> getAllCurrentProject() {
        List<Project> projects = projectRepo.findAll();
        List<Project> projectList = null;
        for (Project p : projects){

            List<Sprint> sprints = p.getSprints();
            for (Sprint st : sprints){
                if(st.getStartDate().before(new Date())){
                    projectList.add(p);
                }
            }

        }
        return projectList;
    }

    @Override
    public List<Project> getProjectsByScrumMaster(String fName, String lName) {
        List<User> users = userRepo.getUserByFNameAndLNameAndRole(fName,lName, Role.Scrum_Master);
        List<Project> projects = null;
        for (User u:users){
            projects.addAll(u.getProjects());
        }
        return projects;
    }

    @Override
    @Scheduled(fixedRate = 30)
    public List<Project> getNbrSprintByCurrentProject() {

        log.info("size is :" + getAllCurrentProject().size()  );
        return null;
    }
}
