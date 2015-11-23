package org.wangy.webtest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wangy.webtest.command.JsonCommand;
import org.wangy.webtest.model.Role;
import org.wangy.webtest.service.RoleService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/10/29.
 */
@Controller
@RequestMapping("/x/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET
    )
    @ResponseBody
    protected JsonCommand list(HttpServletRequest request) {
        int limitSize = Integer.valueOf(request.getParameter("limit"));
        int startSize = Integer.valueOf(request.getParameter("start"));
        List<Role> roles = roleService.list(startSize,limitSize);
        return new JsonCommand(roles,roleService.getCount());
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected JsonCommand create(@RequestBody Role role) {
        role.setId(null);
        Integer id = roleService.save(role);
        role = roleService.get(id);
        List<Role> roles = new ArrayList<Role>(1);
        roles.add(role);
        return new JsonCommand(roles);
    }

    @RequestMapping(
            value = "/delete",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected JsonCommand delete(@RequestBody Role role) {
        roleService.delete(role.getId());
        List<Role> roles = roleService.list();
        return new JsonCommand(roles);
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected JsonCommand update(@RequestBody Role role) {
        roleService.update(role);
        List<Role> roles = roleService.list();
        return new JsonCommand(roles);
    }



}
