package top.humg.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 异常处理器：需要存入容器中
 */
public class SysExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest,
                                         HttpServletResponse httpServletResponse, Object o, Exception e) {
        //获取到异常对象
        SysException sysException = null;
        if (e instanceof SysException) {
            sysException = (SysException) e;
            System.out.println("捕捉到异常");
        } else {
            e = new SysException("系统正在维护...");
        }
        ModelAndView modelAndView = new ModelAndView();
        //将错误信息存入到request域errorMsg属性中
        modelAndView.addObject("errorMsg", sysException.getMessage());
        //跳转到error页面
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
