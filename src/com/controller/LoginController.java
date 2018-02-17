package com.controller;

import com.model.User;
import com.service.UserService;
import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller

public class LoginController {
    private UserService userService ;

    @Autowired
    public void setUserService(UserService userService)
    {
        this.userService = userService;
    }

    @Autowired
    private HttpServletRequest request;

    @RequestMapping(value="/toLogin.html")
    public String loginPage()
    {
        return "login";
    }

    @RequestMapping(value="/loginCheck.html")
    public ModelAndView loginCheck()
    {
        //System.out.println("进入方法");
        String userName = request.getParameter("userName");
        String password = request.getParameter("password");

        System.out.println(userName);
        System.out.println(password);
        if(userName==null|| password==null ||userName.equals("")||userName.equals(""))
        {
            System.out.println("空");
            return new ModelAndView("login","error","用户名或密码不能为空");
        }else {

            boolean isValidUser = userService.hasMatchUser(userName, password);
            if (!isValidUser) {
                return new ModelAndView("login", "error", "用户名或密码错误");
            } else {
                if (userName.equals("fmd") && password.equals("123"))
                {
                    System.out.println("管理员");
                    return new ModelAndView("manage");

                } else {
                    System.out.println("非管理员");
                    User user = userService.findUserByName(userName);
                    user.setLastIp(request.getLocalAddr());
                    user.setLastVisit(new Date());
                    // System.out.println("匹配成功");
                    userService.loginSuccess(user);
                    request.getSession().setAttribute("user", user);
                    System.out.println("完成方法");

                    return new ModelAndView("welcome");
                }

            }
        }

    }
}
