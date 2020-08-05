package team1.deal.common.Interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 定义自己的拦截器
 */
@Component
public class MyInterceptor implements HandlerInterceptor {

    /*@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //通过request.getParameter("name");获取控制方法的参数值
        String name = request.getParameter("name");
        //拿到值后做判断
        if (name.equals("chen")){
            //放行
            return true;
        }
        //拦截
        return false;
    }*/
}
