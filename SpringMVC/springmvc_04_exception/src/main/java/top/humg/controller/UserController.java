package top.humg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import top.humg.exception.SysException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testException")
    public String testException() throws Exception {
        System.out.println("testException");
        try {
            int i = 10 / 0;
        } catch (Exception e) {
            e.printStackTrace();
            throw new SysException("查询所有用户错误");
        }
        return "error";
    }
}
