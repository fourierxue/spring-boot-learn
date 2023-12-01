package cn.xd.learn.controller;

import cn.xd.learn.exception.MyException.MyException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionHandlerController {
    @RequestMapping("/learn/exceptionHandler")
    Integer learnExceptionHandler() throws MyException {
        if (true) {
            throw new MyException();
        }
        Integer i = 1;
        return i;
    }
}
