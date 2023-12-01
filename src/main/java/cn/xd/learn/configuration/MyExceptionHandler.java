package cn.xd.learn.configuration;

import cn.xd.learn.exception.MyException.MyException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(MyException.class)
    @ResponseBody
    Map<String, String> handlerException(Exception e) {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("code", "0001");
        hashMap.put("message", "message");
        return hashMap;
    }
}
