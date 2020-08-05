package team1.deal.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
public class ExceptionConfig implements HandlerExceptionResolver {


    @Override
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response,
                                         Object handler, Exception ex) {
       /* if (ex instanceof NullPointerException){
            System.out.println("空指针异常");
        }*/

        return null;
    }
}

