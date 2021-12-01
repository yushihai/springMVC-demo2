package com.ysh.mvc.controller;

import com.ysh.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class ParamController {

    @RequestMapping("/testServletAPI")
    public String testServletAPI(HttpServletRequest request){
        HttpSession session=request.getSession();
        String username=request.getParameter("username");
        String pwd=request.getParameter("pwd");
        System.out.println("username="+username+",pwd="+pwd);
        return "success";
    }

    @RequestMapping("/testParam")
    public String testParam(@RequestParam(value = "user_name",required = true) String username,
                            String pwd, String hobby, @RequestHeader("Host")String host,
                            @CookieValue("JSESSIONID")String JSESSIONID){
        System.out.println("username="+username+",pwd="+pwd+",hobby="+hobby+",Host="+host+"sessionID="+JSESSIONID);
        return "success";
    }

    @RequestMapping("/testBean")
    public String testBean(User user){
        System.out.println(user);
        return "success";
    }
}