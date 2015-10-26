package org.wangy.webtest.action;

import java.io.*;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.wangy.webtest.command.UserCommand;
import org.wangy.webtest.model.Role;
import org.wangy.webtest.model.User;
import org.wangy.webtest.service.RoleService;
import org.wangy.webtest.service.UserService;
import org.wangy.webtest.validator.UserValidator;


/**
 * Created by Yang Wang on 8/26/15.
 *
 * @author $author$
 * @version $Revision$, $Date$
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    private UserValidator validator = new UserValidator();

    @RequestMapping(
            value = "/add",
            method = RequestMethod.GET
    )
    protected String addUser(Model model,HttpServletRequest request, HttpServletResponse response,String username) {
//        List<Role> roles = roleService.list();
//        model.addAttribute("roles", roles);
//        model.addAttribute("command", new UserCommand());
        System.out.println(username);
        return "addUser";
    }

    @RequestMapping(
            value = "/edit",
            method = RequestMethod.GET
    )
    protected String editUser(Integer id, Model model) {
        User user = userService.get(id);
        if (user != null) {
            List<Role> roles = roleService.list();
            model.addAttribute("roles", roles);
            model.addAttribute("command", new UserCommand(user));

            return "/user/edit";
        }

        return "/error";
    }


    @RequestMapping(value = "/info")
    protected String createUser(Integer id, Model model) throws Exception {
        User user = userService.get(id);
        model.addAttribute("user", new UserCommand(user));

        return "/user/info";
    }

    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param request  DOCUMENT ME!
     * @param response DOCUMENT ME!
     * @param command  user DOCUMENT ME!
     * @param result   DOCUMENT ME!
     * @return DOCUMENT ME!
     * @throws Exception DOCUMENT ME!
     */
    @RequestMapping(
            value = "/add",
            method = RequestMethod.POST
    )
    protected String createUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("command") UserCommand command, BindingResult result, Model model) throws Exception {
        validator.validate(command, result);

        return "addUser";
    }


    @RequestMapping(
            value = "/edit",
            method = RequestMethod.POST
    )
    protected String updateUser(HttpServletRequest request, HttpServletResponse response,
                                @ModelAttribute("command") UserCommand command, BindingResult result, Model model) throws Exception {
        validator.validate(command, result);

        if (!result.hasErrors()) {
            User user = command.toUser();
            userService.update(user);

            return "redirect:/user/info?id=" + user.getId();
        } else {
            List<Role> roles = roleService.list();
            model.addAttribute("roles", roles);
            return "/user/edit";
        }
    }

    @RequestMapping(
            value = "/list",
            method = RequestMethod.GET
    )
    protected String listUser(String query, Model model) {
        List<User> users = null;
        if (query == null || "".equals(query)) {
            users = userService.list();
        } else {
            users = userService.findUsers(query);
        }
        model.addAttribute("users", users);

        return "/user/list";
    }

    @RequestMapping(
            value = "/delete",
            method = RequestMethod.GET
    )
    protected String deleteUser(Integer id, Model model) {
        userService.delete(id);

        return "redirect:/user/list";
    }


}