package org.wangy.webtest.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartRequest;
import org.wangy.webtest.command.JsonCommand;
import org.wangy.webtest.model.Role;
import org.wangy.webtest.model.User;
import org.wangy.webtest.service.RoleService;
import org.wangy.webtest.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by Administrator on 2015/10/29.
 */
@Controller
@RequestMapping("/x/user")
public class XUserController {

    private final static SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private UserService userService;
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
        int a;
        List<User> users = null;
        String query = request.getParameter("query");
        if (query != null) {
            users = userService.findUsers(query, startSize, limitSize);
            a = userService.getCount(query);
        } else {
            users = userService.list(startSize, limitSize);
            a = userService.getCount();
        }

        for (User user : users) {
            if (user.getBirthDate() != null) {
                user.setBirthDateString(DATE_FORMAT.format(user.getBirthDate()));
            }
            if (user.getRole() != null) {
                user.setRoleId(user.getRole().getId());
            }
        }

        return new JsonCommand(users, a);
    }

    @RequestMapping(
            value = "/create",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected JsonCommand create(@RequestBody User user) {
        user.setId(null);
        Integer id = userService.save(user);
        user = userService.get(id);
        List<User> users = new ArrayList<User>(1);
        users.add(user);
        return new JsonCommand(users);
    }

    @RequestMapping(
            value = "/delete",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected JsonCommand delete(@RequestBody User user) {
        userService.delete(user.getId());
        List<User> users = userService.list();
        return new JsonCommand(users);
    }

    @RequestMapping(
            value = "/update",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected JsonCommand update(@RequestBody User user) {
        if (user.getBirthDateString() != null) {
            try {
                String strDate = user.getBirthDateString();
                Integer roleId = user.getRoleId();
                Role role = roleService.get(roleId);
                if (strDate != null && !"".equals(strDate)) {
                    Date date = DATE_FORMAT.parse(strDate);
                    user.setBirthDate(date);
                }
                user.setRole(role);
                userService.update(user);
                List<User> users = new ArrayList<User>();
                users.add(user);
                if (user.getBirthDate() != null) {
                    user.setBirthDateString(DATE_FORMAT.format(user.getBirthDate()));
                }
                if (user.getRole() != null) {
                    user.setRoleId(user.getRole().getId());
                }
                return new JsonCommand(users);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @RequestMapping(
            value = "/upload",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected String uploadImg(HttpServletRequest httpServletRequest) {
        MultipartRequest request = (MultipartRequest) httpServletRequest;
        MultipartFile file = request.getFile("photo");
        Integer id = Integer.valueOf(httpServletRequest.getParameter("id"));
        String name = file.getName();
        if (!name.endsWith(".jpg")) {
            return "false";
        } else {
            try {
                User user = userService.get(id);
                if (user != null) {
                    user.setPhoto(file.getBytes());
                    userService.update(user);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "true";
        }
    }

    @RequestMapping(
            value = "/photo",
            method = RequestMethod.GET
    )
    @ResponseBody
    protected String getPhoto(HttpServletRequest request) {
        int id = Integer.valueOf(request.getParameter("id"));
        User user = userService.get(id);
        byte[] photo = user.getPhoto();



        return null;
    }


}
