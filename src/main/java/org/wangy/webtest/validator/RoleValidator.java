package org.wangy.webtest.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.wangy.webtest.command.RoleCommand;
import org.wangy.webtest.service.RoleService;

/**
 * Created by Administrator on 2015/9/7.
 */
public class RoleValidator implements Validator{

    RoleService roleService;

    public void setRoleService(RoleService roleService) {
        this.roleService = roleService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        RoleCommand role = (RoleCommand)object;
        if (!StringUtils.hasText(role.getName())){
            errors.rejectValue("name", null, "Name is empty.");
        }else if (role.getName().length()> 20){
            errors.rejectValue("name",null,"Name cannot be less than 20 characters.");
        }else if (roleService.findRole(role.getName())==null){
            errors.rejectValue("name",null,"Name already exists");
        }

        if (!StringUtils.hasText(role.getDescription())) {
            errors.rejectValue("description", null, "description is empty.");
        } else if (role.getDescription().length() > 255) {
            errors.rejectValue("description", null, "description must be less than 255 characters.");
        }

    }



}
