package org.wangy.webtest.command;

import org.wangy.webtest.model.Project;
import org.wangy.webtest.model.User;
import org.wangy.webtest.service.UserService;

/**
 * Created by Administrator on 2015/9/7.
 */
public class ProjectCommand {

    private String projectName;
    private User creator;
    private Integer id;
    private String username;
    private Integer userId;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public ProjectCommand(Project project) {
        this.id = project.getId();
        this.projectName = project.getProjectName();
        this.creator = project.getCreator();
        if (project.getCreator() != null) {
            this.userId = project.getCreator().getId();
            this.username = project.getCreator().getUsername();
        }
    }

    public ProjectCommand() {
    }

    //get an set
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Project toProject() throws Exception {
        Project project = new Project();
        project.setId(this.getId());
        project.setProjectName(this.getProjectName());
        if (this.getUserId() != null) {
            User user = new User();
            user.setId(this.getUserId());
            project.setCreator(user);
        }
        return project;
    }


    public void update(Project project) {
        User user = new User();
        user.setId(this.getUserId());
        project.setCreator(user);
    }

}
