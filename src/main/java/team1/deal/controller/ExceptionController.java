package team1.deal.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import team1.deal.config.properties.CodeMessageProperties;
import team1.deal.model.vo.ExceptionResponseVO;

//统一异常处理
@RestControllerAdvice
@Slf4j
public class ExceptionController {

    @Autowired
    private CodeMessageProperties codeMessageProperties;

    /**
     * 未知异常
     *
     * @param runtimeException 运行时异常
     * @return 异常信息
     */
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ExceptionResponseVO runtimeException(RuntimeException runtimeException) {
        log.error("系统出现错误", runtimeException);
        return new ExceptionResponseVO(50000,runtimeException.getMessage());
    }
}
