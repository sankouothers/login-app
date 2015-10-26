package org.wangy.webtest.command;

import org.wangy.webtest.model.Project;
import org.wangy.webtest.model.Task;
import org.wangy.webtest.model.User;

import java.util.Set;

/**
 * Created by Administrator on 2015/9/7.
 */
public class TaskCommand {
   //TaskCommand  attribute
    private Integer id;
    private String taskName;
    private String taskDescription;
    //TaskCommand  attribute end

    //user attribute
    private User user;
    private String username;
    private Integer userId;
    //user attribute end

    //project attribute
    private Project project;
    private Integer projectId;
    private String projectName;
    //project attribute end


    public TaskCommand() {
    }

    public TaskCommand(Task task) {
        this.id = task.getId();
        this.taskName = task.getTaskName();
        this.taskDescription = task.getTaskDescription();
        if (task.getUser() != null){
            this.userId = task.getUser().getId();
            this.username = task.getUser().getUsername();
        }
        if (task.getProject() != null){
            this.projectId= task.getProject().getId();
            this.projectName = task.getProject().getProjectName();
        }

    }

    public Task toTask() throws Exception {
        Task task = new Task();
        task.setId(this.getId());
        task.setTaskName(this.getTaskName());
        task.setTaskDescription(this.getTaskDescription());
        if (this.getUserId() != null) {
            User user = new User();
            user.setId(this.getUserId());
            task.setUser(user);
        }
        if (this.getProjectId() != null){
            Project project = new Project();
            project.setId(this.getProjectId());
            task.setProject(project);
        }
        return task;
    }


    public void update(Task task) {
        User user = new User();
        Project project = new Project();
        user.setId(this.getUserId());
        project.setId(this.getProjectId());
        task.setUser(user);
    }

    //TaskCommand get and set
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }
    //TaskCommand get and set end


    //user get and set
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

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
    //user get and set end

    //project get and set
    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
    //project get and set end




}
