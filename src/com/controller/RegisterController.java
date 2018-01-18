package com.controller;

import com.model.User;
import com.service.UserService;
import netscape.security.UserTarget;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

@Controller
public class RegisterController {
    private UserService userService;

    @Autowired
    private HttpServletRequest request;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value="toRegister.html")
    public String registerPage()
    {
        return "register";
    }


    //注册新用户并登录
    @RequestMapping(value="doRegister.html")
    public ModelAndView doRegister(User user,HttpServletRequest request)
    {
        user.setSex(1);
        user.setCredit(100);

       if(user.getUserName()!=null||user.getPassword()!=null)
       {
           userService.insertNewUser(user);

           user.setLastIp(request.getLocalAddr());
           user.setLastVisit(new Date());

           userService.loginSuccess(user);
           request.getSession().setAttribute("user",user);

           return new ModelAndView("welcome");
       }else {
           return  new ModelAndView("register","error","用户名和密码不能为空");
       }
    }

}
