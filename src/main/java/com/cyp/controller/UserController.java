package com.cyp.controller;

import com.cyp.entity.User;
import com.cyp.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by CYP on 2018/6/5.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
   private UserService userService;
    private static Logger log= LoggerFactory.getLogger(UserController.class);
    @RequestMapping(value = "/index")
    public String index(){
        return "index";
    }
    @RequestMapping(value = "/goRegist")
    public String goRegist(){
        return "regist";
    }
    @RequestMapping(value = "/goUserLogin")
    public String goUserLogin(){
        return "userLogin";
    }
    @RequestMapping(value="/test",method= RequestMethod.GET)
    public String test(HttpServletRequest request, Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("userId:"+userId);
        User user=null;
        if (userId==1) {
            user = new User();
            user.setAge(11);
            user.setId(1);
            user.setPassword("123");
            user.setUserName("javen");
        }
        log.debug(user.toString());
        model.addAttribute("user", user);
        return "index";
    }

    @RequestMapping(value = "/regist",method = RequestMethod.POST)
    public String regist(User user,Model model){
        System.out.println("用户注册："+user.getUserName()+user.getPassword()+user.getAge());
        userService.regist(user);
        model.addAttribute("msg", "注册成功");
        //注册成功后跳转success.jsp页面
        return "userLogin";
    }


    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(User user,Model model){
        System.out.println("用户登录："+user);
        /*Map<String, String> map=new LinkedHashMap<String,String>();
        map.put("name", user.getName());
        map.put("password", user.getPassword());*/
        user = userService.login(user.getUserName(),user.getPassword());
        if(user!= null) {
            model.addAttribute("user", user);
            return "success";
        }
        return "fail";
    }

    // /user/showUser?id=1
    @RequestMapping(value="/showUser",method=RequestMethod.GET)
    public String toIndex(HttpServletRequest request,Model model){
        int userId = Integer.parseInt(request.getParameter("id"));
        System.out.println("userId:"+userId);
        User user = this.userService.getUserById(userId);
        log.debug(user.toString());
        model.addAttribute("user", user);
        return "showUser";
    }


}
