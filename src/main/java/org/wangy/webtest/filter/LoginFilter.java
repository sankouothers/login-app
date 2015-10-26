package org.wangy.webtest.filter;

import org.wangy.webtest.until.Constants;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.jstl.core.Config;
import java.io.IOException;

/**
 * Created by Administrator on 2015/9/16.
 */
public class LoginFilter implements Filter {

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpServletResponse = (HttpServletResponse) servletResponse;
        HttpSession session = httpServletRequest.getSession();
        //请求的URI
        String path = httpServletRequest.getRequestURI();
        Integer USERNAME_KEY = (Integer) session.getAttribute("LoggedInUserID");
        String USERID_KEY = (String) session.getAttribute("LoggedInUserName");
        //如果请求路径为login  就继续让它执行  不进行拦截
        if (path.equals("/login") || path.endsWith(".css") || path.endsWith(".js")|| path.equals("") ||path.endsWith("/index")
                ||path.endsWith("DownLoadExcel.jsp")) {
            filterChain.doFilter(servletRequest, servletResponse);
            //如果session中有KEY的值则继续让其执行
        }else if (USERID_KEY !=null && USERNAME_KEY !=null){
            filterChain.doFilter(servletRequest, servletResponse);
        }else{
            //其余所有路径都重定向到login.jsp
            httpServletResponse.sendRedirect("/login");
        }

    }

    public void destroy() {

    }
}
