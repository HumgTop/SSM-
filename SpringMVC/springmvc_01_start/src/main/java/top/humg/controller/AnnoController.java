package top.humg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import top.humg.domain.User;

import java.util.Date;
import java.util.Map;

@Controller
@RequestMapping("/anno")
@SessionAttributes(value = {"msg"}) //把request域中的msg属性存储到session域中
public class AnnoController {

    //配置访问路径
    @RequestMapping("/testRequestParam")
    public String testRequestParam(@RequestParam(name = "username", required = false) String name) {
        System.out.println("testRequestParam方法执行了");
        System.out.println(name);
        return "success";
    }

    /**
     * 获取请求体内容
     *
     * @param body 请求体内容字符串
     * @return
     */
    @RequestMapping("/testRequestBody")
    public String testRequestBody(@RequestBody String body) {
        System.out.println(body);
        return "success";
    }

    @RequestMapping("/testPathVariable/{sid}")
    public String testPathVariable(@PathVariable("sid") String id) {
        System.out.println(id);
        return "success";
    }

    /**
     * 获取请求头信息
     *
     * @param Accept 请求头字符串
     * @return
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(@RequestHeader(name = "Accept") String Accept) {
        System.out.println(Accept);
        return "success";
    }

    /**
     * @param Accept
     * @return
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue(value = "JSESSIONID") String cookieValue) {
        System.out.println(cookieValue);
        return "success";
    }

    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(@ModelAttribute("user") User user) {
        System.out.println(user);
        return "success";
    }

//    @ModelAttribute
//    public void showUser(String uname, Map<String, User> map) {
//        System.out.println("show方法执行了");
//        System.out.println("接收到参数uname为：" + uname);
//        User user = new User();
//        user.setBirth(new Date());
//        map.put("user", user);
//    }

    @RequestMapping("/testSessionAttribute")
    public String testSessionAttribute(Model model) {
        //在request域中存入msg属性
        model.addAttribute("msg", "胡民港");
        return "success";
    }

    @RequestMapping("/testGetSessionAttribute")
    public String testGetSessionAttribute(ModelMap modelMap) {
        //从session域中取msg属性
        String msg = (String) modelMap.get("msg");
        System.out.println(msg);
        return "success";
    }

    /**
     * 清除session内容
     *
     * @param status
     * @return
     */
    @RequestMapping("/testDelSessionAttribute")
    public String testDelSessionAttribute(SessionStatus status) {
        System.out.println("session清除完成");
        status.setComplete();
        return "success";
    }

    /**
     * 被注解的方法会先于控制器中的其他方法执行
     */
//    @ModelAttribute
//    public User showUser(String uname){
//        System.out.println("show方法执行了");
//        System.out.println("接收到参数uname为："+uname);
//        User user = new User();
//        user.setBirth(new Date());
//        return user;
//    }
}
