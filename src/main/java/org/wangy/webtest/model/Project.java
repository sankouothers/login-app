package org.wangy.webtest.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Administrator on 2015/9/8.
 */
@Entity
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(length = 10)
    private String projectName;
    @JoinColumn(name = "userId")
    @ManyToOne(cascade ={ CascadeType.PERSIST, CascadeType.REFRESH})
    private User creator;
    @Transient
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public String getUsername() {
        if (this.getCreator() != null) {
            return this.getCreator().getUsername();
        }
        return null;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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
}
