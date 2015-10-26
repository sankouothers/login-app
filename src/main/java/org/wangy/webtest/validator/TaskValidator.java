package org.wangy.webtest.validator;

import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.wangy.webtest.command.TaskCommand;
import org.wangy.webtest.service.TaskService;
import org.wangy.webtest.service.TaskService;

/**
 * Created by Administrator on 2015/9/7.
 */
public class TaskValidator implements Validator{

    TaskService taskService;

    public void setTaskService(TaskService taskService) {
        this.taskService = taskService;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object object, Errors errors) {
        TaskCommand task = (TaskCommand)object;
        if (!StringUtils.hasText(task.getTaskName())){
            errors.rejectValue("taskName", null, "Name is empty.");
        }else if (task.getTaskName().length()> 20){
            errors.rejectValue("taskName",null,"Name cannot be less than 20 characters.");
        }else if (taskService.findTask(task.getTaskName())!=null){
            errors.rejectValue("taskName",null,"Name already exists");
        }

        if (!StringUtils.hasText(task.getTaskDescription())){
             if (task.getTaskDescription().length()> 200) {
                 errors.rejectValue("taskDescription", null, "Name cannot be less than 20 characters.");
             }
        }

    }


}
