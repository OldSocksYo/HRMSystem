package com.controller;

import com.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;

/**
 * @Description:
 * @Author: Yong
 * @CreateDate: 2020/9/20 12:19
 */
@Controller
public class UserController extends BaseController{

    /**
     * 用户登录
     * @param user 表单提交的用户数据
     * @return 返回到相应的页面
     */
    @RequestMapping("/login")
    public String login(HttpServletRequest request, User user) {
        //获取session域中的验证码
        String token = (String)request.getSession().getAttribute(KAPTCHA_SESSION_KEY);
//        System.out.println("token:" + token);
        //移出session域中的验证码
        request.removeAttribute(KAPTCHA_SESSION_KEY);
        //获取用户提交的表单中的验证码
        String code = (String) request.getParameter("code");
        //用于表单用户名回显
        request.setAttribute("username", user.getUsername());
//        System.out.println("code:" + code);
        if (code != null && code.equalsIgnoreCase(token)) {
            User userByUsername = userService.findUserByUsername(user.getUsername());
            if(userByUsername != null && userByUsername.getPassword().equals(user.getPassword())){
                System.out.println("登录成功！username=" + user.getUsername());
                //登录成功后将用户保存到session域中供以后使用
                request.getSession().setAttribute("loginUser", userByUsername);

                return "manage/manage-show";
            }else {
                request.setAttribute("errorMsg", "用户名或者密码错误！");
                return "user/login";
            }
        }else {
            request.setAttribute("errorMsg", "验证码输入有误！");
            return "user/login";
        }
    }

    /**
     * 注销登录
     * @param request 浏览器发送的请求相关信息
     * @return 返回到登录界面
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request){
        //销毁session，清除里面的所有数据
        request.getSession().invalidate();
        //返回到登录界面
        return "redirect:/pages/user/login.jsp";
    }
}
