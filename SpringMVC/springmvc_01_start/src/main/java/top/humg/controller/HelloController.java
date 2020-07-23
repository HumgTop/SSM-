package top.humg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.humg.domain.Account;
import top.humg.domain.User;

@Controller
@RequestMapping("/user")
public class HelloController {

    @RequestMapping(path = "/hello", method = {RequestMethod.POST})//访问此方法的URL
    public String sayHello() {
        System.out.println("hello");
        //控制器返回jsp资源名，Servlet根据此资源名进行页面展示
        return "success";
    }

    @RequestMapping(path = "/test1")
    public String test1(String username) {
        System.out.println("获取到的表单参数username为：" + username);
        return "success";
    }

    /**
     * 把表单提交的参数封装到Javabean对象中
     *
     * @return
     */
    @RequestMapping(path = "/saveAccount")
    public String saveAccount(User user) {
        System.out.println("表单参数已封装到Javabean中");
        System.out.println(user);
        return "success";
    }
}
