package org.wangy.webtest.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.wangy.webtest.command.ProjectCommand;
import org.wangy.webtest.service.ProjectService;

/**
 * Created by Administrator on 2015/9/7.
 */
public class ProjectValidator implements Validator{

    ProjectService projectService;

    public void setProjectService(ProjectService projectService) {
        this.projectService = projectService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        ProjectCommand project = (ProjectCommand)object;
        if (!StringUtils.hasText(project.getProjectName())){
            errors.rejectValue("name", null, "Name is empty.");
        }else if (project.getProjectName().length()> 20){
            errors.rejectValue("name",null,"Name cannot be less than 20 characters.");
        }else if (projectService.findProject(project.getProjectName())==null){
            errors.rejectValue("name",null,"Name already exists");
        }


    }


}
