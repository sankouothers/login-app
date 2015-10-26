package org.wangy.webtest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wangy.webtest.command.ProjectCommand;
import org.wangy.webtest.command.UserCommand;
import org.wangy.webtest.model.Project;
import org.wangy.webtest.model.User;
import org.wangy.webtest.service.ProjectService;
import org.wangy.webtest.service.UserService;
import org.wangy.webtest.validator.ProjectValidator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/9/6.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {
    /**扫描 AutoWired
     * 1. 当前属性的类型
     * 2. 从spring的库中查看有没有当前类型的bean存在
     * 3. 若存在对应类型的bean，就给当前属性赋值
     */
    @Autowired
    private ProjectService projectService;

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectValidator validator;

    @RequestMapping(value = "/info", method = RequestMethod.GET)
    public String getProject(
            Integer id,
            Model model
    ) {
        Project project = projectService.get(id);
        model.addAttribute("project", new ProjectCommand(project));
        return "/project/info";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addProject(Model model) {
        List<User> users = userService.list();
        model.addAttribute("users", users);
        model.addAttribute("command", new ProjectCommand());
        return "/project/add";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listProject(
            Model model,
            String query
    ) {
        List<Project> projectList = null;
        if (query == null || "".equals(query)) {
            projectList = projectService.list();
        } else {
            projectList = projectService.findProjects(query);
        }
        model.addAttribute("projectList", projectList);

        return "/project/list";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    protected String deleteProject(Integer id) {
        projectService.delete(id);
        return "redirect:/project/list";
    }

    @RequestMapping(
            value = "/edit",
            method = RequestMethod.GET
    )
    protected String editProject(
            Integer id,
            Model model
    ) {
        Project project = projectService.get(id);
        if (project != null) {

            List<User> users = userService.list();
            model.addAttribute("users", users);
            model.addAttribute("command", new ProjectCommand(project));
            return "/project/edit";
        }
        return "/error";
    }


    @RequestMapping(
            value = "/edit",
            method = RequestMethod.POST)
    protected String updateProject(
            @ModelAttribute("command") ProjectCommand command,
            BindingResult result,
            Model model
    ) throws Exception {
        validator.validate(command, result);
        if (!result.hasErrors()) {
            Project project = projectService.get(command.getId());
            command.update(project);
            projectService.update(project);
            return "redirect:/project/info?id=" + project.getId();
        } else {
            List<User> users = userService.list();
            model.addAttribute("users", users);
            return "/project/edit";
        }
    }

    @RequestMapping(
            value = "/edit2",
            method = RequestMethod.POST)
    protected String updateProject2(
            BindingResult result,
            Model model,
            HttpServletRequest request
    ) throws Exception {
        Map params = request.getParameterMap();
        ProjectCommand command = new ProjectCommand();
        for (Object paramName : params.keySet()) {
            Object value = params.get(paramName);
            if (value != null) {
                if ("projectName".equals(paramName)) {
                    command.setProjectName(value.toString());
                }
                else if ("id".equals(paramName)){
                    command.setId(Integer.valueOf(value.toString()));
                }
            }
        }


        validator.validate(command, result);
        if (!result.hasErrors()) {
            Project project = projectService.get(command.getId());
            command.update(project);
            projectService.update(project);
            return "redirect:/project/info?id=" + project.getId();
        } else {
            List<User> users = userService.list();
            model.addAttribute("users", users);
            return "/project/edit";
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createProject(
            @ModelAttribute("command") ProjectCommand command,
            BindingResult result,
            Model model
    ) throws Exception {

        if (!result.hasErrors()) {
            Project project = command.toProject();
            Integer id = projectService.save(project);
            return "redirect:/project/info?id=" + id;
        } else {
            return "/project/add";
        }
    }


}
