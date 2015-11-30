package org.wangy.webtest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangy.webtest.command.JsonCommand;
import org.wangy.webtest.model.Project;
import org.wangy.webtest.model.Task;
import org.wangy.webtest.model.User;
import org.wangy.webtest.service.ProjectService;
import org.wangy.webtest.service.TaskService;
import org.wangy.webtest.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/24.
 */
@Controller
@RequestMapping("/usertree")
public class UserTreeController {

    @Autowired
    private UserService userService;
    @Autowired
    private ProjectService projectService;
    @Autowired
    private TaskService taskService;


    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET
    )
    @ResponseBody
    protected JsonCommand create(HttpServletRequest request) {
        List<TreeData> result = new ArrayList<TreeData>();
        String a = request.getParameter("node");
        String[] b = a.split("-",4);
        List<User> users = userService.list();
        List<Project> projects = projectService.list();
        List<Task> tasks = taskService.list();

        if (a.equals("root")) {
            for (User user : users) {
                TreeData node = new TreeData("user-" + user.getId(), false, user.getUsername(), false);
                result.add(node);
            }

            return new JsonCommand<TreeData>(result);
        }

        //通过node取到的节点的 ID 的 这个user是指当前节点的user

        User user = userService.get(Integer.valueOf(b[1]));
        if (a.equals("user-" + user.getId())) {
            for (Project project : projects) {
                if (project.getCreator().equals(user) && project.getCreator() != null) {
                    TreeData node = new TreeData("user-" + user.getId() + "-" + "project-" + project.getId(), false, project.getProjectName(), false);
                    result.add(node);
                }
            }
            return new JsonCommand<TreeData>(result);
        }

        Project project = projectService.get(Integer.valueOf(b[3]));
        if (a.equals("user-" + user.getId()+"-"+"project-"+project.getId())) {
            for (Task task : tasks) {
                if (task.getProject().equals(project) && task.getProject() != null&& task.getUser().equals(user)) {
                    TreeData node = new TreeData("user-" + user.getId() + "-" + "project-" + project.getId()+"-"+"task-"+task.getId(),true,task.getTaskName());
                    result.add(node);
                }
            }
            return new JsonCommand<TreeData>(result);
        }
        return new JsonCommand<TreeData>();
    }
}
