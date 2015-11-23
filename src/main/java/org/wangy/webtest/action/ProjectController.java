package org.wangy.webtest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangy.webtest.command.JsonCommand;
import org.wangy.webtest.model.Project;
import org.wangy.webtest.model.User;
import org.wangy.webtest.service.ProjectService;
import org.wangy.webtest.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/29.
 */
@Controller
@RequestMapping("/x/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private UserService userService;

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET
    )
    @ResponseBody
    protected JsonCommand list(HttpServletRequest request) {
        int limitSize = Integer.valueOf(request.getParameter("limit"));
        int startSize = Integer.valueOf(request.getParameter("start"));
        List<Project> projects = projectService.list(startSize, limitSize);
        for (Project project : projects) {
            if (project.getCreator() != null) {
                project.setUserId(project.getCreator().getId());
            }
        }
        return new JsonCommand(projects, projectService.getCount());
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected JsonCommand create(@RequestBody Project project) {
        project.setId(null);
        Integer id = projectService.save(project);
        project = projectService.get(id);
        List<Project> projects = new ArrayList<Project>(1);
        projects.add(project);
        return new JsonCommand(projects);
    }

    @RequestMapping(
            value = "/delete",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected JsonCommand delete(@RequestBody Project project) {
        projectService.delete(project.getId());
        List<Project> projects = projectService.list();
        return new JsonCommand(projects);
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected JsonCommand update(@RequestBody Project project) {

        int id = project.getUserId();
        User user = userService.get(id);
        project.setCreator(user);
        projectService.update(project);
        List<Project> projects = new ArrayList<Project>();
        projects.add(project);
        return new JsonCommand(projects);

    }

}
