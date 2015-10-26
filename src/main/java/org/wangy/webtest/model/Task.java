package org.wangy.webtest.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * Created by Administrator on 2015/9/9.
 */
@Entity
public class Task implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(unique = true,nullable = false,length = 20)
    private String taskName;

    @Column(length = 200)
    private String taskDescription;

    @JoinColumn(name = "userId")
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH})
    private User user;

    @JoinColumn(name = "projectId")
    @ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.REFRESH})
    private Project project;


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
