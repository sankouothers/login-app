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


/**
 * Created by Yang Wang on 8/15/15.
 *
 * @author $author$
 * @version $Revision$, $Date$
 */
@Controller
public class LoginAction {
    //~ Instance fields --------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     */
    @Autowired
    UserService userService;

    //~ Methods ----------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @return DOCUMENT ME!
     * @throws Exception DOCUMENT ME!
     */
    @RequestMapping(
            value = "/login",
            method = RequestMethod.GET
    )
    protected String login() {
        return "login";
    }

    @RequestMapping(
            value = "/myApp",
            method = RequestMethod.GET
    )
    protected String myApp() {
        return "myApp";
    }
    //~ ------------------------------------------------------------------------------------------------------------------

    /**
     * DOCUMENT ME!
     *
     * @param request   DOCUMENT ME!
     * @param loginForm command DOCUMENT ME!
     * @param result    errors DOCUMENT ME!
     * @return DOCUMENT ME!
     * @throws Exception DOCUMENT ME!
     */
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
} // end class LoginAction
