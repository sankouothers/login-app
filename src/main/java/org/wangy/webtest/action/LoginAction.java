package org.wangy.webtest.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;

import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.wangy.webtest.command.LoginForm;
import org.wangy.webtest.command.UserCommand;
import org.wangy.webtest.model.User;
import org.wangy.webtest.service.UserService;
import org.wangy.webtest.until.Constants;


@Controller
public class LoginAction {

    @Autowired
    UserService userService;

    @RequestMapping(
            value = "/login",
            method = RequestMethod.GET
    )
    protected String login() {
        return "login";
    }

    @RequestMapping(
            value = "/xDesktop",
            method = RequestMethod.GET
    )
    protected String myApp() {
        return "xDesktop";
    }


    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST
    )
    @ResponseBody
    protected String onLogin(HttpServletRequest request, LoginForm loginForm, BindingResult result) throws Exception {
        User user = userService.findUser(loginForm.getUsername(), loginForm.getPassword());
        if (user != null) {
            return  "true";
        } else {
            return "false";
        }
    }
}
