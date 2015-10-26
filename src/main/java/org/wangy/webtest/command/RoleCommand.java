package org.wangy.webtest.command;

import org.wangy.webtest.model.Role;
import org.wangy.webtest.model.User;

import java.util.Set;

/**
 * Created by Administrator on 2015/9/7.
 */
public class RoleCommand {
    private String name;
    private String description;
    private Integer id;

    public RoleCommand(Role role){
        this.id  =  role.getId();
        this.name = role.getName();
        this.description = role.getDescription();
    }

    public RoleCommand() {}

    //get an set
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Role toRole()throws Exception{
        Role role = new Role();
        role.setId(this.getId());
        role.setName(this.getName());
        role.setDescription(this.getDescription());
        return role;
    }

    public void update(Role role) {
        role.setDescription(this.getDescription());
    }
    //get and set end
}
