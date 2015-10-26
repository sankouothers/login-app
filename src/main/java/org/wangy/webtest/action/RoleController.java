package org.wangy.webtest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.wangy.webtest.command.RoleCommand;
import org.wangy.webtest.model.Role;
import org.wangy.webtest.service.RoleService;
import org.wangy.webtest.validator.RoleValidator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by Administrator on 2015/9/6.
 */
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleValidator validator;

    @RequestMapping(value = "/info",method = RequestMethod.GET)
    public String getRole(
            Integer id,
            Model model
    ) {
        Role role = roleService.get(id);
        model.addAttribute("role", role);
        return "/role/info";
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addRole(Model model) {
        model.addAttribute("command", new Role());
        return "/role/add";
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String listRole(
            Model model,
            String query
    ) {
        List<Role> roleList = null;
        if (query == null || "".equals(query)) {
            roleList = roleService.list();
        } else {
            roleList = roleService.findRoles(query);
        }
        model.addAttribute("roleList", roleList);

        return "/role/list";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    protected String deleteRole(Integer id) {
        roleService.delete(id);
        return "redirect:/role/list";
    }

    @RequestMapping(
            value = "/edit",
            method = RequestMethod.GET
    )
    protected String editRole(
            Integer id,
            Model model
    ) {
        Role role = roleService.get(id);
        if (role != null) {
            model.addAttribute("role", role);
            model.addAttribute("command", new RoleCommand(role));
            return "role/edit";
        }
        return "/error";
    }


    @RequestMapping(
            value = "/edit",
            method = RequestMethod.POST)
    protected String updateRole(
            @ModelAttribute("command") RoleCommand command,
            BindingResult result,
            Model model
    ) throws Exception {
        validator.validate(command, result);
        if (!result.hasErrors()) {
            Role role = roleService.get(command.getId());
            command.update(role);
            roleService.update(role);
            return "redirect:/role/info?id=" + role.getId();
        } else {
            Role role = command.toRole();
            return "/role/edit?id="+role.getId();
        }
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String createRole(
            @ModelAttribute("command") Role command,
            BindingResult result,
            Model model
    ) {

        if (result.hasErrors())
            return "/role/add";
        else {
            Integer id = roleService.save(command);
            return "redirect:/role/info?id=" + id;
        }
    }


}
