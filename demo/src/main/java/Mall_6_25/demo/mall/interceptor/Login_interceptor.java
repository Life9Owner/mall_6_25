package Mall_6_25.demo.mall.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Login_interceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if(request.getSession().getAttribute("userId")==null)
        {
            response.sendRedirect(request.getContextPath()+"/login.html");
            return false;
        }
        else
        {
//            return true;
            System.out.println("logined");
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }
    }
}
