package top.humg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import top.humg.user.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/user")
public class UserController {

    @RequestMapping("/testString")
    public String testString(Model model) {
        System.out.println("testString方法已执行");
        User user = new User();
        user.setUsername("hmg");
        user.setPassword("340222");
        user.setAge(22);
        model.addAttribute("user", user);//存入域中，在success页面中取出展示
        return "success";
    }

    @RequestMapping("/testVoid")
    public void testVoid(HttpServletRequest request, HttpServletResponse response) {
        try {
            //转发在服务器内部进行，所以使用相对路径
//            request.getRequestDispatcher("/WEB-INF/pages/success.jsp").forward(request,response);
            //重定向至testString方法，不可以加”/“
//            response.sendRedirect("testString");
//            response.sendRedirect(request.getContextPath() + "/index.jsp");
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=utf-8");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView() {
        System.out.println("testModelAndView方法已执行");
        //创建对象
        ModelAndView mv = new ModelAndView();
        User user = new User();
        user.setUsername("hmg");
        user.setPassword("340222");
        user.setAge(22);
        //把user对象存入到mv中（也是存入request域中）
        mv.addObject("user", user);
        mv.setViewName("success");//设置跳转页面
        return mv;
    }

    @RequestMapping("/testForward")
    public String testForward() {
        System.out.println("forward");
//        return "forward:/WEB-INF/pages/success.jsp";
        //  路径前不加/表示相对路径，即为/user/index.jsp。加上/表示绝对路径，即为/index.jsp
        return "redirect:/index.jsp";
    }

    @RequestMapping("/testAjax")
    public @ResponseBody
    User testAjax(@RequestBody User user) {
        System.out.println("testAjax");
        //客户端发送的json字符串，框架已经将其封装到user对象中
        System.out.println(user);
        //做出响应
        user.setUsername("已修改");
        return user;
    }
}
