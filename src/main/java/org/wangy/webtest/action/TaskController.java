package org.wangy.webtest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wangy.webtest.command.TaskCommand;
import org.wangy.webtest.model.Project;
import org.wangy.webtest.model.Task;
import org.wangy.webtest.model.User;
import org.wangy.webtest.service.ProjectService;
import org.wangy.webtest.service.TaskService;
import org.wangy.webtest.service.UserService;
import org.wangy.webtest.validator.TaskValidator;

import java.util.List;

/**
 * Created by Administrator on 2015/9/10.
 */
@Controller
@RequestMapping("/task")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    ProjectService projectService;

    @Autowired
    UserService userService;

    @Autowired
    TaskValidator validator;


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addTask(Model model) {
        List<Project> projectList = projectService.list();
        List<User> userList = userService.list();
        model.addAttribute("projectList",projectList);
        model.addAttribute("userList",userList);
        model.addAttribute("command", new TaskCommand());
        return "/task/add";
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createProject(
            @ModelAttribute("command") TaskCommand command,
            BindingResult result,
            Model model
    ) throws Exception {
        validator.validate(command, result);
        if (!result.hasErrors()) {
            Task task = command.toTask();
            Integer id = taskService.save(task);
            return "redirect:/task/info?id=" + id;
        } else {
            return "/task/add";
        }
    }

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getProject(
            Integer id,
            Model model
    ) {
        Task task = taskService.get(id);
        model.addAttribute("task", new TaskCommand(task));
        return "/task/info";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listProject(
            Model model,
            String query
    ) {
        List<Task> taskList = null;
        if (query == null || "".equals(query)) {
            taskList = taskService.list();
        } else {
            taskList = taskService.findTasks(query);
        }
        model.addAttribute("taskList", taskList);

        return "/task/list";
    }



    @RequestMapping(
            value = "/edit",
            method = RequestMethod.GET
    )
    protected String editProject(
            Integer id,
            Model model
    ) {
        Task task = taskService.get(id);
        if (task != null) {

            List<User> userList = userService.list();
            model.addAttribute("userList",userList);
            List<Project> projectList = projectService.list();
            model.addAttribute("projectList",projectList);
            model.addAttribute("command", new TaskCommand(task));
            return "/task/edit";
        }
        return "/error";
    }


    @RequestMapping(
            value = "/edit",
            method = RequestMethod.POST)
    protected String updateProject(
            @ModelAttribute("command") TaskCommand command,
            BindingResult result,
            Model model
    ) throws Exception {
        validator.validate(command, result);
        if (!result.hasErrors()) {
            Task task = taskService.get(command.getId());
            command.update(task);
            taskService.update(task);
            return "redirect:/task/info?id=" + task.getId();
        } else {
            Task task = taskService.get(command.getId());
            List<User> userList = userService.list();
            model.addAttribute("userList",userList);
            List<Project> projectList = projectService.list();
            model.addAttribute("projectList",projectList);
            return "/task/edit";
        }
    }


    @RequestMapping(
            value  = "/delete",
            method = RequestMethod.GET
    )
    protected String deleteUser(Integer id, Model model) {
        taskService.delete(id);
        return "redirect:/task/list";
    }

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
     protected String upload(){
        return "/file/upload";
    }
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    protected String uploadadd(){
        return "/file/upload";
    }

}
